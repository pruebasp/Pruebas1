using prueba20;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using MongoDB.Driver;
using Microsoft.Extensions.Configuration;

namespace AppIntento22.Dao
{
    public class AnimalRepositorioMongo: IAnimal
    {
        //private readonly bdanimalesContext _context;
        private readonly IMongoCollection<Animal> _animal;
        //private readonly IAnimal _animal;

        public AnimalRepositorioMongo(IConfiguration config)
        {
            //_context = context;
            var cliente = new MongoClient(config.GetConnectionString("DefaultConnectionMongo"));
            var database = cliente.GetDatabase("bdanimales");
            _animal = database.GetCollection<Animal>("animal");

        }
    

        public Animal Buscar(string id)
        {
            
            return _animal.Find<Animal>(animal => animal.Idanimal == id).FirstOrDefault();
            //var ls = _context.Animal.ToList().FindLast(e => e.Idanimal == id);
            //return ls;
        }

        public Animal Create(Animal animal)
        {
            _animal.InsertOne(animal);
            return animal;
        }

        public bool Delete(string id)
        {
            _animal.DeleteOne(animal => animal.Idanimal == id);
            return true;
        }

        public List<Animal> GetAll()
        {

            return _animal.Find(animal =>true).ToList();
        }

        public Animal Update(string id, Animal animal1)
        {
            _animal.ReplaceOne(animal => animal.Idanimal == id, animal1);
            return animal1;
        }
    }
}
