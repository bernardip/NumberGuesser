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

        Intent intent = getIntent();

        String result = intent.getStringExtra("INTENT_MESSAGE");

        TextView resultDisplay = findViewById(R.id.tvResultDisplay);

        resultDisplay.setText(result);


        Button playAgain = findViewById(R.id.btnPlayAgain);

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchMainActivity();
            }
        });
    }

    public void launchMainActivity() {

        Intent intent = new Intent(ResultsPage.this, MainActivity.class);

        startActivity(intent);

    }

}