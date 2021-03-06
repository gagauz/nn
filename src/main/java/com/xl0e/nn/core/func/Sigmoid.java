package com.xl0e.nn.core.func;

import static java.lang.Math.E;
import static java.lang.Math.pow;

import java.util.function.Function;

import com.xl0e.nn.core.ActivationFunction;

public class Sigmoid implements ActivationFunction {

    public static final Sigmoid INSTANCE = new Sigmoid();

    @Override
    public Double apply(Double x) {
        return 1 / (1 + pow(E, -x));
    }

    @Override
    public Function<Double, Double> getDerivative() {
        return x -> apply(x) * (1 - apply(x));
    }

}
