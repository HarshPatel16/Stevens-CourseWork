const dbConnection = require('./config/mongoConnection');
const data = require('./data');
const bands = data.bands;
const albums = data.albums;

async function main() {
  const db = await dbConnection.connectToDb();
//   try{
//       const ks= await bands.getAll()
//       console.log(ks);
//   }
//   catch(e){
//     console.log(e);
//   }
  try{
    const ks = await albums.getByAlbumId("622c00351719633e75810cb8")
    console.log(ks);
}
catch(e){
  console.log(e);
}
}
main()