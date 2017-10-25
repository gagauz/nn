package com.xl0e.nn.core;

public class Neuron {
    Layer layer;

    Synaps[] input = new Synaps[0];
    Synaps[] output = new Synaps[0];

    public Neuron(Layer layer) {
        this.layer = layer;
    }

    public void synapsTo(Neuron neuron) {
        Synaps s = new Synaps();
    }

    public void activate() {
        double inValue = 0.0;

        for (Synaps in : input) {
            inValue += in.read();
        }

        double outValue = layer.calculateOutput(inValue);

        for (Synaps out : output) {
            out.write(outValue);
        }
    }

    public void write(double value) {
        for (Synaps out : output) {
            out.write(value);
        }
    }

}
