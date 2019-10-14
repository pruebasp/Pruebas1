process.env.NODE_ENV = 'test';
var Producto= require('../src/models/Product');
let chai= require('chai');
let chaiHttp=require('chai-http');

let server = require('../src/index');
let should = chai.should();
chai.use(chaiHttp);

productoss=require('../sample.json');
// Test the /GET route

describe('/GET product',()=>{
    it('it should GET all the products', (done) => {
        chai.request(server)
            .get('/')
            .end((err,res)=>{
                res.should.have.status(200);
                res.body.should.be.a('array');
                //res.body.length.should.be.eql(2);
            done();
            });
    });
    
});    

describe('/POST product', () => {
    it('it should POST a producto ', (done) => {
        let product = {
            descripcion: 'Azuca',
            stock: 15,
            price: 20.03
        }
      chai.request(server)
            .post('/')
            .send(product)
            .end((err, res) => {
                res.should.have.status(200);
            done();
            });
    });
});

describe('/PUT/:id product', () => {
    it('it should UPDATE a product given the id', (done) => {
        /*const descripcion="Pollo",
        stock=10,
        price=16.40
        let newProduct= Producto.create({
            descripcion,
            stock,
            price
        },{
            fields: ['descripcion','stock','price']
        });
       console.log(newProduct.id),*/
        chai.request(server)
              .put('/' + '1')
             // .send(newProduct)
              .end((err, res) => {
                    res.should.have.status(200);
                done();
        });
    });
});

describe('/DELETE/:id product', () => {
    it('it should DELETE a product given the id', (done) => {  
        chai.request(server)
            .delete('/' + '2')
            .end((err, res) => {
                    res.should.have.status(200);
                done();
        });
    });
});

after(async () => {
    process.exit();
});
