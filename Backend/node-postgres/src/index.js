const express = require('express');
const app = express();
const morgan = require('morgan');

//Importar routes
const productRoutes = require('./controllers/product.controller');

// Settings
app.set('port', process.env.PORT || 3000);

// Middlewares
app.use(morgan('dev'));
app.use(express.json());

// Routes
app.use('',productRoutes);

// Iniciar el servidor
app.listen(app.get('port'), () => {
  console.log(`Server on port ${app.get('port')}`);
});

module.exports=app;