package innovar.io.demo1.repository;
import innovar.io.demo1.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{
}







