const axios = require('axios');

async function getPeople() {
  const { data } = await axios.get('https://gist.githubusercontent.com/graffixnyc/a1196cbf008e85a8e808dc60d4db7261/raw/9fd0d1a4d7846b19e52ab3551339c5b0b37cac71/people.json')
  return data // this will be the array of people
}

async function getPersonById(Id) {
    
    if (Id === undefined) throw "error";
    else if (typeof Id !== 'string') throw "The input should be a string value";
    Id=Id.trim()
    if (Id.length===0) throw 'error'

const data = await getPeople();
  if (Id > data.length) throw "No such ID exists";
  for (var i=0;i<data.length;i++) {
    if (data[i].id === Id){return data[i];}
    else if(i===data.length-1 && data[i].id !== Id) throw 'person not found'
  }

}

async function sameEmail(emailDomain) {
  
    if (emailDomain === undefined) throw "error";
    else if (typeof emailDomain !== 'string') throw "The input should be a string value";
    emailDomain=emailDomain.trim()
    if (emailDomain.length===0) throw 'error'
    if(!emailDomain.includes(".")) throw 'not a domain'
    if(emailDomain[0]==='.') throw 'starts with .'

    for(let i=0;i<emailDomain.length;i++){
      if(emailDomain[i]==='.' && emailDomain.length-i<3) throw 'not enough characters after .'
    }
    hasNumber = /\d/.test(emailDomain)
    if(hasNumber) throw "domain has number error"

    emailDomain=emailDomain.toLowerCase();
    const data = await getPeople();
    let list = [];
    for(let i = 0; i < data.length; i++) {
        var s=data[i].email
    for(var j=0;j<s.length;j++){
        if(s[j]==='@'){
            st=s.slice(j+1, s.length)
            if(st==emailDomain){list.push(data[i])}
        }
    }
  }
  
  if(list.length<2) throw 'Error since there are not at least two people that have the email domain'
  return list
}


async function manipulateIp() {
  const data = await getPeople();
  let list=[]
  for(let i = 0; i < data.length; i++){
      var Ip= data[i].ip_address
      let ip=''
      for(let j=0;j<Ip.length;j++){
        if(Ip[j]==='.'){
          ip=ip
        }
        else 
        ip+=Ip[j]
      }
      ip=ip.split("").sort().join("");
      ip=parseInt(ip)
      list.push(ip)
    }
    let max=0
    let sum=0
    for(let i=0;i<list.length;i++){
      sum+=list[i]
      if(list[i]>max){
        max=list[i]
      }
    }
    let min=999999999
    for(let i=0;i<list.length;i++){
      if(list[i]<min){
        min=list[i]
      }
    }
    for(let i=0;i<list.length;i++){
      if(list[i]==min){h=i
        FName=data[i].first_name
        LName=data[i].last_name
      }
    }
    for(let i=0;i<list.length;i++){
      if(list[i]==max){m=i
          firstname=data[i].first_name
          lastname=data[i].last_name
      }
    }
    average = Math.floor( sum/ list.length);
    return {highest: { firstName: firstname, lastName: lastname },
            lowest: { firstName: FName, lastName: LName },
            average
    }

}

async function sameBirthday(month, day){
  if(!month || !day || isNaN(Number(month)) || isNaN(Number(day))) throw 'Month or day is not valid!'
  if(month>12) throw 'Month greater than 12'
  if(month<1)  throw 'Month can not be negetive'
  const MaxofMonth = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
  if(day>MaxofMonth[month-1]) throw 'Not valid day for given month'
  const data = await getPeople();
  list=[]
  for(let i = 0; i < data.length; i++){
  var date= data[i].date_of_birth
  var Month=Number(10*date[0])+Number(date[1])
  var Day=Number(10*date[3])+Number(date[4])

  if(typeof month=== 'string' || typeof day=== 'string'){
    month=parseInt(month)
    day=parseInt(day)
  }
  if(Month===month && Day===day){
    list.push(data[i].first_name+" "+data[i].last_name)
  }
}
if(list.length==0) throw 'No people with that birthday'
return list;
}

module.exports = {
  getPeople,
  getPersonById,
  sameEmail,
  manipulateIp,
  sameBirthday
}