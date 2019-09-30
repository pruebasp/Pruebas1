const express = require('express');
const router = express.Router();
var config= require('config');
console.log('NODE_ENV: ' + config.util.getEnv('NODE_ENV'));
var product= require('../businessService/services');

router.post('/',function (req, res){
    try{
        const response = product.createProduct(req.body);
        res.json({
            message : 'Producto creado exitosamente'
       });
    }
    catch(error){
        console.log(error);
        res.status(500).json({
            message : 'Aalgo va mal',
            data: {}
        });
    }
});

router.get('/',function(req,res){
    try{
        const productos = product.getProducts(res);
    }
    catch(error){
        console.log(error);
    }
});

// /:productID

router.put('/:id',function(req,res){
    product.updateProduct(req.params, req.body);
    return res.json({
        message: 'Producto modificado exitosamente',
    });
} );

router.delete('/:id',function(req,res){
    product.deleteProduct(req.params);
    res.json({
        message: 'Producto eliminado exitosamente',
    });
});
module.exports = router;
//router.get('/:id',product.getOneProduct);