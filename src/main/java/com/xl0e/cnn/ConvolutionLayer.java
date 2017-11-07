package com.xl0e.cnn;

public class ConvolutionLayer extends NLayer {

    private int fSize;
    private float[][][] input;
    private float[][][] weights;

    public ConvolutionLayer(int filterSize, NLayer prev) {
        input = new float[prev.getDepth()][prev.getWidth() - filterSize][prev.getHeight() - filterSize];
        weights = new float[prev.getDepth()][prev.getWidth() - filterSize][prev.getHeight() - filterSize];
        fSize = filterSize;
        prev.setNext(this);

    }

    @Override
    public int getWidth() {
        return input.length;
    }

    @Override
    public int getHeight() {
        return input[0].length;
    }

    @Override
    public int getDepth() {
        return input[0][0].length;
    }

    @Override
    public void withPrevious(NLayer nLayer) {
        for (int i = 0; i < getDepth(); i++) {

        }
    }

    private float sum(float[][] array, int x, int y) {
        float sum = 0;
        for (int ix = 0; ix < fSize; ix++)
            for (int iy = 0; iy < fSize; iy++) {
                sum += array[x + ix][y + iy];
            }

        return sum;
    }
}
