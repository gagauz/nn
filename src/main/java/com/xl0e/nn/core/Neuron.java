package com.xl0e.nn.core;

public class Neuron {
    Layer layer;

    Synaps[] input;
    Synaps[] output;

    public Neuron(Layer layer) {
        this.layer = layer;
    }

    public void synapsTo(Neuron neuron) {
        Synaps s = new Synaps();
        s.weight = 0.5f;
    }

    public void activate() {
        double inValue = 0;
        for (Synaps in : input) {
            inValue += in.read();
        }

        double outValue = layer.calculateOutput(inValue);

        for (Synaps out : output) {
            out.write(outValue);
        }
    }

}
