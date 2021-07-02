package evan.learningprogramming;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;


public class NumberGeneratorImpl implements NumberGenerator {

    //== fields ==
    private final Random random = new Random();

    @Autowired
    private int maxNumber;

    //==public methods ==
    @Override
    public int next() {
        return random.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
