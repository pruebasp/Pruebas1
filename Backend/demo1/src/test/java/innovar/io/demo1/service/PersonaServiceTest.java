package innovar.io.demo1.service;

import innovar.io.demo1.dao.PersonaDao;
import innovar.io.demo1.exception.ResourceNotFoundException;
import innovar.io.demo1.model.Persona;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;


public class PersonaServiceTest {


    @InjectMocks
    private PersonaService personaService;

    @Mock
    private  PersonaDao personaDao;

    Persona persona;
    List<Persona> lista ;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        persona = new Persona();
        persona.setNombre("Raul");
        persona.setApellidoPaterno("Huaman");
        persona.setApellidoPaterno("Quispe");
        persona.setTipoDocIdentidad("1234567");
        persona.setEdad(45);
        persona.setFechaNac("10/4/98");
        persona.setOcupacion("Florista");
        persona.setSexo(1);


        lista = new ArrayList<>();

        Mockito.when(personaDao.findById("1")).thenReturn(persona);

        Mockito.when(personaDao.save(persona)).thenReturn(persona);

    }

    @Test
    public void buscarPorId() throws ResourceNotFoundException {

        // Prueba
        assertEquals(persona,personaService.buscarPorId("1"));

    }

    @Test
    public void buscarPorIdEx(){
        assertThrows(ResourceNotFoundException.class,()-> personaService.buscarPorId(""));
    }

    @Test
    public void listar() {

        for (int i = 0; i < 10; i++) {
            persona.setNombre("Raul"+i);
            lista.add(persona);

        }
        Mockito.when(personaDao.findAll()).thenReturn(lista);

        //Prueba
        assertEquals(lista,personaService.listar());
    }

    @Test
    public void crear() {
        //Prueba
        assertEquals(persona,personaService.crear(persona));
    }

    @Test
    public void actualizar() throws ResourceNotFoundException {
        //Prueba
        assertEquals(persona,personaService.actualizar("1",persona));
    }

    @Test
    public void actualizarEx() throws ResourceNotFoundException {
        assertThrows(ResourceNotFoundException.class,()-> personaService.actualizar("2",persona));
    }

    @Test
    public void borrar() throws ResourceNotFoundException {
        Mockito.when(personaDao.delete("1")).thenReturn(true);

        //Prueba
        assertEquals(true,personaService.borrar("1"));
    }

    @Test
    public void borrarEx() throws ResourceNotFoundException {
        assertThrows(ResourceNotFoundException.class,()-> personaService.borrar("2"));
    }

}