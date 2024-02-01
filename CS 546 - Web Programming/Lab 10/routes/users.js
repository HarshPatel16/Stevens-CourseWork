const { Router } = require('express');
const { checkUser, createUser } = require('../data/users');
const {isAuth}=require('../middleware');
const router = Router();

router.get('/', async (req, res) => {
  if (req.session.authCookie?.username) {
    return res.redirect('/private');
  }
  res.render('login');
});

router.get('/signup', async (req, res) => {
  if (req.session.authCookie?.username) {
    return res.redirect('/private');
  }
  res.render('signup');
});

router.post('/signup', async (req, res) => {
  try {
    const { username, password } = req.body;
    if (!username || !password) {
        throw new Error('Username and password must be supplied');
      }
      if (username.length < 4 || !/^[a-z\d]+$/i.test(username)) {
        throw new Error('Username should be at least 4 alphanumeric characters with no spaces');
      }
      if (password.length < 6 || /^[\s]+$/.test(password)) {
        throw new Error('Password should be at least 6 characters with no spaces');
      }
    const status = await createUser(username, password);
    if (!status.userInserted) {
      return res.render('signup');
    }
    res.redirect('/');
  } catch (error) {
    res.status(400).render('signup', { error: error.message });
  }
});

router.post('/login', async (req, res) => {
  try {
    const { username, password } = req.body;
    const status = await checkUser(username, password);
    if (status.authenticated) {
      req.session.authCookie = { username };
      return res.redirect('/private');
    }
  } catch (error) {
    res.status(400).render('login', { error: error.message });
  }
});

router.get('/private', isAuth, (req, res) => {
  res.render('private', { name: req.session.authCookie.username });
});

router.get('/logout', (req, res) => {
  req.session.destroy();
  res.redirect('/');
});

module.exports = router;

