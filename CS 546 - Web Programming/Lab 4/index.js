const bands = require('./data/bands');
const connection = require('./config/mongoConnection');

const main = async () => {
    const db = await connection.connectToDb();
    //    await db.dropDatabase();
    
    try {
        const pinkFloyd = await bands.create('Pink Floyd', ["Progressive Rock", "Psychedelic rock", "Classic Rock"], 'http://www.pinkfloyd.com', 'EMI', ["Roger Waters", "David Gilmour", "Nick Mason", "Richard Wright", "Sid Barrett" ], 1965 );
        console.log(pinkFloyd);
    } 
    catch (e) {
        console.log(e);
    }
    //
    // try {
    //     const linkinPark = await bands.get("65ac46013ebe708ef9065c14"); 
    //     console.log(linkinPark);
    // }
    // catch (e) {
    //     console.log(e);
    // }

    // try {
    //     const pinkFloyd = await bands.create("The Beatles", ["Rock", "Pop", "Psychedelia"], "http://www.thebeatles.com", "Parlophone",["John Lennon", "Paul McCartney", "George Harrison", "Ringo Starr"],1960);
    //     //console.log(pinkFloyd);
    // } 
    // catch (e) {
    //     console.log(e);
    // }

    // try{
    //     const list = await bands.getAll()
    //     console.log(list)
    // }
    // catch(e){
    //     console.log(e)
    // }

    // try {
    //     const pinkFloyd = await bands.create("Linkin Park", ["Alternative Rock", "Pop Rock", "Alternative Metal"], "http://www.linkinpark.com", "Warner",["Chester Bennington", "Rob Bourdon", "Brad Delson", "Mike Shinoda", "Dave Farrell", "Joe Hahn"],1996);
    //     console.log(pinkFloyd);
    // } 
    // catch (e) {
    //     console.log(e);
    // }

    // try {
    //     const renaming = await bands.rename("65ac4fe72a71d88bcf76874b", "Led Zeppelin");
    //     console.log(renaming);
    // }
    // catch (e) {
    //     console.log(e);
    // }

    // try {
    //     const linkinPark = await bands.get("620c40518b4eef25fb2c9b79"); 
    //     console.log(linkinPark);
    // }
    // catch (e) {
    //     console.log(e);
    // }

    // try{
    //     const rem= await bands.remove("65ac579318b4f5f276af9e0f")
    //     console.log(rem)
    // }
    // catch(e){
    //     console.log(e)
    // }

    // try{
    //     const list = await bands.getAll()
    //     console.log(list)
    // }
    // catch(e){
    //     console.log(e)
    // }

    // try {
    //     const pinkFloyd = await bands.create("The Beatles", ["Rock", "Pop", "Psychedelia"], "http://www.the.com", "Parlophone",["John Lennon", "Paul McCartney", "George Harrison", "Ringo Starr"],1960);
    //     console.log("band has been added")
    //     console.log(pinkFloyd);
    // } 
    // catch (e) {
    //     console.log(e);
    // }

    // try{
    //     const rem= await bands.remove("620c40518b4eef25fb2b7a")
    //     console.log(rem)
    // }
    // catch(e){
    //     console.log(e)
    // }
    
    // try {
    //     const renaming = await bands.rename("620c40518b4eef2b2c9b79", "Renamed"); 
    //     console.log(renaming);
    // }
    // catch (e) {
    //     console.log(e);
    // }

    // try {
    //     const renaming = await bands.rename("620c40518b4eef25fb2c9b79",123); 
    //     console.log(renaming);
    // }
    // catch (e) {
    //     console.log(e);
    // }

    // try {
    //     const data = await bands.get("620c40518b4eef252c9b79"); 
    //     console.log(data);
    // }
    // catch (e) {
    //     console.log(e);
    // }

    }
    main()