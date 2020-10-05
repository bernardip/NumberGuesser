package au.edu.unsw.infs3634.numberguesser;

import java.io.Serializable;

public class NumberGenerator implements Serializable {

    //user trials used
    private int counter = 0;
    //user input digit
    private int digit;
    //user number input from digits
    private int runningTotal;
    //random number for user to guess
    private int randomNumber = generateNumber();

    //generates a random number between 0 and 100
    public static int generateNumber() {
        return (int) (Math.random() * 100);
    }

    //setters and getters

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
