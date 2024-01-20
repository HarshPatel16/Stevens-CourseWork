const axios = require('axios');
const people = require('./people');

async function getStocks() {
    const { data } = await axios.get('https://gist.githubusercontent.com/graffixnyc/8c363d85e61863ac044097c0d199dbcc/raw/7d79752a9342ac97e4953bce23db0388a39642bf/stocks.json')
    return data // this will be the array of stocks objects
}
async function getPeople() {
    const { data } = await axios.get('https://gist.githubusercontent.com/graffixnyc/a1196cbf008e85a8e808dc60d4db7261/raw/9fd0d1a4d7846b19e52ab3551339c5b0b37cac71/people.json')
    return data // this will be the array of people
  }


async function listShareholders(stockName){
    if(!stockName || typeof stockName != 'string') throw 'not valid parameter';
    if(stockName.trim().length == 0) throw 'stockName is empty';
    const data = await getStocks();
    for(let i = 0; i < data.length; i++) {
        if(data[i].stock_name===stockName){
            for(let j=0;j<data[i].shareholders.length;j++){
               var x = await people.getPersonById(data[i].shareholders[j].userId);
                data[i].shareholders[j].firstname=x[j].first_name
                data[i].shareholders[j].lastname=x[j].last_name
                delete data[i].shareholders[j].userId
            }
            return data[i]
        }
    }
}

async function totalShares(stockName){
    if(!stockName || typeof stockName != 'string') throw 'not valid stockname!';
    if(stockName.trim().length == 0) throw 'stockName is empty string!';

    const data = await getStocks();

    for(let i=0;i<data.length;i++){
        if(data[i].stock_name===stockName){
            let sum=0
            let count=0
            for(let j=0;j<data[i].shareholders.length;j++){
            count++
            sum+=data[i].shareholders[j].number_of_shares
            }
            if(sum===0){return stockName+" currently has no shareholders"}
            else return stockName+", has "+count+" shareholders that owns a total of "+sum+" shares."
        }
    }
    throw 'No stock with that name'
}

async function listStocks(firstName, lastName){
    if(!firstName || typeof firstName != 'string' || !lastName || typeof lastName != 'string') throw 'Name is not valid!';
    if(firstName.trim().length == 0 || lastName.trim().length == 0) throw 'Name is empty string';

    const data= await getStocks();
    const peopleList = await getPeople();
    let userId
    for(let i=0;i<peopleList.length;i++) {
        if(peopleList[i].first_name == firstName && peopleList[i].last_name == lastName){
            userId=peopleList[i].id
        }
    }
    if(userId===undefined) throw 'person not found'
    let result=[]
    for(let i=0;i<data.length;i++){
        for(let j=0;j<data[i].shareholders.length;j++){
            if(data[i].shareholders[j].userId==userId){
                result.push({stock_name: data[i].stock_name, number_of_shares: data[i].shareholders[j].number_of_shares})
                break
            }
        }
    }
    return result
}

async function getStockById(id){
    if(!id || typeof id != 'string') throw 'Id is not valid!';
    if(id.trim().length == 0) throw 'Id is empty string!';
    const data= await getStocks();
    for(let i=0;i<data.length;i++){
        if(id===data[i].id) return data[i]
    }
    throw 'stock not found'
}

module.exports = {
    getStocks,
    listShareholders,
    totalShares,
    listStocks,
    getStockById
}
