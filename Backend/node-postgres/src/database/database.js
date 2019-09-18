const Sequelize = require('sequelize');

const sequelize = new Sequelize(
    'postgres',
    'postgres',
    '123456789',
    {
        host: '192.168.0.23',
        port:'6002',
        dialect: 'postgres',
        pool:{
            max: 5,
            min: 0,
            require: 30000,

        }
    }
)
module.exports = sequelize;