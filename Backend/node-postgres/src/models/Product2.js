const moongoose = require('mongoose');
const { Schema } = moongoose;

const ProductSchema=new Schema({
    descripcion:{ type: String, required: true},
    stock:{ type: Number, required: true},
    price:{ type: Number, required: true}
});

module.exports = moongoose.model('Product',ProductSchema);


