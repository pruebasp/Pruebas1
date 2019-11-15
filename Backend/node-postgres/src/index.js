const express = require('express');
const app = express();
const morgan = require('morgan');
var config= require('config');

//Importar routes
const productRoutes = require('./controllers/product.controller');

//db? :0

// Settings
app.set('port', process.env.PORT || 4000);

// Middlewares
app.use(morgan('dev'));
app.use(express.json());

//si es mongo esto ...
if(config.util.getEnv('NODE_ENV')=='dbmongo'){
    require('./dao/dbMongo');
}

// Routes
app.use('',productRoutes);

// Iniciar el servidor
app.listen(app.get('port'), () => {
  console.log(`Server on port ${app.get('port')}`);
});

function stop() {
  app.close();
}

module.exports=app;
module.exports.stop = stop;