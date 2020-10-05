package au.edu.unsw.infs3634.numberguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //locates start button from xml
        Button btnStart = findViewById(R.id.btnStart);

        //adds functionality to start button to start game
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchMainGame();
            }
        });

    }

    public void launchMainGame() {

        //Declare intent
        Intent intent = new Intent(MainActivity.this, MainGame.class);

        //launch activity with intent
        startActivity(intent);

    }

}