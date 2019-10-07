using prueba20;
using System;
using System.Collections.Generic;
using System.Text;

namespace WepApp.Tests.Stubs
{
    public static class AnimalStub
    {
        public static Animal animal = new Animal()
        {
            Idanimal = "1",
            NombreAnimal = "lorito",
            SegunEsqueleto = "vertebrado",
            TipoHabitad = "aereo y terrestre",
            TipoReproduccion = "oviparo",
            TipoAlimentacion = "frutas"
        };

        public static Animal animal2 = new Animal()
        {
            Idanimal = "2",
            NombreAnimal = "caballo",
            SegunEsqueleto = "vertebrado",
            TipoHabitad = "terrestre",
            TipoReproduccion = "viviparo",
            TipoAlimentacion = "herbivoro"
        };

        public static List<Animal> listaAnimal = new List<Animal>(new Animal[] { animal, animal2 });
    }
   
}
