package com.VinGoogle.mytoll;

import android.content.Intent;

import android.content.SharedPreferences;
import com.VinGoogle.mytoll.R;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 3000;
    public static final String PREFS_NAME = "Preference";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
           getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            setContentView(R.layout.activity_main);

            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            SharedPreferences.Editor editor = settings.edit();
            String username = settings.getString("username", "");

            if (username.equals("")) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i = new Intent(MainActivity.this, Main2Activity.class);
                        MainActivity.this.startActivity(i);
                        MainActivity.this.finish();
                    }
                }, SPLASH_DISPLAY_LENGTH);
            } else {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i = new Intent(MainActivity.this, Main3Activity.class);
                        startActivity(i);
                        finish();
                    }
                }, SPLASH_DISPLAY_LENGTH);
            }

        }
    }//end of onCreate }


