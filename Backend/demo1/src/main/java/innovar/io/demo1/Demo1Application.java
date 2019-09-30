package innovar.io.demo1;

import innovar.io.demo1.dao.MongoConfig.IPersonaRepositoryMongo;
import innovar.io.demo1.dao.PersonaDao;
import innovar.io.demo1.dao.PersonaRepositoryMongo;
import innovar.io.demo1.dao.PersonaRepositoryPost;
import innovar.io.demo1.dao.PersonaRepositorySQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Demo1Application {
    @Autowired
    PersonaRepositorySQL personaRepositorySQL;
    @Autowired
    PersonaRepositoryMongo personaRepositoryMongo;
    @Autowired
    PersonaRepositoryPost personaRepositoryPost;


    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @Autowired
    private Environment environment;

    @Bean
    public PersonaDao personaDao (){
        if(environment.getActiveProfiles()[0].toString().equals("sql")  ){
            System.out.println("DESARROLLO EN - SQL");

            return personaRepositorySQL;
        }
        else if(environment.getActiveProfiles()[0].toString().equals("post")){
            System.out.println("DESARROLLO EN - POST");
            return personaRepositoryPost;
        }

        else if(environment.getActiveProfiles()[0].toString().equals("mongo")){
            System.out.println("DESARROLLO EN - MONGO");
            return personaRepositoryMongo;
        }

        System.out.println("DESARROLLO EN DEFAULT - MONGO");
        return personaRepositoryMongo;

    }


}
