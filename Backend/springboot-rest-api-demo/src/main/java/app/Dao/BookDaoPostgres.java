package app.Dao;

import app.Dao.PostgresDao.PostgresConfig;
import app.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookDaoPostgres implements IBookDao {
    @Autowired
    PostgresConfig postgresConfig;

    @Override
    public Book getById(String id) {
        return postgresConfig.findOne(id);
    }

    @Override
    public List<Book> listall() {
        return postgresConfig.findAll();
    }

    @Override
    public Book update(String id, Book b) {
        b.setId(id);
        return postgresConfig.save(b);
    }

    @Override
    public boolean delete(String id) {
        postgresConfig.delete(id);
        return false;
    }

    @Override
    public Book save(Book b) {
        return postgresConfig.save(b);
    }
}
