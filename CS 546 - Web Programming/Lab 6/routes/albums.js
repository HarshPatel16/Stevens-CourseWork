const data = require('../data');
const albums = data.albums;
const express = require('express');
const router = express.Router();

router
    .route('/:id')
    .get(async (req, res) => {
            const peopleById = await albums.get(req.params.id);
            res.send(peopleById);
        
    })
    .post(async (req, res) => {
        const updatedBand = await albums.create(req.params.id, req.body);
        res.send(updatedBand);
    })
    .put(async (req, res) => {
        const updatedPeopleById = await bands.update(req.params.id, req.body);
        res.send(updatedPeopleById);
    })
    .delete(async (req, res) => {
        const deletedPeopleById = await albums.remove(req.params.id);
        res.send({"albumId": id, "deleted": true});
    });

router
    .route('/album/:id')
    .get(async (req, res) => {
        try {
            const peopleById = await albums.get(req.params.id);
            const p = peopleById.filter((p) => p._id == req.params.id);
            res.send(p[0]);
        } catch (e) {
            res.status(500).send(e);
        }
    })
    .post(async (req, res) => {
        const updatedBand = await albums.create(req.params.id, req.body);
        res.send(updatedBand);
    })
    .put(async (req, res) => {
        const updatedPeopleById = await bands.update(req.params.id, req.body);
        res.send(updatedPeopleById);
    })
    .delete(async (req, res) => {
        const deletedPeopleById = await bands.remove(req.params.id);
        res.send(deletedPeopleById);
    });    

router
    .route('/')
    .get(async (req, res) => {
        try {
            const peopleList = await bands.getAll();
            res.json(peopleList);
        } catch (e) {
            res.status(500).send(e);
        }
    })
    .post(async (req, res) => {
        const peopleList = await bands.create(req.body);
        res.send(req.body);
    })
    .delete(async (req, res) => {
        res.send('DELETE request to http://localhost:3000/albums');
    });

module.exports = router;