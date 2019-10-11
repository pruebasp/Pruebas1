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
        Animal Buscar(string id);
        bool Delete(string id);
        Animal Create(Animal animal);
        Animal Update(string id, Animal animal);
    }
}
