using prueba20;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AppIntento22.Dao
{
    public class AnimalRepository : IAnimal
    {
        
        private readonly bdanimalesContext _context;
        //private readonly IAnimal _animal;
       
        public AnimalRepository(bdanimalesContext context)
        {
            _context = context;
        }

        
        
        public bool Delete (string id)
        {
            var animal = _context.Animal.Find(id);
            _context.Animal.Remove(animal);
            _context.SaveChanges();
            return true;
        }

        public List<Animal> GetAll()
         {
            return _context.Animal.ToList();
         }

        public Animal Buscar(string id)
        {
            // opcion b = 
            var ls = _context.Animal.ToList().FindLast(e => e.Idanimal == id);
            return ls;
        }

        public Animal Create(Animal animal)
        {
            
            Animal ls = _context.Animal.Add(animal).Entity;
            _context.SaveChanges();
            return ls;
        }

        public Animal Update (string id,Animal animal)
        {

            Animal ls = _context.Animal.Update(animal).Entity;
            _context.SaveChanges();
            return ls;
        }

        }
}
