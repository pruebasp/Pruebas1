const Product= require('../models/Product2');

// Crear producto
async function createProduct(producto){
    const{descripcion, stock,price} = producto;
    const newProduct = new Product({descripcion, stock,price});
    await newProduct.save();
    return newProduct;
}

// Mostrar productos
async function getProducts(res){
    const products= await Product.find({});
    res.json(products);
    return products;
}

// Modificar producto
async function updateProduct(ide,nproducto){
    const {id}= ide;
    const {descripcion,stock,price}=nproducto;

    await Note.findByIdAndUpdate(id, {descripcion,stock, price});
}
//Eliminar
async function deleteProduct(ide){
    const {id}= ide;
    await Product.findByIdAndDelete(id);
}
module.exports={createProduct,getProducts,deleteProduct,updateProduct};
