const express = require('express');
const router = express.Router();

router.get("/", (req, res) => {
  res.render("/static");
});

router.post("/", (req, res) => {
  res.render("/static");
});

    module.exports = router;