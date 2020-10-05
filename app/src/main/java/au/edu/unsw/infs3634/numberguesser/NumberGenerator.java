package au.edu.unsw.infs3634.numberguesser;

import java.io.Serializable;

public class NumberGenerator implements Serializable {

    private int counter = 0;
    private int digit;
    private int runningTotal;
    private int randomNumber = generateNumber();

    public static int generateNumber() {
        return (int) (Math.random() * 100);
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getDigit() {
        return digit;
    }

    public void setDigit(int digit) {
        this.digit = digit;
    }

    public int getRunningTotal() {
        return runningTotal;
    }

    public void setRunningTotal(int runningTotal) {
        this.runningTotal = runningTotal;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }
}
