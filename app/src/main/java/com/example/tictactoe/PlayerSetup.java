package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PlayerSetup extends AppCompatActivity {

    private EditText player1;
    private EditText player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_setup);

        player1 = findViewById(R.id.editTextName1);
        player2 = findViewById(R.id.editTextName2);
    }

    public void submitNames(View view) {
        String playerName1 = player1.getText().toString();
        String playerName2 = player2.getText().toString();

        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("Player_names", new String[] {playerName1, playerName2});
        startActivity(intent);
    }
}