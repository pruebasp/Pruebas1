package app.Dao;
import app.Dao.SqlDao.SqlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import app.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookDaoSql implements IBookDao {

    @Autowired
    SqlConfig sqlConfig;

    @Override
    public Book getById(String id) {
        return sqlConfig.findOne(id);
    }

    @Override
    public List<Book> listall() {
        return sqlConfig.findAll();
    }

    @Override
    public Book update(String id, Book b) {
        b.setId(id);
        return sqlConfig.save(b);
    }

    @Override
    public boolean delete(String id) {
        sqlConfig.delete(id);
        return false;
    }

    @Override
    public Book save(Book book) {
        return sqlConfig.save(book);
    }
}
