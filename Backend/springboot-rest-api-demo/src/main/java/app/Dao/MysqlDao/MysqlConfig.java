package app.Dao.MysqlDao;

import app.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MysqlConfig extends JpaRepository<Book, String>  {
}
