const express = require('express');
const router = express.Router();
const data = require('../data/index');
const peopledata = data.people;
const workData = data.work;


router
    .route('/people/:id')
    .get(async (req, res) => {
        try {
            if(req.params.id <= 0) throw "Id is not valid!";
            if(typeof(req.params.id) !== "Number") throw "Id is not a number!";
            const people = await peopledata();
            const id = req.params.id;
            let person = null;
            for(let i=0;i<people.length;i++) {
                if(people[i].id == id) 
                    person = people[i];
            }
            if(person){
                    res.json(person);
            }
            else{
                res.json({err: `Person with id ${id} not found`});
            }
            } catch (e) {
            res.status(500).send(e);
        }
    })
    .post(async (req, res) => {
        res.send('POST request to http://localhost:3000/posts');
    })
    .delete(async (req, res) => {
        res.send('DELETE request to http://localhost:3000/posts');
    });

router
    .route('/people')
    .get(async (req, res) => {
        try {
            const people = await peopledata();
            res.json(people);
        } catch (e) {
            res.status(500).send(e);
        }
    })
    .post(async (req, res) => {
        res.send('POST request to http://localhost:3000/posts');
    })
    .delete(async (req, res) => {
        res.send('DELETE request to http://localhost:3000/posts');
    });

router
    .route('/work/:id')
    .get(async (req, res) => {
        try {
            if(req.params.id <= 0) throw "Id is not valid!";
            if(typeof(req.params.id) !== "Number") throw "Id is not a number!";
            const workList = await workData();
            const id = req.params.id;
            let work = null;
            for(let i=0;i<workList.length;i++) {
                if(workList[i].id == id){
                    work = workList[i];
            }
            }
            if(work){
                    res.json(work)
            } 
            else{
                res.json({err: `Work with id ${id} not found`});
            }
        } catch (e) {
            res.status(500).send(e);
        }
    })
    .post(async (req, res) => {
        res.send('POST request to http://localhost:3000/posts');
    })
    .delete(async (req, res) => {
        res.send('DELETE request to http://localhost:3000/posts');
    });

router
    .route('/work')
    .get(async (req, res) => {
        try {
            const workList = await workData();
            res.json(workList);
        } catch (e) {
            res.status(500).send(e);
        }
    })
    .post(async (req, res) => {
        res.send('POST request to http://localhost:3000/posts');
    })
    .delete(async (req, res) => {
        res.send('DELETE request to http://localhost:3000/posts');
    });
    
module.exports = router;

