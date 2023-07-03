package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int secretNumber;
    private EditText guessInput;
    private Button guessButton;
    private int attempts;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guessInput = findViewById(R.id.guess_input);
        guessButton = findViewById(R.id.guess_button);
        resultText = findViewById(R.id.result_text);
        attempts = 0;

        generateSecretNumber();

        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userGuess = Integer.parseInt(guessInput.getText().toString());
                attempts++;

                if (userGuess < secretNumber) {
                    resultText.setText("Too low! Try again.");
                } else if (userGuess > secretNumber) {
                    resultText.setText("Too high! Try again.");
                } else {
                    String message = "Congratulations! You guessed the number in " + attempts + " attempts.";
                    resultText.setText(message);
                    generateSecretNumber();
                    attempts = 0;
                }

                guessInput.setText("");
            }
        });
    }

    private void generateSecretNumber() {
        Random random = new Random();
        secretNumber = random.nextInt(100) + 1;
    }
}
