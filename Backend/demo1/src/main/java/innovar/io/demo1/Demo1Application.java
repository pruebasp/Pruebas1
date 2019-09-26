package innovar.io.demo1;

import innovar.io.demo1.dao.MongoConfig.IPersonaRepositoryMongo;
import innovar.io.demo1.dao.PersonaDao;
import innovar.io.demo1.dao.PersonaRepositoryMongo;
import innovar.io.demo1.dao.PersonaRepositorySQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class Demo1Application {
    @Autowired
    PersonaRepositorySQL personaRepositorySQL;
    @Autowired
    PersonaRepositoryMongo personaRepositoryMongo;
   /** @Autowired
    PersonaRepositorySQL personaRepositorytrid;**/


    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @Bean
    public PersonaDao personaDao (){
        if(false){
            return personaRepositorySQL;
        }
        else{
            return personaRepositoryMongo;
        }

    }


}
