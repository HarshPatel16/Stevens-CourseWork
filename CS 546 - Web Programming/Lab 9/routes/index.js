const constructorMethod = app => {
 
  app.use("/", (req, res) => {
    res.render("static");
  });
  
  app.use("*", (req, res) => {
    res.redirect("/");
  });
};

module.exports = constructorMethod;