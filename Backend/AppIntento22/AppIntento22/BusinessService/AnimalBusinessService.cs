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
        //private readonly AnimalRepository _animalRepositorio;
        private readonly IAnimal _animalRepositorio;
        // private readonly AnimalRepository _animalRepositorio;

        public AnimalBusinessService(IAnimal animalRepository)
        {
            _animalRepositorio = animalRepository;
        }


        public bool Delete(string id)
        {
         
            //var animal = _con.Animal.Find(id);
            _animalRepositorio.Delete(id);
            //_context.Animal.Remove(animal);
            //_context.SaveChanges();
            return true;
        }

        public List<Animal> GetAll()
        {
            //return _context.Animal.ToList();
            return _animalRepositorio.GetAll();
        }

        public Animal Buscar(string id)
        {
            // opcion b = 
            //var ls = _context.Animal.ToList().FindLast(e => e.Idanimal == id);
            var ls = _animalRepositorio.Buscar(id);
            return ls;
        }

        public Animal Create(Animal animal)
        {

            //Animal ls = _context.Animal.Add(animal).Entity;
            //_context.SaveChanges();
            Animal ls = _animalRepositorio.Create(animal);
            return ls;
        }

        public Animal Update(string id, Animal animal)
        {

            //Animal ls = _context.Animal.Update(animal).Entity;
            //_context.SaveChanges();
            Animal ls = _animalRepositorio.Update(id, animal);
            return ls;
        }


    }
}
