package com.xl0e.nn.core.func;

import java.util.function.Function;

import com.xl0e.nn.core.ActivationFunction;

public class ReLU implements ActivationFunction {

    public static final ReLU INSTANCE = new ReLU();

    @Override
    public Double apply(Double x) {
        return Math.max(0, x);
    }

    @Override
    public Function<Double, Double> getDerivative() {
        return x -> x < 0 ? 0.0 : 1.0;
    }

}
