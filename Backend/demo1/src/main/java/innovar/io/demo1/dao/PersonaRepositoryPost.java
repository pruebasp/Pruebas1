package innovar.io.demo1.dao;

import innovar.io.demo1.dao.PostgrestConfig.IPersonaRepositoryPost;
import innovar.io.demo1.dao.SQLconfig.IPersonaRepositorySQL;
import innovar.io.demo1.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaRepositoryPost implements  PersonaDao {

    @Autowired
    IPersonaRepositoryPost iPersonaRepositoryPost;

    @Override
    public Persona findById(String id) {
        return iPersonaRepositoryPost.findById(id).get();
    }

    @Override
    public List<Persona> findAll() {
        return iPersonaRepositoryPost.findAll();
    }

    @Override
    public Persona save(Persona persona) {
        return iPersonaRepositoryPost.save(persona);
    }

    @Override
    public boolean delete(String Id) {
        iPersonaRepositoryPost.deleteById(Id);
        return false;
    }
}
