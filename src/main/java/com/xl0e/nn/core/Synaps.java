package com.xl0e.nn.core;

import java.util.Random;

import com.xl0e.nn.core.util.SB;

public class Synaps {

    private static final Random R = new Random(1);

    private double value;
    private double weight = 0.5 - R.nextDouble();
    private double delta;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getDelta() {
        return delta;
    }

    public void setDelta(double error) {
        this.delta = error;
    }

    @Override
    public String toString() {
        SB sb = new SB("S {");
        sb.append("v: ").append(getValue());
        sb.append(", w: ").append(weight);
        sb.append(", d: ").append(delta);
        sb.append("}");
        return sb.toString();
    }

}
