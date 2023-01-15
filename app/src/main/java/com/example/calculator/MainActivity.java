package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Stack;



public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private Sensor lightSensor;
    private SensorEventListener lightEventListener;
    private View root;
    private float maxValue;

    String op="+";
    Double rez;
    EditText expression;
    ArrayList<String> ExpCollection = new ArrayList<String>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        root = findViewById(R.id.root);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        maxValue = lightSensor.getMaximumRange();

        lightEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float value = sensorEvent.values[0];
                //getSupportActionBar().setTitle("Luminosity : " + value + " lx");

                // between 0 and 255
                //int newValue = (int) (255f * value / maxValue);
                //root.setBackgroundColor(Color.rgb(newValue, newValue, newValue));
                if(value < maxValue / 2)
                    root.setBackgroundColor(Color.rgb(205, 127, 50));
                else
                    root.setBackgroundColor(Color.rgb(255,255,255));
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };

        expression = (EditText) findViewById(R.id.Expression);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(lightEventListener, lightSensor, SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(lightEventListener);
    }

    public void Plus(View view)
    {
        try {
            op = "+";
            String text = expression.getText().toString();
            text = text + op;
            //expression.setText(op.toCharArray(), expression.getText().length(), 1);
            expression.setText(text);
        }
        catch (Exception e)
        {expression.setText(e.toString());}
    }
    public void Minus(View view)
    {
        try {
            op = "-";
            String text = expression.getText().toString();
            text = text + op;
            expression.setText(text);
        }
        catch (Exception e)
        {expression.setText(e.toString());}
    }
    public void Multiply(View view)
    {
        try {
            op = "*";
            String text = expression.getText().toString();
            text = text + op;
            expression.setText(text);
        }
        catch (Exception e)
        {expression.setText(e.toString());}
    }
    public void Divide(View view)
    {
        try {
            op = "%";
            String text = expression.getText().toString();
            text = text + op;
            expression.setText(text);
        }
        catch (Exception e)
        {expression.setText(e.toString());}
    }
    public void Write0(View view)
    {
        String text = expression.getText().toString();
        text = text + 0;
        expression.setText(text);
    }
    public void Write1(View view)
    {
        String text = expression.getText().toString();
        text = text + 1;
        expression.setText(text);
    }
    public void Write2(View view)
    {
        String text = expression.getText().toString();
        text = text + 2;
        expression.setText(text);
    }
    public void Write3(View view)
    {
        String text = expression.getText().toString();
        text = text + 3;
        expression.setText(text);
    }
    public void Write4(View view)
    {
        String text = expression.getText().toString();
        text = text + 4;
        expression.setText(text);
    }
    public void Write5(View view)
    {
        String text = expression.getText().toString();
        text = text + 5;
        expression.setText(text);
    }
    public void Write6(View view)
    {
        String text = expression.getText().toString();
        text = text + 6;
        expression.setText(text);
    }
    public void Write7(View view)
    {
        String text = expression.getText().toString();
        text = text + 7;
        expression.setText(text);
    }
    public void Write8(View view)
    {
        String text = expression.getText().toString();
        text = text + 8;
        expression.setText(text);
    }
    public void Write9(View view)
    {
        String text = expression.getText().toString();
        text = text + 9;
        expression.setText(text);
    }
    public void ClearText(View view)
    {
        expression.getText().clear();
    }

    public void ViewHistory(View view)
    {
        Intent intent = new Intent(this,CalcHistory.class);
        intent.putExtra("ExpressionText",ExpCollection);
        startActivity(intent);
    }

    public void Calculate(View view) {

        try {
            String exp = expression.getText().toString();
            ExpCollection.add(exp);
            String[] nums = exp.split("[+*%-]");

            switch (op)
            {

                case "+": {
                    int num1 = Integer.parseInt(nums[0]);
                    int num2 = Integer.parseInt(nums[1]);
                    rez = (double) (num1 + num2);
                    expression.setText(rez.toString());
                    break;
                }
                case "-": {
                    int num1 = Integer.parseInt(nums[0]);
                    int num2 = Integer.parseInt(nums[1]);
                    rez = (double) (num1 - num2);
                    expression.setText(rez.toString());
                    break;
                }
                case "%": {
                    int num1 = Integer.parseInt(nums[0]);
                    int num2 = Integer.parseInt(nums[1]);
                    rez = (double) (num1 / num2);
                    expression.setText(rez.toString());
                    break;
                }
                case "*": {
                    int num1 = Integer.parseInt(nums[0]);
                    int num2 = Integer.parseInt(nums[1]);
                    rez = (double) (num1 * num2);
                    expression.setText(rez.toString());
                    break;
                }


            }
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"Invalid Expression",Toast.LENGTH_LONG).show();
            expression.getText().clear();
        }


    }

}