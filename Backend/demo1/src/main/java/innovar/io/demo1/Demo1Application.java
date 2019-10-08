package innovar.io.demo1;

import innovar.io.demo1.dao.*;



import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.core.env.Environment;

@SpringBootApplication
public class Demo1Application {
    @Autowired
    PersonaRepositorySQL personaRepositorySQL;
    @Autowired
    PersonaRepositoryMongo personaRepositoryMongo;
    @Autowired
    PersonaRepositoryPost personaRepositoryPost;
    @Autowired
    PersonaRepositoryMySql personaRepositoryMySql;


    Logger logger = Logger.getLogger(Demo1Application.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @Autowired
    private Environment environment;

    @Bean
    public PersonaDao personaDao (){
        if(environment.getActiveProfiles()[0].equals("sql")  ){

            logger.info("DESARROLLO EN - SQL");

            return personaRepositorySQL;
        }
        else if(environment.getActiveProfiles()[0].equals("post")){
            logger.info("DESARROLLO EN - POST");

            return personaRepositoryPost;
        }

        else if(environment.getActiveProfiles()[0].equals("mongo")){
            logger.info("DESARROLLO EN - MONGO");

            return personaRepositoryMongo;
        }
        else if(environment.getActiveProfiles()[0].equals("mysql")){
            logger.info("DESARROLLO EN - MYSQL");
            return  personaRepositoryMySql;
        }

        logger.info("DESARROLLO EN DEFAULT - MONGO");

        return personaRepositoryMongo;

    }


}
