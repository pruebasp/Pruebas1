package innovar.io.demo1;

import innovar.io.demo1.dao.*;
import innovar.io.demo1.dao.MongoConfig.IPersonaRepositoryMongo;
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
    @Autowired
    PersonaRepositoryMySql personaRepositoryMySql;


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
        else if(environment.getActiveProfiles()[0].toString().equals("mysql")){
            System.out.println("DESARROLLO EN - MYSQL");
            return  personaRepositoryMySql;
        }

        System.out.println("DESARROLLO EN DEFAULT - MONGO");
        return personaRepositoryMongo;

    }


}
