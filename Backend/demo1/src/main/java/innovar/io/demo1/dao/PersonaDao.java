package innovar.io.demo1.dao;

import innovar.io.demo1.model.Persona;


import java.util.List;


public interface PersonaDao  {
    Persona findById(String id);
    List<Persona> findAll();
    Persona save(Persona persona);
    boolean delete(String id);

}

