package com.example.app;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends Activity {

    //declare a file for storing the preferences
    public static final String PREFS_NAME = "MyPrefsFile";
    //declare TimerTask variable
    private TimerTask delayTask;
    //declare Timer variable
    private Timer myTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //Initialize Timer
        myTimer = new Timer();
        //Initialize TimerTask
        delayTask = new TimerTask() {
            @Override
            public void run() {
                //Restore preferences
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                //extract the stored preferences and assign the values to variables
                boolean registrationIsSet = settings.getBoolean("registrationIsSet", false);
                Intent intent = null;
                if(registrationIsSet){
                    //cancel Timer
                    myTimer.cancel();
                    //create an Intent object for this activity
                    intent = new Intent(SplashScreen.this, Menu.class);
                }else{
                    //cancel timer
                    myTimer.cancel();
                    intent = new Intent(SplashScreen.this, GetRegistration.class);
                }

                startActivity(intent);
            }
        };
        myTimer.schedule(delayTask, 2000);
    }

}
