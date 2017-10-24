package com.xl0e.nn.core;

public class Synaps {
    float weight;
    private float value;

    public float read() {
        return value;
    }

    public void write(float value) {
        this.value = weight * value;
    }
}
