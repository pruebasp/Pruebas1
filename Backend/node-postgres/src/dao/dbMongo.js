const mongoose = require('mongoose');
var config= require('config');

console.log('NODE_ENV: ' + config.util.getEnv('NODE_ENV'));
var strconex= config.get('strconex')
mongoose.connect(strconex.str,{
    useCreateIndex: true,
    useNewUrlParser: true,
    useFindAndModify: false
})
.then(db =>console.log('DB is conected'))
.catch(err => console.error(err));
