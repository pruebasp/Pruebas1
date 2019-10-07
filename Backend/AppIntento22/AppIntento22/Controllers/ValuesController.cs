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
        
        

        public ValuesController(AnimalBusinessService businessService)
        {
            
            _Bussinessanimal = businessService;
        }

        // GET api/values
        [HttpGet]
        
        public ActionResult<IEnumerable<Animal>> Get()
        {
            var ls = _Bussinessanimal.GetAll();
          
            return ls;
        }

        // GET api/values/5
        [HttpGet("{id}")]
        public ActionResult<Animal> Get(string id)
        {
            var ls = _Bussinessanimal.Buscar(id);
            return ls;
        }

        // POST api/values
        [HttpPost]
        public ActionResult<Animal> Post([FromBody] Animal value)
        {
            Animal ls = _Bussinessanimal.Create(value);
            return ls;

        }

        // PUT api/values/5
        [HttpPut("{id}")]
        public ActionResult<Animal> Put(string id, [FromBody] Animal value)
        {
            value.Idanimal = id;
            Animal ls = _Bussinessanimal.Update(id, value);
            return ls;
        }

        // DELETE api/values/5
        [HttpDelete("{id}")]
        public ActionResult<Boolean> Delete(string id)
        {
            var ls = _Bussinessanimal.Delete(id);
            return true;
        }
    }
}
