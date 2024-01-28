const Routes = require('./TV');

const constructorMethod = (app) => {
  app.use('/', Routes);

  app.use('*', (req, res) => {
    res.status(404).json({ error: 'Resource Not found' });
  });
};

module.exports = constructorMethod;