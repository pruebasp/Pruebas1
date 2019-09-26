package innovar.io.demo1.dao.MongoConfig;
import org.springframework.data.mongodb.repository.MongoRepository;

import innovar.io.demo1.model.Persona;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepositoryMongo extends  MongoRepository<Persona, String> {
}
