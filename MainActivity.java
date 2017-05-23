package com.example.admin.jogodavelha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.admin.jogodavelha.GameView.ICellListener;
import com.example.admin.jogodavelha.GameView.State;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.SinglePlayerMode).setOnClickListener(
                new OnClickListener() {
                    public void onClick(View v) {
                        startGame(true);
                    }
                });

        findViewById(R.id.MultiPlayerMode).setOnClickListener(
                new OnClickListener() {
                    public void onClick(View v) {
                        startGame(false);
                    }
                });
    }

    private void startGame(boolean startWithHuman) {
        Intent i = new Intent(this, GameActivity.class);
        i.putExtra(GameActivity.EXTRA_START_PLAYER,
                startWithHuman ? State.PLAYER1.getValue() : State.PLAYER2.getValue());
        startActivity(i);
    }
}
