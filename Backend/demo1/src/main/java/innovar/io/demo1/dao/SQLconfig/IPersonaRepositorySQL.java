package innovar.io.demo1.dao.SQLconfig;
import innovar.io.demo1.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IPersonaRepositorySQL extends JpaRepository<Persona, String>{

}







