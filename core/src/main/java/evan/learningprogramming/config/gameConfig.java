package evan.learningprogramming.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class gameConfig {

    //Since we are using AppConfig to initialize the container. We can import gameConfig into AppConfig. (Modularizing configurations)
    //To be safe and to keep from having to remember all the string names and to avoid errors when refactoring. We can use qualifiers by
    //adding the annotation to a bean

    // == fields ==
    private int maxNumber = 25;
    private int guessCount = 8;


    // ==bean methods==
    @Bean
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    public int guessCount() {
        return guessCount;
    }
}
