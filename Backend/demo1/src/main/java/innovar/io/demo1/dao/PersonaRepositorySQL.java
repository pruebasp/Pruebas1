package innovar.io.demo1.dao;

import innovar.io.demo1.dao.SQLconfig.IPersonaRepositorySQL;
import innovar.io.demo1.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaRepositorySQL implements  PersonaDao {

    @Autowired
    IPersonaRepositorySQL IPersonaRepositorySQL;

    @Override
    public Persona findById(String id) {
        return IPersonaRepositorySQL.findById(id).get();
    }

    @Override
    public List<Persona> findAll() {
        return IPersonaRepositorySQL.findAll();
    }

    @Override
    public Persona save(Persona persona) {
        return IPersonaRepositorySQL.save(persona);
    }

    @Override
    public boolean delete(String Id) {
        IPersonaRepositorySQL.deleteById(Id);
        return false;
    }
}
