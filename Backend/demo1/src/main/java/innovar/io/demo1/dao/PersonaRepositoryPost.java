package innovar.io.demo1.dao;

import innovar.io.demo1.dao.postgrestconfig.IPersonaRepositoryPost;
import innovar.io.demo1.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaRepositoryPost implements  PersonaDao {

    @Autowired
    IPersonaRepositoryPost iPersonaRepositoryPost;

    @Override
    public Persona findById(String id) {

        Optional<Persona> p = iPersonaRepositoryPost.findById(id);
        if (p.isPresent()) {
            return p.get();
        }
        else{
            return null;
        }


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
    public boolean delete(String id) {
        iPersonaRepositoryPost.deleteById(id);
        return false;
    }
}
