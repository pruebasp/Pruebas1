using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using MongoDB.Bson;
using MongoDB.Bson.Serialization.Attributes;
using Newtonsoft.Json;
using BooksApi.Servicios;



namespace BooksApi.Models
{
    public class BooksApi
    {
        public BooksApi()
        {
            //EmailService = emailService;
        }

        //public IEmailService EmailService { get; }

        public string Mensaje { get; set; }

        public void Onget([Microsoft.AspNetCore.Mvc.FromServices] IEmailService email)
        {
            //Mensaje = EmailService.EnviarCorreo();
            Mensaje = email.EnviarCorreo();
        }

        [BsonId]
        [BsonRepresentation(BsonType.ObjectId)]
        public string Id { get; set; }
                             

        [BsonElement("Name")]
        [JsonProperty("Name")]
        public string BookName { get; set; }

        public decimal Price { get; set; }

        public string Category { get; set; }

        public string Author { get; set; }

    }
}
