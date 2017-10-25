package com.xl0e.nn.core;

public class Network {
    Layer[] layers;

    public Network(int... counts) {
        layers = new Layer[counts.length];
        for (int i = 0; i < counts.length; i++) {
            layers[i] = new Layer(counts[i]);
        }
    }

    public void build() {
        for (int i = 0; i < layers.length - 1; i++) {
            for (Neuron n1 : layers[i].neurons) {
                for (Neuron n2 : layers[i + 1].neurons) {
                    n1.synapsTo(n2);
                }
            }
        }
    }

    public void train(int[] set) {
        for (int i = 0; i < getInputLayer().neurons.length; i++) {
            getInputLayer().neurons[i].write(set[i]);
        }
    }

    public Layer getInputLayer() {
        return layers[0];
    }

    public Layer getOutputLayer() {
        return layers[layers.length - 1];
    }

}
