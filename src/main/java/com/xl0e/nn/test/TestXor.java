package com.xl0e.nn.test;

import com.xl0e.nn.core.Network;

public class TestXor {

    static int[][] trainSet = new int[][] {
            { 0, 0, 0 },
            { 1, 0, 1 },
            { 0, 1, 1 },
            { 1, 1, 0 }
    };

    public static void main(String[] args) {
        Network network = new Network(2, 4, 1);
        network.build();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < trainSet.length; j++) {
                network.train(trainSet[j]);
            }
        }
    }
}
