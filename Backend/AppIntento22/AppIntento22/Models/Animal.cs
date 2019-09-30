using MongoDB.Bson;
using MongoDB.Bson.Serialization.Attributes;
using System;
using System.Collections.Generic;

namespace prueba20
{
    public partial class Animal
    {
        [BsonId]
        [BsonRepresentation(representation: BsonType.ObjectId)]
        public string Idanimal { get; set; }

        [BsonElement("nombreAnimal")]
        public string NombreAnimal { get; set; }

        [BsonElement("segunEsqueleto")]
        public string SegunEsqueleto { get; set; }

        [BsonElement("tipoHabitad")]
        public string TipoHabitad { get; set; }

        [BsonElement("tipoReproduccion")]
        public string TipoReproduccion { get; set; }

        [BsonElement("tipoAlimentacion")]
        public string TipoAlimentacion { get; set; }
    }
}
