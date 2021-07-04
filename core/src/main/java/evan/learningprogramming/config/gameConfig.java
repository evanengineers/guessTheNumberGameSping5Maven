package evan.learningprogramming.config;

import evan.learningprogramming.GuessCount;
import evan.learningprogramming.MaxNumber;
import evan.learningprogramming.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "evan.learningprogramming")
@PropertySource("classpath:Config/game.properties") //if file can't be found, the container will throw a file not found exception
public class gameConfig {

    //Since we are using AppConfig to initialize the container. We can import gameConfig into AppConfig. (Modularizing configurations)
    //To be safe and to keep from having to remember all the string names and to avoid errors when refactoring. We can use qualifiers by
    //adding the annotation to a bean

    // == fields ==
    @Value("${game.maxNumber:20}")  //the ":20" sets the default value, just in case the properties file can't be found in classpath.
    private int maxNumber;  //To get rid of the hard coded values here, we can get them from a properties file.

    @Value("${game.guessCount:5}")
    private int guessCount;

    @Value("${game.minNumber:5}")
    private int minNumber;


    // ==bean methods==
    @Bean
    @MaxNumber
    public int maxNumber() { //Because we now have the qualifers for the the customer annotations in the  @nnotations classes we have to use the field name as the bean method name.
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }

    @Bean
    @MinNumber
    public int minNumber() {
        return minNumber;
    }
}
