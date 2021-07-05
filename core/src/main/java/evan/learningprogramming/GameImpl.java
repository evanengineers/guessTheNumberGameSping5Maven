package evan.learningprogramming;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
@Slf4j
@Getter

@Component
public class GameImpl implements Game {

    // == contants ==
//    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    // ==fields ==
//@Autowired  //<this annotation wires the number generator dependency. using this instead of setter based DI

    @Getter(AccessLevel.NONE)  //As we have added @getter lombok annotation on the class we can get rid of all other getters and set the access level here where we don't need a getter
    private final NumberGenerator numberGenerator;
    private final int guessCount;

    private int number;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    @Setter
    private int guess;

    // == contructors ==
//    the below constructor can be used if doing a constructor based dependency injection in beans.xml. see example there.
    @Autowired
    public GameImpl(NumberGenerator numberGenerator, @GuessCount int guessCount) {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

//  Else you can use a setter based DI which can see an example of below.


    // ==init method ==
    @PostConstruct //this annotation is possible because of the javax.annotations dependency in POM.xml
    @Override
    public void reset() {
        smallest = numberGenerator.getMinNumber();
        guess = numberGenerator.getMinNumber();
        remainingGuesses = guessCount;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.debug("The number is {}", number);
    }

    @PreDestroy //this annotation is possible becuase of the javax.annotations dependency in POM.xml
    public void preDestroy() {
        log.info("in Game preDestroy()");
    }

    // == public methods ==
//commenting this out as it is only used when doing setter based DI.
//    public void setNumberGenerator(NumberGenerator numberGenerator) {
//        this.numberGenerator = numberGenerator;
//    }
// Getting rid of all getters since we added the class level @getter annotation
//    @Override
//    public int getNumber() {
//        return number;
//    }
//
//    @Override
//    public int getGuess() {
//        return guess;
//    }

//    @Override
//    public void setGuess(int guess) {
//        this.guess = guess;
//    }

//    @Override
//    public int getSmallest() {
//        return smallest;
//    }
//
//    @Override
//    public int getBiggest() {
//        return biggest;
//    }
//
//    @Override
//    public int getRemainingGuesses() {
//        return remainingGuesses;
//    }
//
//
//    @Override
//    public int getGuessCount() {
//        return guessCount;
//    }

    @Override
    public void check() {
        checkValidNumberRange();

        if (validNumberRange) {
            if (guess > number) {
                biggest = guess - 1;
            }
            if (guess < number) {
                smallest = guess + 1;
            }
        }
        remainingGuesses--;

    }

//    @Override
//    public boolean isValidNumberRange() {
//        return validNumberRange;
//    }

    @Override
    public boolean isGameWon() {

        return guess == number;

    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    // == private methods ==

    private void checkValidNumberRange() {
        validNumberRange = ((guess >= smallest) && (guess <= biggest));
    }
}
