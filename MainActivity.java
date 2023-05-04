package com.example.colores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private TextView tv_x, tv_y, tv_z;
    private ConstraintLayout pantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor sensor=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        tv_x=findViewById(R.id.tv_acc_x);
        tv_y=findViewById(R.id.tv_acc_y);
        tv_z=findViewById(R.id.tv_acc_z);
        pantalla=findViewById(R.id.pantalla);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        tv_x.setText(String.valueOf(sensorEvent.values[0]));
        tv_y.setText(String.valueOf(sensorEvent.values[1]));
        tv_z.setText(String.valueOf(sensorEvent.values[2]));
        float x=sensorEvent.values[0];
        float y=sensorEvent.values[1];
        float z=sensorEvent.values[2];
        pantalla.setBackgroundColor(Math.round(10*x-10*y+10*z));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}