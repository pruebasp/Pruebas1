using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using MongoDB.Driver;
using BooksApi.Models;
using MongoDB.Bson;
using MongoDB.Bson.Serialization.Attributes;

namespace BooksApi.Servicios
{
    public class BookService
    {
        private readonly IMongoCollection<Models.BooksApi> _books;

        public BookService(IBookstoreDatabaseSettings settings)
        {
            var client = new MongoClient(settings.ConnectionString);
            var database = client.GetDatabase(settings.DatabaseName);

            _books = database.GetCollection<Models.BooksApi>(settings.BooksCollectionName);
        }

        public List<Models.BooksApi> Get() =>
            _books.Find(book => true).ToList();

        public Models.BooksApi Get(string id) =>
            _books.Find<Models.BooksApi>(book => book.Id == id).FirstOrDefault();

        public Models.BooksApi Create(Models.BooksApi book)
        {
            _books.InsertOne(book);
            return book;
        }

        public void Update(string id, Models.BooksApi bookIn) =>
            _books.ReplaceOne(book => book.Id == id, bookIn);

        public void Remove(Models.BooksApi bookIn) =>
            _books.DeleteOne(book => book.Id == bookIn.Id);

        public void Remove(string id) =>
            _books.DeleteOne(book => book.Id == id);
    }
}
