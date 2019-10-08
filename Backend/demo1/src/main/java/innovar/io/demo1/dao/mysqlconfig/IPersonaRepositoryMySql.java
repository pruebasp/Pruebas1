package innovar.io.demo1.dao.mysqlconfig;
import innovar.io.demo1.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPersonaRepositoryMySql extends JpaRepository<Persona, String>{

}







