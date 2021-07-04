package evan.learningprogramming.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(gameConfig.class)
@ComponentScan(basePackages = "evan.learningprogramming")
public class AppConfig {

    // This file is no longer needed since we moved back to constructor based injection. It was only necessary when we used field injection.
    // ==bean methods which produce beans to be managed by the spring container. This is why we Deleted the @Component annotations in the
    //gameimpl and numbergeneratorimpl classes.  The container will now use the below.
    //Deleted here to go back to constructor based injection.

    //here the @import annotation allows for importing bean definitions from another class.

    //Deleted here to go back to constructor based injection in the classes themseleves

//    @Bean
//    public Game game() {
//        return new GameImpl();
//    }
//
//    @Bean
//    public MessageGenerator messageGenerator() {
//        return new MessageGeneratorImpl();
//    }
}
