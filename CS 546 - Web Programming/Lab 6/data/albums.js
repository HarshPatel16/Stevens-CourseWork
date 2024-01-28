const mongoCollections = require('../config/mongoCollections');
const albums = mongoCollections.albums;
const bands = mongoCollections.bands;
const { ObjectId } = require('mongodb');

module.exports ={
    async create(bandId, title, releaseDate,tracks,rating){
        var _id= new ObjectId();
        let album={
            _id,
            title,
            releaseDate,
            tracks,
            rating    
        }
        const bandCollection= await bands();
        const albumwithId = await bandCollection.updateOne({_id: new ObjectId(bandId)},
        { 
            "$push": {
                "albums": album
            }
        });
        return album
    },
    async getAll(bandId){
        const bandCollection= await bands();
        const albumsofband= await bandCollection.find({ _id: ObjectId(bandId) },{"albums.$": true}).toArray();
        if (albumsofband === null) throw 'No band with that id';
        return albumsofband
    },

    async get(albumId){
        if(!albumId || typeof albumId != 'string') throw 'Not valid Id';
        const albumCollection=await bands();
        const albumwithId = await albumCollection.find({"albums._id": new ObjectId(albumId)}, {"albums.$": true}).toArray();
        return albumwithId;
         
    },

    async remove(albumId){

        if(!albumId || typeof albumId != 'string') throw 'Not valid Id';
        const albumCollection=await bands();
        const removing=await albumCollection.deleteOne({"albums._id": new ObjectId(albumId)}, { $set: {'albums':[]}},{"albums.$": true});
        return removing
    },
    
    }
