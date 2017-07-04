package com.example.ankit.ankitlogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupVariables();
    }

    public void authenticateLogin(View view) {
        {

        if (username.getText().toString() .equals("jarvis")&&
                password.getText().toString().equals("spurs")) {
            Toast.makeText(MainActivity.this, "Hello jarvis successfully logged IN", Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(MainActivity.this, "Security breach seems like you r not jarvis !", Toast.LENGTH_SHORT).show();
               }
    }
}


    private void setupVariables() {

        username = (EditText) findViewById(R.id.usernameET);
        password = (EditText) findViewById(R.id.passwordET);
        Login = (Button) findViewById(R.id.LoginBtn);
    }
}