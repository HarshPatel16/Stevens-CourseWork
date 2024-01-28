const dbConnection = require('./config/mongoConnection');
const data = require('./data');
const bands = data.bands;
const albums = data.albums;

async function main() {
  const db = await dbConnection.connectToDb();
  //await db.dropDatabase();
try{
  const albumofpinkfloyd= [await albums.create("603d992b919a503b9afb856e","Wish You Were Here","09/12/1975",["Shine On You Crazy Diamond, Pts. 1-5", "Welcome to the Machine","Have a Cigar (Ft. Roy Harper)", "Wish You Were Here","Shine On You Crazy Diamond, Pts. 6-9"],5)]
  const pinkfloyd = await bands.create("Pink Floyd",["Progressive Rock", "Psychedelic rock", "Classic Rock"],"http://www.pinkfloyd.com","EMI",["Roger Waters", "David Gilmour", "Nick Mason", "Richard Wright", "Sid Barrett" ],1965,albumofpinkfloyd,0);
  console.log(pinkfloyd);
}
catch (e) {
  console.log(e);
}

  
  console.log('Done seeding database');

  await dbConnection.closeConnection();
}

main();