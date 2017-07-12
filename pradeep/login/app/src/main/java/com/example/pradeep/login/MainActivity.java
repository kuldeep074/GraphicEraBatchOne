package com.example.pradeep.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button submit;
    private EditText name;
    private EditText password;
    private Icheck icheck;
    private TextView create;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("Reached MAinActivity");
        setContentView(R.layout.activity_main);
        icheck=new Check();
        compare();
    }

    public void onDestroy()
    {
        super.onDestroy();
        System.out.println("Destroy Mainactivity" );
    }

    private void compare()
    {
        submit=(Button)findViewById(R.id.submit);
        name=(EditText)findViewById(R.id.name);
        password=(EditText)findViewById(R.id.password);
        create=(TextView) findViewById(R.id.create);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    String n = name.getText().toString();
                    String p = password.getText().toString();
                    Boolean output = icheck.verify(n, p);
                    if (output) {
                        Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                        //System.out.println("Success");
                    } else {
                        Toast.makeText(MainActivity.this, "Wrong Name or password", Toast.LENGTH_SHORT).show();
                        //System.out.println("Wrong Name or password");
                    }

            }
        });

        //calling signup window
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,MainActivity2.class);
                startActivityForResult(i,1);

            }
        });


    }
}
