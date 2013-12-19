package com.example.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by anavarro on 12/19/13.
 */
public class Menu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        //create a button object
        final Button buttonAddRecord = (Button) findViewById(R.id.buttonAddRecord);
        //attach a listener to the button
        buttonAddRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create an Intend object for this activity, including its destination class
                Intent intend = new Intent(Menu.this, AddRecord.class);
                //run the activity
                startActivity(intend);
            }
        });

        final Button buttonEditRecord = (Button) findViewById(R.id.buttonEditRecord);
        buttonEditRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        final Button buttonCalculateConsumption = (Button) findViewById(R.id.buttonCalculateConsumption);
        buttonCalculateConsumption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        final Button buttonDeleteRecord = (Button) findViewById(R.id.buttonDeleteRecord);
        buttonDeleteRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
