package app.Dao;
import app.Dao.MongoDao.MongoConfig;
import app.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookRepositoryMongo implements IBookRepository {

  @Autowired
  MongoConfig mongoConfig;

  @Override
  public Book getById(String id) {
    return mongoConfig.findOne(id);
  }

  @Override
  public List<Book> listall() {
    return mongoConfig.findAll();
  }

  @Override
  public Book update(String id, Book b) {
    b.setId(id);
    return mongoConfig.save(b);
  }

  @Override
  public boolean delete(String id) {
    mongoConfig.delete(id);
    return false;
  }

  @Override
  public Book save(Book b) {
    return mongoConfig.save(b);
  }
}
