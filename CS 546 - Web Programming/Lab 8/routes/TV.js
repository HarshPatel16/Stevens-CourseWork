const express= require('express');
const router=express.Router();
const Data = require('../data/shows').shows;

router.get('/', async (req, res) => {
    try {
      res.render('home')
    } catch (e) {
      res.sendStatus(500)
    }
  });

router.post('/Searchshows', async (req, res)=>{
    try{
        const tvshow= await Data.getTVshows(req.body?.show)
        const datapassed= {data:{showName: req.body.show, tvshow }}
        for(let i =0; i<datapassed.data.tvshow.length;i++){
        if(i>4){delete(datapassed.data.tvshow[i])
            }
        }
        res.render('Search', datapassed);
    }
    catch (e) {
        res.status(500)
      }
});

router.get('/shows/:id', async (req,res)=>{
    try{
        const tvshow= await Data.getTVshowsById(req.params.id)
        res.render('Details', {tvshow})
    }
    catch(e){
        res.status(404).json({ error: 'Bad input' })
    }
});


module.exports= router