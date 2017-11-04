package com.xl0e.nn.neuron;

import com.xl0e.nn.core.Layer;
import com.xl0e.nn.core.Synaps;

public class HiddenNeuron extends Neuron {

    public HiddenNeuron(Layer layer) {
        super(layer);
    }

    @Override
    public void calculateDelta(double ideal) {
        double deltaIn = 0.0;
        for (Synaps s : outputs) {
            deltaIn += s.getDelta();
        }
        final double deltaOut = deltaIn * layer.getFunction().getDerivative().apply(getInValue());

        updateWeights(deltaOut);
    }

    @Override
    public void build(int n, int p) {
        double B = 0.7 * Math.pow(p, 1 / n);
        double sum = 0.0;
        for (Synaps s : inputs) {
            sum += Math.pow(s.getWeight(), 2);
        }
        sum = Math.sqrt(sum);
        for (Synaps s : inputs) {
            s.setWeight(B * s.getWeight() / sum);
        }
    }
}
