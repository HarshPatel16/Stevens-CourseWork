const axios = require('axios');

let exportedMethods= {
    async getTVshows(q) {
    const { data } = await axios.get('http://api.tvmaze.com/search/shows?q='+q);
    return data;
    },

    async getTVshowsById(id){
    const {data} = await axios.get('http://api.tvmaze.com/shows/'+id)
    return data;
}
}

module.exports= {
    shows: exportedMethods
}
