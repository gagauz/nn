package com.xl0e.nn.core.func;

import static java.lang.Math.E;
import static java.lang.Math.pow;

import java.util.function.Function;

import com.xl0e.nn.core.ActivationFunction;

public class HypTang extends ActivationFunction {

    @Override
    public Double apply(Double x) {
        return (pow(E, 2 * x) - 1) / (pow(E, 2 * x) + 1);
    }

    @Override
    public Function<Double, Double> getDerivative() {
        return x -> 1 - x * x;
    }

}
