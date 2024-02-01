const express = require('express');
const session = require('express-session');
const expressHandlebars = require('express-handlebars');
const connect  = require('./config/mongoConnection');
const routes = require('./routes/users');
const { logger } = require('./middleware');

const app = express();


app.engine('handlebars', expressHandlebars.engine({ defaultLayout: 'main' }));
app.set('view engine', 'handlebars');

app.use(
  session({
    name: 'AuthCookie',
    secret: "This is a secret.. shhh don't tell anyone",
    resave: false,
    saveUninitialized: true,
  })
);
app.use('/public', express.static('public'));
app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(logger);
app.use('/', routes);

connect.connectToDb();

app.listen(3000, () => {
  console.log("We've now got a server!");
  console.log('Your routes will be running on http://localhost:3000');
});
