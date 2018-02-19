package com.in.nyk.sensorsexample;

import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by nikhilkanse on 19/02/18.
 */

public class GyroscopeSensorActivity extends Activity {


    private SensorManager sensorManager;
    private Sensor gyroScopeSensor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiateSensors();
    }

    private void initiateSensors(){
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        gyroScopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        if(gyroScopeSensor == null) {
            Log.e("MainActivity :- ", "Gyroscope sensor not available.");
            finish(); // Close app
        }else  {
            sensorManager.registerListener(proximitySensorListener, gyroScopeSensor,2 * 1000 * 1000);
        }
    }

    // Create listener
    SensorEventListener proximitySensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            // More code goes here
            if(sensorEvent.values[2] > 0.5f) { // anticlockwise
                getWindow().getDecorView().setBackgroundColor(Color.BLUE);
            } else if(sensorEvent.values[2] < -0.5f) { // clockwise
                getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    };

}
