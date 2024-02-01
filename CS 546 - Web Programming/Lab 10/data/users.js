const get = require('../config/mongoCollections');
const getCollection= get.users;
const bcrypt = require('bcryptjs');
const saltRounds = 14;

module.exports={
    async createUser(username, password){
        username=username.toLowerCase();
        if (!username || !password) {
            throw new Error('Username and password must be supplied');
          }
          if (username.length < 4 || !/^[a-z\d]+$/i.test(username)) {
            throw new Error('Username should be at least 4 alphanumeric characters with no spaces');
          }
          if (password.length < 6 || /^[\s]+$/.test(password)) {
            throw new Error('Password should be at least 6 characters with no spaces');
          }
        
        const hashedPassword = await bcrypt.hash(password, saltRounds);
        const UserData = await getCollection();

        const exist = await UserData.findOne({ username });
        if(exist){throw new Error('Username already exists');}

        const user = await UserData.insertOne({ username, password: hashedPassword });
        
        if (!user) {
            return { userInserted: false };
        }
            return { userInserted: true };
    },
    async checkUser(username, password){
        username=username.toLowerCase();
        if (!username || !password) {
            throw new Error('Username and password must be supplied');
          }
          if (username.length < 4 || !/^[a-z\d]+$/i.test(username)) {
            throw new Error('Username should be at least 4 alphanumeric characters with no spaces');
          }
          if (password.length < 6 || /^[\s]+$/.test(password)) {
            throw new Error('Password should be at least 6 characters with no spaces');
          }
        
            const UserData = await getCollection('users');
            const user = await UserData.findOne({ username });
            if (!user) {
              throw new Error('Either the username or password is invalid');
            }
            
            const comp = await bcrypt.compare(password,user.password)
            
            if (!(comp)) {
                throw new Error('Either the username or password is invalid');
            }
            return { authenticated: true };

    }
}