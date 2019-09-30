package app.Dao.PostgresDao;

import app.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresConfig extends JpaRepository<Book, String> {
}
