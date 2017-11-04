package com.xl0e.nn.core.func;

import java.util.function.Function;

import com.xl0e.nn.core.ActivationFunction;

public enum Activators implements ActivationFunction {
    ;

    private ActivationFunction func;

    Activators(ActivationFunction f) {
        this.func = f;
    }

    @Override
    public Double apply(Double t) {
        return func.apply(t);
    }

    @Override
    public Function<Double, Double> getDerivative() {
        return func.getDerivative();
    }

}
