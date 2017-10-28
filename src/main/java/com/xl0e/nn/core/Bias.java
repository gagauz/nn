package com.xl0e.nn.core;

import com.xl0e.nn.core.util.SB;

public class Bias extends Synaps {

    @Override
    public double getValue() {
        return 1.0;
    }

    @Override
    public void setValue(double value) {
    }

    @Override
    public String toString() {
        SB sb = new SB("B {");
        sb.append(", w: ").append(getWeight());
        sb.append(", d: ").append(getDelta());
        sb.append("}");
        return sb.toString();
    }
}
