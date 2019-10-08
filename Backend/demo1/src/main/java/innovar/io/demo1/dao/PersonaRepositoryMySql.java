package innovar.io.demo1.dao;

import innovar.io.demo1.dao.mysqlconfig.IPersonaRepositoryMySql;
import innovar.io.demo1.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaRepositoryMySql implements  PersonaDao {

    @Autowired
    IPersonaRepositoryMySql iPersonaRepositoryMySql;

    @Override
    public Persona findById(String id) {

        Optional<Persona> p = iPersonaRepositoryMySql.findById(id);
        if (p.isPresent()) {
            return p.get();
        }
        else{
            return null;
        }
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
    public boolean delete(String id) {
        iPersonaRepositoryMySql.deleteById(id);
        return false;
    }
}
