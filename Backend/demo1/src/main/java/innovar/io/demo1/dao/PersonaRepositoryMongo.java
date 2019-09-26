package innovar.io.demo1.dao;

import innovar.io.demo1.dao.MongoConfig.IPersonaRepositoryMongo;
import innovar.io.demo1.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaRepositoryMongo implements PersonaDao {
    @Autowired
    IPersonaRepositoryMongo iPersonaRepositoryMongo;


    @Override
    public Persona findById(String Id) {
        return iPersonaRepositoryMongo.findById(Id).get();
    }

    @Override
    public List<Persona> findAll() {
        return iPersonaRepositoryMongo.findAll();
    }

    @Override
    public Persona save(Persona persona) {
        return iPersonaRepositoryMongo.save(persona);
    }

    @Override
    public boolean delete(String Id) {
        iPersonaRepositoryMongo.deleteById(Id);
        return false;
    }
}
