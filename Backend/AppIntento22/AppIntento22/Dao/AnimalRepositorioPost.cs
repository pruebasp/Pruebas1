using prueba20;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AppIntento22.Dao
{
    public class AnimalRepositorioPost: IAnimal
    {
        private readonly bdanimalesContext _context;
        //private readonly IAnimal _animal;

        public AnimalRepositorioPost(bdanimalesContext context)
        {
            _context = context;
        }

        public Animal Buscar(int id)
        {
            var ls = _context.Animal.ToList().FindLast(e => e.Idanimal == id);
            return ls;
        }

        public Animal Create(Animal animal)
        {
            throw new NotImplementedException();
        }

        public bool Delete(int id)
        {
            throw new NotImplementedException();
        }

        public List<Animal> GetAll()
        {
            return _context.Animal.ToList();
        }

        public Animal Update(int id, Animal animal)
        {
            throw new NotImplementedException();
        }
    }
}
