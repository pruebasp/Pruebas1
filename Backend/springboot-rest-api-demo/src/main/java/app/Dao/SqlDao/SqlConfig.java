package app.Dao.SqlDao;

import app.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SqlConfig extends JpaRepository<Book, String> {
}
