package evan.learningprogramming.console;

import evan.learningprogramming.config.gameConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    //commenting out the below line after deleting the beans.xml since its no longer needed.
    //private static final String CONFIG_LOCATION = "beans.xml"; //location of config of the container

    public static void main(String[] args) {
        log.info("Guess the number game.");

        //create context (container)  ....below configapplication context is an interface. so we're instantiating the classpath context and assigning it to the context var
        //ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);//defines the context to IOC container
        //commented out the above line since we aren't using the beans.xml classpath anymore. As we move to Anntations, the below line was added as the new class now
        //contains the config for the container.

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(gameConfig.class);//defines the context to IOC container

        //get number generator beam from context (container)
        //below we are asking the container for the bean instance by name and type
//        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        //call method next() to get a random number
//        int number = numberGenerator.next();

        //log generated number/ curly braces are place holder. will be replaced with number value after the comma.
//        log.info("number = {}", number);


        //get game beam from context (container)
        //Game game = context.getBean(Game.class);  //no longer needed since we getting the line below.

//        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
//        log.info("getMainMessage= {}", messageGenerator.getMainMessage());
//        log.info("getResultMessage= {}", messageGenerator.getResultMessage());

        //call reset method to reset the game
        //game.reset();
        //instead of using the above reset method, you can use init method. Add this to beans.xml to the actual game bean.
        //keep in mind that this way is also prone to errors cuz you would need to add a init to every bean.
        //Could also add a default init and destroy to the parent bean. ex in bean.xml.
        //best case scenario is to use post-construct and pre-destroy methods instead of specifying in the above manners.

        //close the context (container)
        context.close();


    }

    //i.o.c = inversion of control container
    //ioc contains beans and manages their lifecycle
    //beans are java objects instantiated and managed by ioc

    //using the @autowire annotation we can inject depencies in multiple ways
    //by using setter methods, constructors, or instance variables


}
