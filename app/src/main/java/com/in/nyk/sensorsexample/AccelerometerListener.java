package com.in.nyk.sensorsexample;

/**
 * Created by nikhilkanse on 19/02/18.
 */

    public interface AccelerometerListener {

        public void onAccelerationChanged(float x, float y, float z);

        public void onShake(float force);

    }

