package com.example.temperature;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
 EditText e;
 Button b1,b2;
    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e=findViewById(R.id.editTextNumber);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        b1.setOnClickListener(view -> {
            double p =Double.parseDouble(e.getText().toString());
            double k=((1.8*p)+32);
            e.setText(String.format("%.2f",k));
            Toast.makeText(MainActivity.this,String.format("%.2f",k)+"F",Toast.LENGTH_SHORT).show();
        });
        b2.setOnClickListener(view -> {
            double p1 =Double.parseDouble(e.getText().toString());
            double k1=((p1-32)*5)/9;
            e.setText(String.format("%.2f",k1));
            Toast.makeText(MainActivity.this,String.format("%.2f",k1)+"C",Toast.LENGTH_SHORT).show();
        });
    }
}