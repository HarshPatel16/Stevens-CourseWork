const data = require('../data');
const bands = data.bands;
const express = require('express');
const router = express.Router();

router
    .route('/:id')
    .get(async (req, res) => {
        try {
            const peopleById = await bands.get(req.params.id);
            res.send(peopleById);
        } catch (e) {
            res.status(500).send(e);
        }
    })
    .post(async (req, res) => {
        res.send('POST request to http://localhost:3000/bands');
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
        res.send('DELETE request to http://localhost:3000/bands');
    });

module.exports = router;