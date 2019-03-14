package com.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int mscore1;
    private int mscore2;

    private TextView mScoreText1;
    private TextView mScoreText2;


    static final String STATE_SCORE_1="Team 1 Score";
    static final String STATE_SCORE_2="Team 2 Score";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreText1 = (TextView) findViewById(R.id.score_1);
        mScoreText2 = (TextView) findViewById(R.id.score_2);

        if (savedInstanceState != null) {
            mscore1 = savedInstanceState.getInt(STATE_SCORE_1);
            mscore2 = savedInstanceState.getInt(STATE_SCORE_2);

            //Set the score text views
            mScoreText1.setText(String.valueOf(mscore1));
            mScoreText2.setText(String.valueOf(mscore2));
        }
    }

    public void decreaseScore(View view) {
        int viewID = view.getId();
        switch (viewID) {
            case R.id.decreaseTeam1:
                mscore1--;
                mScoreText1.setText(String.valueOf(mscore1));
                break;
            case R.id.decreaseTeam2:
                mscore2--;
                mScoreText2.setText(String.valueOf(mscore2));
        }
    }


    public void increaseScore(View view) {
        int ViewID = view.getId();
        switch (ViewID) {
            case R.id.increaseTeam1:
                mscore1++;
                mScoreText1.setText(String.valueOf(mscore1));
                break;
            case R.id.increaseTeam2:
                mscore2++;
                mScoreText2.setText(String.valueOf(mscore2));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        int nightMode =AppCompatDelegate.getDefaultNightMode();

        if(nightMode==AppCompatDelegate.MODE_NIGHT_YES ){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        }else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.night_mode) {
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
        }

        return true;
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Save the scores.
        outState.putInt(STATE_SCORE_1, mscore1);
        outState.putInt(STATE_SCORE_2, mscore2);
        super.onSaveInstanceState(outState);
    }
}




