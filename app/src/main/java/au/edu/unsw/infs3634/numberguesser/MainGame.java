package au.edu.unsw.infs3634.numberguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainGame extends AppCompatActivity {

    TextView runningTotalDisplay = null;
    TextView clueDisplay = null;
    TextView trialsLeftDisplay = null;

    NumberGenerator numbers = new NumberGenerator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);

        runningTotalDisplay = findViewById(R.id.inputDisplay);

    }

    public void numberClicked(View view) {

        Button inputDigit = (Button) view;

        numbers.setDigit(Integer.parseInt(inputDigit.getText().toString()));

        numbers.setRunningTotal(Integer.parseInt(runningTotalDisplay.getText().toString()));

        numbers.setRunningTotal(numbers.getRunningTotal() * 10 + numbers.getDigit());

        runningTotalDisplay.setText(String.valueOf(numbers.getRunningTotal()));

    }

    public void clearClicked(View view) {
        runningTotalDisplay.setText("0");
        numbers.setRunningTotal(0);
    }

    @SuppressLint("SetTextI18n")
    public void checkClicked(View view) {

        clueDisplay = findViewById(R.id.tvClueDisplay);

        trialsLeftDisplay = findViewById(R.id.tvTrialsLeftDisplay);


        if (numbers.getRunningTotal() > numbers.getRandomNumber()) {
            String overMessage = "You're a bit over";
            clueDisplay.setText(overMessage);
            numbers.setCounter(numbers.getCounter() + 1);
        } else if (numbers.getRunningTotal() < numbers.getRandomNumber()) {
            String underMessage = "You're a bit under";
            clueDisplay.setText(underMessage);
            numbers.setCounter(numbers.getCounter() + 1);
        } else if (numbers.getRunningTotal() == numbers.getRandomNumber()) {
            String correctMessage = "You're spot on!";
            launchResultsPage(correctMessage);
            numbers.setCounter(0);
        } else {
            clueDisplay.setText("oh no");
        }

        if (numbers.getCounter() == 5){
            launchResultsPage("You didn't get it in 5 trials");
            numbers.setCounter(0);
        }

        runningTotalDisplay.setText("0");
        numbers.setRunningTotal(0);
        trialsLeftDisplay.setText(String.valueOf(5 - numbers.getCounter()));

    }

    public void launchResultsPage(String result) {

        //Declare intent
        Intent intent = new Intent(MainGame.this, ResultsPage.class);

        intent.putExtra("INTENT_MESSAGE", result);

        //launch activity with intent
        startActivity(intent);

    }
}