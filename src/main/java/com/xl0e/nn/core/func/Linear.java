package com.xl0e.nn.core.func;

import java.util.function.Function;

public class Linear implements Function<Double, Double> {

    public static final Linear INSTANCE = new Linear();

    @Override
    public Double apply(Double x) {
        return x;
    }

}
