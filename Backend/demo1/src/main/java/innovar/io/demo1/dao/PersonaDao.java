package innovar.io.demo1.dao;

import innovar.io.demo1.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface PersonaDao  {
    Persona findById(String Id);
    List<Persona> findAll();
    Persona save(Persona persona);
    boolean delete(String Id);

}

