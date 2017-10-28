package com.xl0e.nn.core.func;

import static java.lang.Math.E;
import static java.lang.Math.pow;

import java.util.function.Function;

import com.xl0e.nn.core.ActivationFunction;

public class BipolarSigmoid extends ActivationFunction {

    @Override
    public Double apply(Double x) {
        return 2 / (1 + pow(E, -x)) - 1;
    }

    @Override
    public Function<Double, Double> getDerivative() {
        return x -> 0.5 * (1 + apply(x)) * (1 - apply(x));
    }

}
