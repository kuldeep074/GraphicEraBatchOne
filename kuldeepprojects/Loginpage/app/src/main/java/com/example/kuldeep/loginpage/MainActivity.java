package com.example.kuldeep.loginpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button submit;
    private EditText name;
    private EditText password;
    private Icheck icheck;
    private TextView signup;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
 super.onCreate(savedInstanceState);
    System.out.println("reached Main activity");
        setContentView(R.layout.activity_main);
    icheck=new Check();
    compare();


}
    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("Destroy main activity");
    }
private void compare()
{

    submit=(Button)findViewById(R.id.submit);
    name=(EditText)findViewById(R.id.name);
    password=(EditText)findViewById(R.id.password);
    signup=(TextView) findViewById(R.id.signup);
    submit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            String n = name.getText().toString();
            String p = password.getText().toString();
            Boolean output = icheck.verify(n, p);
            if (output) {
                Toast.makeText(MainActivity.this, "Success",Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(MainActivity.this, "invalid id and password", Toast.LENGTH_SHORT).show();
            }

        }
    });

    signup.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


           Intent i=new Intent(MainActivity.this,MainActivity2.class);
            startActivity(i);

        }
    });

}
}
