using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using prueba20;

namespace AppIntento22.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ValuesController : ControllerBase
    {
        private readonly bdanimalesContext _context;

        public ValuesController(bdanimalesContext value)
        {
            _context = value;
        }
        // GET api/values
        [HttpGet]
        public ActionResult<IEnumerable<Animal>> Get()
        {
            var ls = _context.Animal.ToList();
            return ls;
        }

        // GET api/values/5
        [HttpGet("{id}")]
        public ActionResult<Animal> Get(int id)
        {
            var ls = _context.Animal.ToList().FindLast(e => e.Idanimal == id);
            return ls;
        }

        // POST api/values
        [HttpPost]
        public ActionResult<Animal> Post([FromBody] Animal value)
        {

            Animal ls = _context.Animal.Add(value).Entity;
            _context.SaveChanges();
            return ls;

        }

        // PUT api/values/5
        [HttpPut("{id}")]
        public ActionResult<Animal> Put(int id, [FromBody] Animal value)
        {
            value.Idanimal = id;
            Animal ls = _context.Animal.Update(value).Entity;
            _context.SaveChanges();
            return ls;
        }

        // DELETE api/values/5
        [HttpDelete("{id}")]
        public ActionResult<Boolean> Delete(int id)
        {
            var animal = _context.Animal.Find(id);
             _context.Animal.Remove(animal);
            _context.SaveChanges();
            return true;
        }
    }
}
