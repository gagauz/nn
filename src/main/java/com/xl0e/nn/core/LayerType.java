package com.xl0e.nn.core;

import java.util.function.Function;

import com.xl0e.nn.neuron.HiddenNeuron;
import com.xl0e.nn.neuron.InputNeuron;
import com.xl0e.nn.neuron.Neuron;
import com.xl0e.nn.neuron.OutputNeuron;

public enum LayerType implements Function<Layer, Neuron> {
    INPUT(InputNeuron::new),
    HIDDEN(HiddenNeuron::new),
    OUTPUT(OutputNeuron::new);

    private Function<Layer, Neuron> factory;

    LayerType(Function<Layer, Neuron> factory) {
        this.factory = factory;
    }

    @Override
    public Neuron apply(Layer t) {
        return factory.apply(t);
    }

}
