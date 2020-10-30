//jshint esversion:6

const express = require('express');
const app = express();
const port = 3000;

app.get('/', (req, res) => {
  res.send('<h1>You successfully made a get request, and this is the ansver</h1>');
});

app.get('/info', (req, res) => {
    res.send('<h1>You\'re on info page now</h1>');
});

app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`);
});