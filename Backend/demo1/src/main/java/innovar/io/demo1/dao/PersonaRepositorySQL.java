package innovar.io.demo1.dao;

import innovar.io.demo1.dao.sqlconfig.IPersonaRepositorySQL;
import innovar.io.demo1.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaRepositorySQL implements  PersonaDao {

    @Autowired
    IPersonaRepositorySQL iPersonaRepositorySQL;

    @Override
    public Persona findById(String id) {

        Optional<Persona> p = iPersonaRepositorySQL.findById(id);
        if (p.isPresent()) {
            return p.get();
        }
        else{
            return null;
        }

    }

    @Override
    public List<Persona> findAll() {
        return iPersonaRepositorySQL.findAll();
    }

    @Override
    public Persona save(Persona persona) {
        return iPersonaRepositorySQL.save(persona);
    }

    @Override
    public boolean delete(String id) {
        iPersonaRepositorySQL.deleteById(id);
        return false;
    }
}
