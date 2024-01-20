const people = require("./people");
const stocks = require("./stocks");

//Test File
async function main() {
    try{
        const peopledata = await people.getPeople();
        console.log (peopledata);
    }catch(e){
        console.log (e);
    }
    // try{
    //   const stocksdata = await stocks.getStocks();
    //   console.log (stocksdata);
    // }catch(e){
    //     console.log (e);
    // }
    // try {
    //   console.log(await people.getPersonById("37471578-49ea-4da1-82fb-febff97ecd6c"))
    // }
    //  catch (e) {
    //   console.log(e);
    // }
    // try {
    // console.log(await people.sameEmail("harvard.edu"))
    // }
    // catch (e) {
    // console.log(e);
    // }
    // try {
    //   console.log(await people.manipulateIp())
    //   }
    //   catch (e) {
    //   console.log(e);
    //   }
    // try {
    //   console.log(await people.sameBirthday(9, 25))
    //   }
    //   catch (e) {
    //   console.log(e);
    //   }
    // try {
    //   console.log(await stocks.listShareholders("Aeglea BioTherapeutics, Inc."));
    // } catch (e) {
    //   console.log(e);
    // }
    // try {
    //   console.log(await stocks.totalShares('Deltic Timber Corporation'));
    // } catch (e) {
    //   console.log(e);
    // }
    // try{
    //   console.log(await stocks.listStocks("Grenville", "Pawelke"))
    // } catch(e){
    //   console.log(e);
    // }
    // try{
    //   console.log(await stocks.getStockById("f652f797-7ca0-4382-befb-2ab8be914ff0"))
    // } catch(e){
    //   console.log(e);
    // }
}
main()
