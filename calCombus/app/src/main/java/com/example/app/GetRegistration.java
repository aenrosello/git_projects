package com.example.app;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by anavarro on 12/19/13.
 */
public class GetRegistration extends Activity {

    public static final String PREFS_NAME = "MyPrefsFile";

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_registration);
        final Button saveRegistrationButton = (Button) findViewById(R.id.buttonSaveRegistration);
        saveRegistrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextRegistration = (EditText) findViewById(R.id.editTextRegistration);
                String registrationNumber = editTextRegistration.getText().toString();
                //create shared preference object
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                //create a shared preference editor to modify the shared preference
                SharedPreferences.Editor editor = settings.edit();
                //put the variables in the editor
                editor.putBoolean("registrationIsSet", true);
                editor.putString("registrationNumber", registrationNumber);

                //commit changes
                editor.commit();

                //create an intent object and tell it where to go
                Intent intent = new Intent(GetRegistration.this, Menu.class);
                //start intent
                startActivity(intent);
            }
        });
    }
}
