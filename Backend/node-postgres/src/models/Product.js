const Sequelize = require('sequelize');
const sequelize = require('../database/database');
const Product = sequelize.define('product',{
    id:{
        type: Sequelize.INTEGER,
        primaryKey: true
    },
    descripcion:{
        type: Sequelize.TEXT
    },
    stock:{
        type: Sequelize.INTEGER
    },
    price:{
        type: Sequelize.DECIMAL
    }
},{
    timestamps: false
});

module.exports = Product;