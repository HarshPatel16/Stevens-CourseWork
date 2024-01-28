const mongoCollections = require('../config/mongoCollections');
const bands = mongoCollections.bands;
const albums = require('./albums');
const {ObjectId} = require('mongodb');

module.exports = {

    async create(name, genre, website, recordLabel, bandMembers, yearFormed, Albums, overallRating){
        if(!name || !genre || !website || !recordLabel || !bandMembers || !yearFormed) throw "All fields need to have valid values"
        if (name.trim().length === 0 || website.trim().length ===0 || recordLabel.trim().length ===0) throw "Do not enter empty parameter"
        if(typeof name !=='string') throw "Not a valid name"
        if(typeof genre !=='object') throw "Not valid genre"
        if(typeof website !=='string') throw "Not valid website"
        if(typeof recordLabel !=='string') throw "Not a valid recordLabel"
        if(typeof bandMembers !=='object') throw "Not valid type for Band Members"
        if(typeof yearFormed !=='number' || yearFormed<1900 || yearFormed>2022) throw "Not valid year"
        if(genre.length===0) throw "Empty genre" 
        if(bandMembers.length===0) throw "Empty bandMembers"
        for(var i=0;i<genre.length;i++){if(typeof genre[i]!=='string') throw "Not valid genre element"}
        for(var i=0;i<bandMembers.length;i++){if(typeof bandMembers[i]!=='string') throw "Not valid band member"}
        if(!website.includes("http://www.",0)) throw "Website does not have valid format"
        if(!website.includes(".com")) throw "Website does not have .com"
        let index=website.indexOf(".com")
        if(!((index-10)>5)) throw "Website name length should be greater than 5"
    
        let newBand = {
            name: name,
            genre: genre,
            website:website,
            recordLabel:recordLabel,
            bandMembers:bandMembers,
            yearFormed:yearFormed,
            albums:Albums,
            overallRating:overallRating

          };
          const bandCollection = await bands();
    
        const insertInfo = await bandCollection.insertOne(newBand);
        if (!insertInfo.acknowledged || !insertInfo.insertedId) throw 'Could not add band';
    
            const newId = insertInfo.insertedId.toString();
    
            const band = await this.get(newId);
            return band;
    },
    
    async getAll(){
        const bandCollection = await bands();
        const band= await bandCollection.find({}).toArray()
        if(!band) throw 'Could not get bands'
        return band
    },
    
    async get(id) {
        if (!id) throw 'You must provide an id to search for';
        if (typeof id !== 'string') throw 'Id must be a string';
        if (id.trim().length === 0) throw 'Id cannot be an empty string or just spaces';
        id = id.trim();
        if (!ObjectId.isValid(id)) throw 'invalid object ID';
            const bandCollection = await bands();
            const band = await bandCollection.findOne({ _id: ObjectId(id) });
        if (band === null) throw 'No band with that id';
        
            return  band;
    },
    
    async remove(id){
        if (!id) throw 'You must provide an id to remove';
        if (typeof id !== 'string') throw 'Id must be a string';
        if (id.trim().length === 0) throw 'Id cannot be an empty string or just spaces';
        id=id.trim()
        if (!ObjectId.isValid(id)) throw 'invalid object ID';
    
        const bandCollection= await bands()
        const info = await bandCollection.deleteOne({ _id: ObjectId(id) });
    
        if (info.deletedCount === 0) {throw 'Could not delete band';}
    
        return { deleted: true };
    },
    async update(id, newname, newgenre, newwebsite, newrecordLabel, newbandMembers, newyearFormed){
        if(!id || !newname || !newgenre || !newwebsite || !newrecordLabel || !newbandMembers || !newyearFormed) throw "All fields need to have valid values"
        if (newname.trim().length === 0 || newwebsite.trim().length ===0 || newrecordLabel.trim().length ===0) throw "Empty parameter"
        if (!ObjectId.isValid(id)) throw 'invalid object ID';
        if(!newwebsite.includes("http://www.",0)) throw "Website does not have valid format"
        if(!newwebsite.includes(".com")) throw "Website does not have .com"
        let index=newwebsite.indexOf(".com")
        if(!((index-10)>5)) throw "Website name length should be greater than 5"
        if( typeof id != 'string' || id.length == 0 || 
            typeof newname != 'string' || newname.length == 0 || 
            typeof newwebsite != 'string' || newwebsite.length == 0 || 
            typeof newrecordLabel != 'string' || newrecordLabel.length == 0) throw "Not valid parameters"
        
        if(typeof newgenre !== 'object'|| typeof newbandMembers!=='object') throw "Not valid parameter"
        if(typeof newyearFormed !=='number' || newyearFormed<1900 || newyearFormed>2022) throw "Not valid year"
        
        const bandCollection = await bands();
        const updateBand={
            name:newname,
            genre:newgenre,
            website:newwebsite,
            recordLabel:newrecordLabel,
            bandMembers:newbandMembers,
            yearFormed:newyearFormed
        }
        const updatedInfo=bandCollection.updateOne(
            { _id: ObjectId(id) },
            {  $set: updateBand}
        );
        if (updatedInfo.modifiedCount === 0) {
            throw 'could not update band successfully';
          }
          return await this.get(id);
    }
    
}