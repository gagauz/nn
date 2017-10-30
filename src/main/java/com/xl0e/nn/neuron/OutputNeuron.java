package com.xl0e.nn.neuron;

import java.util.function.Consumer;

import com.xl0e.nn.core.Layer;
import com.xl0e.nn.core.Synaps;

public class OutputNeuron extends Neuron {

    public OutputNeuron(Layer layer) {
        super(layer);
    }

    @Override
    public void calculateDelta(double ideal) {
        double deltaOut = (ideal - getOutValue()) * layer.getFunction().getDerivative().apply(getInValue());
        updateWeights(deltaOut);
    }

    @Override
    public void withOutputs(Consumer<Synaps> c) {
    }
}
