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
            for (int j = 0; j < layers[i].neurons.length; j++) {
                for (int k = 0; k < layers[i + 1].neurons.length; k++) {
                    layers[i].neurons[j].outputTo(layers[i + 1].neurons[k]);
                }
            }
        }
    }

}
