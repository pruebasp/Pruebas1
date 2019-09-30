package app.Dao;

import app.Dao.MysqlDao.MysqlConfig;
import app.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookDaoMysql implements IBookDao {
    @Autowired
    MysqlConfig mysqlConfig;
    @Override
    public Book getById(String id) {
        return mysqlConfig.findOne(id);
    }

    @Override
    public List<Book> listall() {
        return mysqlConfig.findAll();
    }

    @Override
    public Book update(String id, Book b) {
        b.setId(id);
        return mysqlConfig.save(b);
    }

    @Override
    public boolean delete(String id) {
        mysqlConfig.delete(id);
        return false;
    }

    @Override
    public Book save(Book book) {
        return mysqlConfig.save(book);
    }
}
