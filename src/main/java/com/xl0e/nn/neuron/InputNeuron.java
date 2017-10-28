package com.xl0e.nn.neuron;

import java.util.function.Consumer;

import com.xl0e.nn.core.Layer;
import com.xl0e.nn.core.Synaps;

public class InputNeuron extends Neuron {

    public InputNeuron(Layer layer) {
        super(layer);
    }

    @Override
    public void activate() {
        withOutputs(s -> s.setValue(getOutValue()));
    }

    @Override
    public void withInputs(Consumer<Synaps> c) {
    }

    @Override
    public void calculateDelta(double ideal) {
    }

    @Override
    public void updateWeights(double delta) {

    }

    @Override
    public void setInValue(double d) {
        super.setInValue(d);
        super.setOutValue(d);
    }

    @Override
    public void setOutValue(double d) {
        super.setInValue(d);
        super.setOutValue(d);
    }

    @Override
    public void linkBias() {
    }
}
