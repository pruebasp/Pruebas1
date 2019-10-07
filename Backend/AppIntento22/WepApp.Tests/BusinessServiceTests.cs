using AppIntento22.BusinessService;
using AppIntento22.Dao;
using FluentAssertions;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Moq;
using prueba20;
using WepApp.Tests.MockRepositorio;

namespace WepApp.Tests
{
    [TestClass]
    public class UnitTest1
    {

            private static AnimalBusinessService _animalBussinessService;
            private static Animal animal;
            [ClassInitialize()]
            
            public static void Setup(TestContext context)
            {
                Mock<IAnimal> _animalRepositorio = new AnimalRepositorioMock()._animalRepositorio;
                _animalBussinessService = new AnimalBusinessService(_animalRepositorio.Object);
            }

             [TestMethod]
            public void BuscarId()
            {
                var result = _animalBussinessService.Buscar("2");
                result.NombreAnimal.Should().NotBeNullOrEmpty();
                
            }

            [TestMethod]





             public void Listar()
             {
               var result = _animalBussinessService.GetAll();
               result.Should().NotBeNullOrEmpty();
               
            
             }


            [TestMethod]
            public void Crear()
            {
                var result = _animalBussinessService.Create(animal);
                result.NombreAnimal.Should().NotBeNullOrEmpty();
                
        }

            [TestMethod]
            public void Eliminar()
            {
                var result = _animalBussinessService.Delete("1");
            result.Should().BeTrue();

        }

            [TestMethod]
            public void Modificar()
            {
                var result = _animalBussinessService.Update("1",animal);
                result.NombreAnimal.Should().NotBeNullOrEmpty();
                result.Idanimal.Should().NotBe("2");

        }


    }

}


