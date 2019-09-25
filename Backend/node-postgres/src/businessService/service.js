
const Product= require('../models/Product')

// Crear producto
async function createProduct(req,res){
    const{descripcion, stock,price} = req.body;
    try{
        let newProduct= await Product.create({
            descripcion,
            stock,
            price
        },{
            fields: ['descripcion','stock','price']
        });
        
        if(newProduct){
            return res.json({
                message: 'Producto creado exitosamente',
                data: newProduct
            });
        }
    }
    catch(error){
        console.log(error);
        res.status(500).json({
            message: 'Aalgo va mal',
            data: {}
        });
    }
}

// Mostrar productos
async function getProducts(req,res){
    try{
        const products= await Product.findAll();
        res.json({
            data: products
        });
    }
    catch(error){
        console.log(error);
    }
    
}

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
// Modificar
async function updateProduct(req,res){
    const {id}= req.params;
    const {descripcion,stock,price}=req.body;

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
    return res.json({
        message: 'Producto modificado exitosamente',
        data: products
    });
}
//Eliminar
async function deleteProduct(req,res){
    const {id}= req.params;
    const deleteRowCount = await Product.destroy({
        where: {
            id
        }
    })
    res.json({
        message: 'Producto eliminado exitosamente',
        count: deleteRowCount
    });
}

module.exports={createProduct,getProducts,getOneProduct,deleteProduct,updateProduct};