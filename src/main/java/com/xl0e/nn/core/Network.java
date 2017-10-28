package com.xl0e.nn.core;

import com.xl0e.nn.core.util.SB;
import com.xl0e.nn.neuron.Neuron;

public class Network {
    Layer[] layers;

    public Network(int... counts) {
        layers = new Layer[counts.length];
        layers[0] = new Layer(counts[0], LayerType.INPUT);
        layers[counts.length - 1] = new Layer(counts[counts.length - 1], LayerType.OUTPUT);
        for (int i = 1; i < counts.length - 1; i++) {
            layers[i] = new Layer(counts[i], LayerType.HIDDEN);
        }
    }

    public void build() {
        for (int i = 0; i < layers.length - 1; i++) {
            for (Neuron n1 : layers[i].getNeurons()) {
                for (Neuron n2 : layers[i + 1].getNeurons()) {
                    n1.linkTo(n2);
                    // n2.linkBias();
                }
            }
        }
        int n = layers[0].getNeurons().size();
        int p = layers[1].getNeurons().size();
        for (int i = 0; i < layers.length; i++) {
            for (Neuron n1 : layers[i].getNeurons()) {
                // n1.linkBias();
                // n1.build(n, p);
            }
        }

    }

    public void calculateDelta(double[] ideals) {
        for (int i = layers.length - 1; i > -1; i--) {
            for (int j = 0; j < layers[i].getNeurons().size(); j++) {
                layers[i].getNeurons().get(j).calculateDelta(j < ideals.length ? ideals[j] : 0.0);
            }
        }
        for (int i = 0; i < layers.length; i++) {
            for (int j = 0; j < layers[i].getNeurons().size(); j++) {
                // layers[i].getNeurons().get(j).updateWeights();
            }
        }
    }

    public void setInput(double[] set) {
        for (int i = 0; i < getInputLayer().getNeurons().size(); i++) {
            getInputLayer().getNeurons().get(i).setInValue(set[i]);
        }
    }

    public Layer getInputLayer() {
        return layers[0];
    }

    public Layer getOutputLayer() {
        return layers[layers.length - 1];
    }

    public void activate() {
        for (Layer l : layers) {
            l.activate();
        }
    }

    @Override
    public String toString() {
        SB sb = new SB();
        sb.append("===\n");
        for (Layer l : layers) {
            sb.append(l).append("\n");
        }
        sb.append("===\n");
        return sb.toString();
    }
}
