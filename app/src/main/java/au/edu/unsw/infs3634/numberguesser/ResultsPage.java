package au.edu.unsw.infs3634.numberguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_page);

        //receives intent from MainGame page
        Intent intent = getIntent();
        //looks for message from MainGame page to display result for user
        String result = intent.getStringExtra("INTENT_MESSAGE");
        //finds text view in xml
        TextView resultDisplay = findViewById(R.id.tvResultDisplay);
        //sets text view into message from MainGame page
        resultDisplay.setText(result);

        //finds play again button from xml
        Button playAgain = findViewById(R.id.btnPlayAgain);
        //adds functionality to return to MainActivity (starting page)
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchMainActivity();
            }
        });
    }

    public void launchMainActivity() {

        //declares intent to launch MainActivity
        Intent intent = new Intent(ResultsPage.this, MainActivity.class);
        //launches MainActivity
        startActivity(intent);

    }

}