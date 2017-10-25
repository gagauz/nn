package com.xl0e.nn.core;

import java.util.function.Function;

public class Layer {

    Function<Double, Double> func;

    Neuron[] neurons;

    public Layer(int count) {
        this.neurons = new Neuron[count];
        for (int i = 0; i < count; i++) {
            this.neurons[i] = new Neuron(this);
        }
    }

    public void activate() {
        for (Neuron n : neurons) {
            n.activate();
        }
    }

    public double calculateOutput(double value) {
        return func.apply(value);
    }
}
