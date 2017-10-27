package com.xl0e.nn.core;

public class Layer {

    private ActivationFunction func;

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

    public ActivationFunction getFunction() {
        return func;
    }
}
