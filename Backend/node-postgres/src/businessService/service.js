const Product= require('../models/Product');
const uwu= require('../../sample.json');
// Crear producto
async function createProduct(producto){
    const{descripcion, stock,price} = producto;
    let newProduct= await Product.create({
        descripcion,
        stock,
        price
    },{
        fields: ['descripcion','stock','price']
    });
    return newProduct;
}

// Mostrar productos
async function getProducts(res){
    if(config.util.getEnv('NODE_ENV')=='test'){  
        res.json(uwu);  
    }
    else{
        const products= await Product.findAll();
        res.json(products);
        console.log(products); 
    }
    
}

// Modificar producto
async function updateProduct(ide,nproducto){
    const {id}= ide;
    const {descripcion,stock,price}=nproducto;

    const products = await Product.findAll({
        attributes:['id','descripcion','stock','price'],
        where: {
            id
        }
    })
    if(products.length > 0){
        products.forEach(async product =>{
            await product.update({
                descripcion,
                stock,
                price
            })
        })
    }
    return products;
}
//Eliminar
async function deleteProduct(ide){
    const {id}= ide;
    await Product.destroy({
        where: {id} 
    });
}
module.exports={createProduct,getProducts,deleteProduct,updateProduct};

/*
// Obtener solo un producto por id
async function getOneProduct(req,res){
    const {id}= req.params;
    try {
        const product = await Product.findOne({
            where: {
                id
            }
        })
        res.json(product);
    } catch (error) {
        console.log(error);
    }  
}
*/