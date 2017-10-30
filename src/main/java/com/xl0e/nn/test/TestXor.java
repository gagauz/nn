package com.xl0e.nn.test;

import com.xl0e.nn.core.Network;

public class TestXor {

    static Network network;

    static double[][][] trainSet = new double[][][] {
            { { 0, 0 }, { 0 } },
            { { 1, 0 }, { 1 } },
            { { 0, 1 }, { 1 } },
            { { 1, 1 }, { 0 } },
    };

    public static void main(String[] args) {
        network = new Network(2, 4, 1);
        network.build();
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < trainSet.length; j++) {
                network.setInput(trainSet[j][0]);
                network.activate();
                network.calculateDelta(trainSet[j][1]);
            }
            System.out.println(network);
            System.out.println("Test \n==========================");
            test(0, 0);
            test(1, 0);
            test(0, 1);
            test(1, 1);
            System.out.println();
        }
    }

    private static void test(double a, double b) {
        network.setInput(new double[] { a, b });
        network.activate();
        System.out.println(a + " xor " + b + " = " + network.getOutputLayer().getNeurons().get(0).getOutValue());
    }
}
