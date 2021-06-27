package evan.learningprogramming;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "evan.learningprogramming")
public class AppConfig {

    // ==bean methods which produce beans to be managed by the spring container. This is why we Deleted the @Component annotations in the
    //gameimpl and numbergeneratorimpl classes.  The container will now use the below.

    @Bean
    public NumberGenerator numberGenerator() {
        return new NumberGeneratorImpl();
    }

    @Bean
    public Game game() {
        return new GameImpl();
    }

    @Bean
    public MessageGenerator messageGenerator() {
        return new MessageGeneratorImpl();
    }
}
