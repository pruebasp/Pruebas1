package app.BussinessService;

import app.Dao.BookRepositoryMongo;
import app.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookBussinesService {
    @Autowired
    BookRepositoryMongo bookRepositoryMongo;

    public Book getById(String id){
        return bookRepositoryMongo.getById(id);
    }

    public List<Book> listall() {
        return bookRepositoryMongo.listall();
    }

    public Book update(String id, Book b) {
        b.setId(id);
        return bookRepositoryMongo.update(id,b);
    }

    public boolean delete(String id) {
        bookRepositoryMongo.delete(id);
        return false;
    }

    public Book save(Book b) {
        return bookRepositoryMongo.save(b);
    }
}
