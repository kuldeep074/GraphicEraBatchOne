/*
 * Copyright (c) 2017. Relsell Global
 */
/*pradeep*/
package in.relsellglobal.reversedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private Button sumbitButton;
    private EditText editText;
    private IReverse iReverse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iReverse = new Reverse();
        initUI();
    }






    private void initUI() {
        sumbitButton = (Button)findViewById(R.id.submitButton);
        editText = (EditText)findViewById(R.id.editText);

        sumbitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // provide definition

                String inputValue = editText.getText().toString();

                String result = iReverse.doReverse(inputValue);

                editText.setText(result);




            }
        });


    }





}
