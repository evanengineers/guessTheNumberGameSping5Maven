package evan.learningprogramming.console;

import evan.learningprogramming.Game;
import evan.learningprogramming.MessageGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component  //As we've marked the class with @component it will be scanned for by the container.  This is also why we can autowire our fields
public class ConsoleNumberGuess {
    // == Constants ==

    private  static  final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    // ==fields ==
    private final Game game;

    private final MessageGenerator messageGenerator;

    // ==Constructors ==
    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    // == Events ==
    @EventListener
    public void start(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("Application event hit! start() --> Container ready for use.");

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();

            game.setGuess(guess);
            game.check();

            if(game.isGameWon() || game.isGameLost()) {
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again y/n?");

                String playAgainString = scanner.nextLine().trim();
                if(!playAgainString.equalsIgnoreCase("y")) {
                    break;
                }
                game.reset();
            }
        }
    }


}
