package com.industrialmaster.converterx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

public class CtoFActivity extends AppCompatActivity {

    EditText editText,editText4;
    Button button2;
    Button button3;
    Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cto_f);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button5 = (Button) findViewById(R.id.button5);
        editText = (EditText) findViewById(R.id.editText);
        editText4 = (EditText) findViewById(R.id.editText4);

        //editText.setText("0");

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String celval = editText.getText().toString();

                if(celval.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Please enter temperature!",Toast.LENGTH_SHORT).show();
                }
                else{
                    double cel = Double.parseDouble(celval);
                    double far = converttoFar(cel);
                    editText4.setText(String.format("%.2f",far));
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("0");
                editText4.setText("0");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
    }

    public double converttoFar(double cel){
        double far = cel *9/5 + 32;
        return far;
    }
}
