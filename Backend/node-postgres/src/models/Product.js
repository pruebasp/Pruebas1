const Sequelize = require('sequelize');
const sequelize = require('../dao/dbPostgres');
const Product = sequelize.define('product',{
    id:{
        type: Sequelize.INTEGER,
        autoIncrement: true,
        primaryKey: true
        
    },
    descripcion:{
        type: Sequelize.STRING,
    },
    stock:{
        type: Sequelize.INTEGER,
    },
    price:{
        type: Sequelize.DECIMAL,
    }
},{
    timestamps: false
});

module.exports = Product;