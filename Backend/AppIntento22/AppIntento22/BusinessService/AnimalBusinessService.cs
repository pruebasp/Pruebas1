using AppIntento22.Dao;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using prueba20;

namespace AppIntento22.BusinessService
{
    
    public class AnimalBusinessService 
    {
         
        private readonly IAnimal _animalRepositorio;
        

        public AnimalBusinessService(IAnimal animalRepository)
        {
           
            _animalRepositorio = animalRepository;
        }

        public AnimalBusinessService()
        {
            
        }

        public bool Delete(string id)
        {
         
            
            _animalRepositorio.Delete(id);
            
            return true;
        }

        public List<Animal> GetAll()
        {
            
            return _animalRepositorio.GetAll();
        }

        public Animal Buscar(string id)
        {
            
            var ls = _animalRepositorio.Buscar(id);
            return ls;
        }

        public Animal Create(Animal animal)
        {

            
            Animal ls = _animalRepositorio.Create(animal);
            return ls;
        }

        public Animal Update(string id, Animal animal)
        {

            
            Animal ls = _animalRepositorio.Update(id, animal);
            return ls;
        }


    }
}
