package com.xl0e.nn.core;

import java.util.ArrayList;
import java.util.List;

import com.xl0e.nn.core.func.BipolarSigmoid;
import com.xl0e.nn.core.util.SB;
import com.xl0e.nn.neuron.Neuron;

public class Layer {

    private ActivationFunction func = new BipolarSigmoid();

    private double agility = 1.0;

    private List<Neuron> neurons;

    public Layer(int count, LayerType type) {
        neurons = new ArrayList<>(count + 1);
        for (int i = 0; i < count; i++) {
            neurons.add(type.apply(this));
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

    public double getAgility() {
        return agility;
    }

    public List<Neuron> getNeurons() {
        return neurons;
    }

    @Override
    public String toString() {
        SB sb = new SB("L [");
        for (Neuron n : neurons) {
            sb.append(n.toString()).append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

}
