package innovar.io.demo1.dao;

import innovar.io.demo1.dao.MySqlConfig.IPersonaRepositoryMySql;
import innovar.io.demo1.dao.PostgrestConfig.IPersonaRepositoryPost;
import innovar.io.demo1.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaRepositoryMySql implements  PersonaDao {

    @Autowired
    IPersonaRepositoryMySql iPersonaRepositoryMySql;

    @Override
    public Persona findById(String id) {
        return iPersonaRepositoryMySql.findById(id).get();
    }

    @Override
    public List<Persona> findAll() {
        return iPersonaRepositoryMySql.findAll();
    }

    @Override
    public Persona save(Persona persona) {
        return iPersonaRepositoryMySql.save(persona);
    }

    @Override
    public boolean delete(String Id) {
        iPersonaRepositoryMySql.deleteById(Id);
        return false;
    }
}
