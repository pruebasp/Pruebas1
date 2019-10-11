package app.Dao;

import app.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IBookRepository{
    Book getById(String id);
    List<Book> listall();
    Book update(String id, Book b);
    boolean delete(String id);
    Book save(Book book);
}
