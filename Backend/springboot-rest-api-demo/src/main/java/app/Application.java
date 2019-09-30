package app;

import app.Dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Application {
  @Autowired  BookDaoSql bookRepositorySql;
  @Autowired  BookDaoPostgres bookRepositoryPostgres;
  @Autowired  BookDaoMysql bookRepositoryMysql;
  @Autowired  BookDaoMongo bookRepositoryMongo;
  @Autowired  private Environment environment;

  @Bean
  public IBookDao iBookDao (){
    switch (environment.getActiveProfiles()[0]) {
      case "sql":
        return bookRepositorySql;
      case "postgres":
        return bookRepositoryPostgres;
      case "mysql":
        return bookRepositoryMongo;
      case "mongo":
        return bookRepositoryMongo;
    }
    return bookRepositoryMongo;

  }
  public static void main(String[] args) throws Exception {
    SpringApplication.run(new Object[] { Application.class }, args);
  }

}
