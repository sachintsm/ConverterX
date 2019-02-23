package com.industrialmaster.converterx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

public class FtoCActivity extends AppCompatActivity {

    EditText editText2,editText3;
    Button button6;
    Button button7;
    Button button9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fto_c);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button9 = (Button) findViewById(R.id.button9);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText2 = (EditText) findViewById(R.id.editText2);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String farval = editText2.getText().toString();

                if(farval.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Please enter temperature!",Toast.LENGTH_SHORT).show();
                }
                else{
                    double cel = Double.parseDouble(farval);
                    double far = converttoCel(cel);
                    editText3.setText(String.format("%.2f",far));
                }
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText3.setText("0");
                editText2.setText("0");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
    }
    public double converttoCel(double far){
        double cel = (far - 32) * 5/9   ;
        return cel;
    }
}
