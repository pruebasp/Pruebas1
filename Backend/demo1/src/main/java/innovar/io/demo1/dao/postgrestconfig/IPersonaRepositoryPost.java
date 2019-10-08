package innovar.io.demo1.dao.postgrestconfig;
import innovar.io.demo1.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPersonaRepositoryPost extends JpaRepository<Persona, String>{

}







