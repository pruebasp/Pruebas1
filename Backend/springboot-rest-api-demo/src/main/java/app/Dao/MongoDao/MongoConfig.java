package app.Dao.MongoDao;

import app.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoConfig extends MongoRepository<Book, String>
{

}
