exports.logger = (req, res, next) => {
  const time = new Date().toUTCString();
  if(req.session.authCookie?.username){
  console.log(`[${time}]: ${req.method} ${req.originalUrl} (Authenticated User)`);}
  else{
    console.log(`[${time}]: ${req.method} ${req.originalUrl} (Non-Authenticated User)`);}  
  
  next();
};

exports.isAuth = (req, res, next) => {
  if (!req.session.authCookie?.username) {
    return res.status(403).render('unAuthenticated');
  }
  next();
};