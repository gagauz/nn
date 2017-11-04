package com.xl0e.nn.core;

import java.util.function.Function;

public interface ActivationFunction extends Function<Double, Double> {

    Function<Double, Double> getDerivative();
}
