using prueba20;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AppIntento22.Dao
{
    public interface IAnimal
    {
        List<Animal> GetAll();
        Animal Buscar(int id);
        bool Delete(int id);
        Animal Create(Animal animal);
        Animal Update(int id, Animal animal);
    }
}
