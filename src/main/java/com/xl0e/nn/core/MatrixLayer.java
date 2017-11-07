package com.xl0e.nn.core;

import java.util.function.Consumer;

import com.xl0e.nn.neuron.Neuron;

public class MatrixLayer {
    private Synaps[][][] matrix;

    public MatrixLayer(int w, int h, int d) {
        matrix = new Synaps[w][h][d];
    }

    public void walk(int x1, int x2, int y1, int y2, Consumer<Neuron[]> consumer) {

    }
}
