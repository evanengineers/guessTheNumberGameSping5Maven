package evan.learningprogramming.config;

import evan.learningprogramming.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(gameConfig.class)
@ComponentScan(basePackages = "evan.learningprogramming")
public class AppConfig {

    // ==bean methods which produce beans to be managed by the spring container. This is why we Deleted the @Component annotations in the
    //gameimpl and numbergeneratorimpl classes.  The container will now use the below.

    //here the @import annotation allows for importing bean definitions from another class.

    @Bean
    public Game game() {
        return new GameImpl();
    }

    @Bean
    public MessageGenerator messageGenerator() {
        return new MessageGeneratorImpl();
    }
}
