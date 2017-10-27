package com.xl0e.nn.core;

import java.util.ArrayList;
import java.util.List;

public class Neuron {
    Layer layer;

    List<Synaps> input = new ArrayList<>();
    List<Synaps> output = new ArrayList<>();

    private double outValue;

    public Neuron(Layer layer) {
        this.layer = layer;
    }

    public void activate() {
        double inValue = 0.0;

        for (Synaps in : input) {
            inValue += in.read();
        }

        outValue = layer.getFunction().apply(inValue);

        for (Synaps out : output) {
            out.write(outValue);
        }
    }

    public void setInput(double value) {
        for (Synaps out : output) {
            out.write(value);
        }
    }

    public void compareToIdeal(double ideal) {
        double delta = 0;
        if (output.isEmpty()) {
            delta = (ideal - outValue) * layer.getFunction().getDerivative().apply(outValue);
        } else {
            delta = (ideal - outValue) * layer.getFunction().getDerivative().apply(outValue);
        }
        for (Synaps s : input) {

        }
    }
}
