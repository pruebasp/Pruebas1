using AppIntento22.Dao;
using Moq;
using prueba20;
using System;
using System.Collections.Generic;
using System.Text;
using WepApp.Tests.Stubs;

namespace WepApp.Tests.MockRepositorio
{
    public class AnimalRepositorioMock
    {
        // mock son objetos simulados que imitan comportamiento de  objetos reales
        public Mock<IAnimal> _animalRepositorio { get; set; }

        public AnimalRepositorioMock()
        {
            _animalRepositorio = new Mock<IAnimal>();
            Setup();
        }

        private void Setup()
        {
            // cada metodo tiene una inicilaizacion de valores para devolver
            _animalRepositorio.Setup((x) => x.Create(It.IsAny<Animal>())).Returns(AnimalStub.animal);
            _animalRepositorio.Setup((x) => x.Delete(It.Is<string>(p => p.Equals("1")))).Returns(true);
            _animalRepositorio.Setup((x) => x.Buscar(It.Is<string>(p => p.Equals("2")))).Returns(AnimalStub.animal);
            _animalRepositorio.Setup((x) => x.GetAll()).Returns(AnimalStub.listaAnimal);
            _animalRepositorio.Setup((x) => x.Update(It.Is<string>(p => p.Equals("1")), It.IsAny<Animal>())).Returns(AnimalStub.animal);
        }
    }
}
