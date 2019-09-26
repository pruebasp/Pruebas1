using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using AppIntento22.BusinessService;
using AppIntento22.Dao;
using Microsoft.AspNetCore.Mvc;
using prueba20;

namespace AppIntento22.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ValuesController : ControllerBase
    {
        private readonly AnimalBusinessService _Bussinessanimal;
        
        //private readonly bdanimalesContext _context;

        public ValuesController(AnimalBusinessService businessService)
        {
            //_Ianimal = ICategory;
            _Bussinessanimal = businessService;
        }

        // GET api/values
        [HttpGet]
        //public  ActionResult<IEnumerable<Animal>> Get()
        public ActionResult<IEnumerable<Animal>> Get()
        {
            var ls = _Bussinessanimal.GetAll();
            //var ls = _Ianimal.GetAll();
            //var ls = _context.Animal.ToList();
            return ls;
        }

        // GET api/values/5
        [HttpGet("{id}")]
        public ActionResult<Animal> Get(int id)
        {
            var ls = _Bussinessanimal.Buscar(id);
            //var ls = _Ianimal.Buscar(id);
           // var ls = _context.Animal.ToList().FindLast(e => e.Idanimal == id);
            return ls;
        }

        // POST api/values
        [HttpPost]
        public ActionResult<Animal> Post([FromBody] Animal value)
        {
            Animal ls = _Bussinessanimal.Create(value);
            //Animal ls = _Ianimal.Create(value);
            //Animal ls = _context.Animal.Add(value).Entity;
            //_context.SaveChanges();
            return ls;

        }

        // PUT api/values/5
        [HttpPut("{id}")]
        public ActionResult<Animal> Put(int id, [FromBody] Animal value)
        {
            value.Idanimal = id;
            Animal ls = _Bussinessanimal.Update(id, value);
            //Animal ls = _Ianimal.Update(id,value);
            //value.Idanimal = id;
            //Animal ls = _context.Animal.Update(value).Entity;
            //_context.SaveChanges();
            return ls;
        }

        // DELETE api/values/5
        [HttpDelete("{id}")]
        public ActionResult<Boolean> Delete(int id)
        {
            var ls = _Bussinessanimal.Delete(id);
            //var ls = _Ianimal.Delete(id);
            //var animal = _context.Animal.Find(id);
            // _context.Animal.Remove(animal);
            //_context.SaveChanges();
            return true;
        }
    }
}
