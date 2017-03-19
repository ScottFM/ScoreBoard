package com.example.scott.scoreboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Scott on 3/17/2017.
 */

public class Basketball extends AppCompatActivity implements View.OnClickListener {

    TextView txtHome, txtAway, homeScore, awayScore;
    int home, away;
    Button home1, home2, home3, away1, away2, away3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basketball);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initialize();
    }

    public void initialize() {
        home = 0;
        away = 0;
        txtHome = (TextView) findViewById(R.id.txtHome);
        txtAway = (TextView)findViewById(R.id.txtAway);
        homeScore = (TextView) findViewById(R.id.txtHomeScore);
        awayScore = (TextView) findViewById(R.id.txtAwayScore);
        home1 = (Button) findViewById(R.id.btnHome1);
        home1.setOnClickListener(this);
        home2 = (Button) findViewById(R.id.btnHome2);
        home2.setOnClickListener(this);
        home3 = (Button) findViewById(R.id.btnHome3);
        home3.setOnClickListener(this);
        away1 = (Button) findViewById(R.id.btnAway1);
        away1.setOnClickListener(this);
        away2 = (Button) findViewById(R.id.btnAway2);
        away2.setOnClickListener(this);
        away3 = (Button) findViewById(R.id.btnAway3);
        away3.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id) {
            case R.id.action_Soccer:
                Intent I = new Intent("com.example.Scott.ScoreBoard.Main");
                finish();
                startActivity(I);
                break;
            case R.id.action_Basketball:
                break;
            case R.id.action_Reset:
                home = 0;
                away = 0;
                setHome(home);
                setAway(away);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAway1:
                away++;
                setAway(away);
                break;
            case R.id.btnAway2:
                away+=2;
                setAway(away);
                break;
            case R.id.btnAway3:
                away+=3;
                setAway(away);
                break;
            case R.id.btnHome1:
                home++;
                setHome(home);
                break;
            case R.id.btnHome2:
                home+=2;
                setHome(home);
                break;
            case R.id.btnHome3:
                home+=3;
                setHome(home);
                break;
        }
        //awayScore.setText(String.valueOf(away));
        //homeScore.setText(String.valueOf(home));

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        savedInstanceState.putInt("Home", home);
        savedInstanceState.putInt("Away", away);
        // etc.
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        home = savedInstanceState.getInt("Home");
        away = savedInstanceState.getInt("Away");
        setHome(home);
        setAway(away);
        //homeScore.setText(home);
        //awayScore.setText(away);
    }

    public void setHome(int h) {
        homeScore.setText(String.valueOf(h));
    }

    public void setAway(int a) {
        awayScore.setText(String.valueOf(a));
    }

}
