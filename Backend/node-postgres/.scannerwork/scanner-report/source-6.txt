var config= require('config');
var product;
console.log('NODE_ENV: ' + config.util.getEnv('NODE_ENV'));
if(config.util.getEnv('NODE_ENV')=='dbmongo'){
    product= require('../businessService/service2');
}
else{
    product= require('../businessService/service');
}

module.exports= product;