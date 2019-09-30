package app.BussinessService;

import app.Dao.IBookDao;
import app.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookBussinesService {
    @Autowired
    IBookDao iBookDao;

    public Book getById(String id){
        return iBookDao.getById(id);
    }

    public List<Book> listall() {
        return iBookDao.listall();
    }

    public Book update(String id, Book b) {
        b.setId(id);
        return iBookDao.update(id,b);
    }

    public boolean delete(String id) {
        iBookDao.delete(id);
        return false;
    }

    public Book save(Book b) {
        return iBookDao.save(b);
    }
}
