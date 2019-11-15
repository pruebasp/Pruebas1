const Sequelize = require('sequelize');
var config= require('config');
//123456789 password
//         port:'6002', 192.168.0.200
var entorno= config.util.getEnv('NODE_ENV');
var strconex=config.get('strconex');

const sequelize = new Sequelize(
    strconex.database,
    strconex.username,
    strconex.password,
    {
        host: '192.168.0.200',
        dialect: strconex.dialect,
        port: strconex.port,
        pool:{
            max: 5,
            min: 0,
            require: 30000,
            iddle: 10000
        }
    }
)
module.exports = sequelize;