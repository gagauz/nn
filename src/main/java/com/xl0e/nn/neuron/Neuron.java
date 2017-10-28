package com.xl0e.nn.neuron;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.xl0e.nn.core.Bias;
import com.xl0e.nn.core.Layer;
import com.xl0e.nn.core.Synaps;
import com.xl0e.nn.core.util.SB;

public abstract class Neuron {
    protected Layer layer;

    private double inValue;
    private double outValue;

    protected List<Synaps> inputs;
    protected List<Synaps> outputs;

    public Neuron(Layer layer) {
        this.layer = layer;
    }

    public void activate() {
        inValue = 0.0;
        for (Synaps in : inputs) {
            inValue += in.getValue() * in.getWeight();
        }
        setOutValue(layer.getFunction().apply(inValue));
        withOutputs(s -> s.setValue(getOutValue()));
    }

    public double getInValue() {
        return inValue;
    }

    public void setInValue(double d) {
        inValue = d;
    }

    public double getOutValue() {
        return outValue;
    }

    public void setOutValue(double d) {
        outValue = d;
    }

    public abstract void calculateDelta(double ideal);

    @Override
    public String toString() {
        SB sb = new SB();
        sb.append("N {vi: ")
                .append(inValue)
                .append(", vo:")
                .append(outValue)
                .append(", in: [");
        if (null != inputs)
            inputs.forEach(s -> sb.append(s).append(", "));
        sb.append("], out: [");
        if (null != outputs)
            outputs.forEach(s -> sb.append(s).append(", "));
        sb.append("]}");
        return sb.toString();
    }

    public void withOutputs(Consumer<Synaps> c) {
        if (null != outputs) {
            outputs.forEach(c);
        }
    }

    public void withInputs(Consumer<Synaps> c) {
        if (null != inputs) {
            inputs.forEach(c);
        }
    }

    public void updateWeights(double delta) {
        withInputs(s -> {
            s.setDelta(delta * s.getWeight());
            double dW = layer.getAgility() * delta * s.getValue();
            s.setWeight(s.getWeight() + dW);
        });
    }

    public void linkTo(Neuron n2) {
        Synaps s = new Synaps();
        if (null == outputs) {
            outputs = new ArrayList<>();
        }
        if (null == n2.inputs) {
            n2.inputs = new ArrayList<>();
        }
        outputs.add(s);
        n2.inputs.add(s);
    }

    public void linkBias() {
        inputs.add(new Bias());
    }

    public void build(int n, int p) {
    }
}
