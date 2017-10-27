package com.xl0e.nn.core;

import java.util.function.Function;

public abstract class ActivationFunction implements Function<Double, Double> {

    public abstract Function<Double, Double> getDerivative();
}
