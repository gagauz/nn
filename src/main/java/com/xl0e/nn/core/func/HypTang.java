package com.xl0e.nn.core.func;

import static java.lang.Math.E;
import static java.lang.Math.pow;

import java.util.function.Function;

public class HypTang implements Function<Double, Double> {

    @Override
    public Double apply(Double x) {
        return (pow(E, 2 * x) - 1) / (pow(E, 2 * x) + 1);
    }

}
