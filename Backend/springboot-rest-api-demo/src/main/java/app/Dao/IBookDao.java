package app.Dao;

import app.model.Book;
import java.util.List;

public interface IBookDao {
    Book getById(String id);
    List<Book> listall();
    Book update(String id, Book b);
    boolean delete(String id);
    Book save(Book book);
}
