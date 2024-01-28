const mongoCollections = require('../config/mongoCollections');
const bands = mongoCollections.bands;
const { ObjectId } = require('mongodb');

module.exports = {

async create(name, genre, website, recordLabel, bandMembers, yearFormed){
    if(!name || !genre || !website || !recordLabel || !bandMembers || !yearFormed) throw "Provide valid parameter"
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
        yearFormed:yearFormed
      };
      const bandCollection = await bands();

      const insertInfo = await bandCollection.insertOne(newBand);
      if (!insertInfo.acknowledged || !insertInfo.insertedId)
      throw 'Could not add band';

      const newId = insertInfo.insertedId.toString();

      const band = await this.get(newId);
      return band;
},

async getAll(){
    const bandCollection = await bands();
    const band= await bandCollection.find({}).toArray()
    band.forEach(element => {
      element._id = element._id.toString();
    });
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
    band._id = band._id.toString();

    return band;
},

async remove(id){
    if (!id) throw 'You must provide an id to remove';
    if (typeof id !== 'string') throw 'Id must be a string';
    if (id.trim().length === 0) throw 'Id cannot be an empty string or just spaces';
    id=id.trim()
    if (!ObjectId.isValid(id)) throw 'invalid object ID';

    const bandCollection= await bands();
    const bandCollection_name = (await this.get(id)).name;
    if(!bandCollection_name) throw 'Could not delete band';

    const info = await bandCollection.deleteOne({ _id: ObjectId(id) });

    if (info.deletedCount === 0) {throw 'Could not delete band';}

    return `${bandCollection_name} has been successfully deleted!`;
},

async rename(id, newName){
    if (!id) throw 'You must provide an id to rename';
    if (typeof id !== 'string') throw 'Id must be a string';
    if (id.trim().length === 0) throw 'Id cannot be an empty string or just spaces';
    id=id.trim()
    if (!ObjectId.isValid(id)) throw 'invalid object ID';
    if (!newName) throw 'You must provide new name to rename';
    if (typeof newName !== 'string') throw 'Name must be a string';
    if (newName.trim().length === 0) throw 'Name cannot be an empty string or just spaces';

    const bandCollection = await bands();
    const updateBand = {
        name: newName
      };
      const updatedInfo = await bandCollection.updateOne(
        { _id: ObjectId(id) },
        { $set: updateBand }
      );
      if (updatedInfo.modifiedCount === 0) {
        throw 'could not update band successfully';
      }
      return await this.get(id);
}
}