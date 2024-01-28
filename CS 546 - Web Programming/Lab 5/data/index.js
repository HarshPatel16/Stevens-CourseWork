const peopledata = require('./userApi');

module.exports = {
    people: peopledata.getPeople,
    work: peopledata.getWork
};