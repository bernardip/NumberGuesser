package au.edu.unsw.infs3634.numberguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainGame extends AppCompatActivity {

    //declares variables to hold xml items
    TextView runningTotalDisplay = null;
    TextView clueDisplay = null;
    TextView trialsLeftDisplay = null;

    /*declares a NumberGenerator object to hold:
        the random number to guess as: randomNumber,
        the number of trials used as: counter,
        the digit that the user inputs as: digit,
        the number that the digits make up as: runningTotal.
     */
    NumberGenerator numbers = new NumberGenerator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);

        //locates text view from xml
        runningTotalDisplay = findViewById(R.id.inputDisplay);

    }

    //method invoked when number icons are clicked
    public void numberClicked(View view) {

        /*
        The following converts user input digits through number buttons into
        a user input number and displays it on screen.
         */

        //holds variable number button from xml as a button
        Button inputDigit = (Button) view;
        //sets digit in NumberGenerator object as number button input
        numbers.setDigit(Integer.parseInt(inputDigit.getText().toString()));
        //sets runningTotal in NumberGenerator object as number currently displayed on screen
        numbers.setRunningTotal(Integer.parseInt(runningTotalDisplay.getText().toString()));
        //resets runningTotal in NumberGenerator object to take into account newly inputted digit
        //pushes existing digits up one to insert new digit on the right
        numbers.setRunningTotal(numbers.getRunningTotal() * 10 + numbers.getDigit());
        //resets number currently displayed on screen to reflect new runningTotal
        runningTotalDisplay.setText(String.valueOf(numbers.getRunningTotal()));

    }

    public void clearClicked(View view) {
        //clears the number currently displayed on screen
        runningTotalDisplay.setText("0");
        //clears the runningTotal variable in NumberGenerator object
        numbers.setRunningTotal(0);
    }

    @SuppressLint("SetTextI18n")
    public void checkClicked(View view) {

        //locates text view from xml
        clueDisplay = findViewById(R.id.tvClueDisplay);
        //locates text view from xml
        trialsLeftDisplay = findViewById(R.id.tvTrialsLeftDisplay);

        //compares runningTotal with randomNumber
        if (numbers.getRunningTotal() > numbers.getRandomNumber()) {

            //displays corresponding message when the guess is too high
            String overMessage = "You're a bit over";
            clueDisplay.setText(overMessage);

            //increases the counter by 1 to reflect trial taken
            numbers.setCounter(numbers.getCounter() + 1);

        } else if (numbers.getRunningTotal() < numbers.getRandomNumber()) {

            //displays corresponding message when the guess is too low
            String underMessage = "You're a bit under";
            clueDisplay.setText(underMessage);

            //increases the counter by 1 to reflect trial taken
            numbers.setCounter(numbers.getCounter() + 1);

        } else {

            //sets corresponding message on the next page when the guess is correct
            String correctMessage = "You're spot on!";
            //takes user to the next page with the message
            launchResultsPage(correctMessage);

            //reset counter to 0 for new game
            numbers.setCounter(0);

        }

        //after trials are taken, checks if user has attempted 5 times.
        if (numbers.getCounter() == 5){

            //if fifth trial is incorrect, takes user to next page but with another message
            launchResultsPage("You didn't get it in 5 trials");

            //reset counter to 0 for new game
            numbers.setCounter(0);
        }

        //clears the number currently displayed on screen
        runningTotalDisplay.setText("0");
        //clears the runningTotal variable in the NumberGenerator object
        numbers.setRunningTotal(0);
        //reduces the "Trials Left: " display by one
        trialsLeftDisplay.setText(String.valueOf(5 - numbers.getCounter()));

    }

    public void launchResultsPage(String result) {

        //Declare intent
        Intent intent = new Intent(MainGame.this, ResultsPage.class);

        //includes message to show on ResultsPage for whether user won or exhausted 5 trials
        intent.putExtra("INTENT_MESSAGE", result);

        //launch activity with intent
        startActivity(intent);

    }
}