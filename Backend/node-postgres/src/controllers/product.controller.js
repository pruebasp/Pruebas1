const express = require('express');
const router = express.Router();

const product= require('../businessService/service');
//console.log(product)

// /
router.post('/',product.createProduct);
router.get('/',product.getProducts);

// /:productID
router.get('/:id',product.getOneProduct);
router.put('/:id',product.updateProduct);
router.delete('/:id',product.deleteProduct);
module.exports = router;