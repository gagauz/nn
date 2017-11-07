package com.xl0e.cnn;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class InputLayer extends NLayer {
    private static enum RGB {
        RED,
        GREEN,
        BLUE;
    };

    private byte[][][] input;

    public InputLayer(int x, int y) {
        input = new byte[x][y][3];
    }

    public void load(String fileName) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(fileName));
            for (int x = 0; x < input.length; x++)
                for (int y = 0; y < input[x].length; y++) {
                    int rgb = img.getRGB(x, y);
                    input[x][y][RGB.RED.ordinal()] = (byte) (rgb & 0xFF);
                    input[x][y][RGB.GREEN.ordinal()] = (byte) ((rgb >> 8) & 0xFF);
                    input[x][y][RGB.BLUE.ordinal()] = (byte) ((rgb >> 16) & 0xFF);
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        InputLayer l = new InputLayer(20, 20);
        Path p;
        try {
            p = Paths.get(l.getClass().getResource("/lena_std.jpg").toURI());
            l.load(p.toFile().getAbsolutePath());
            System.out.println(l.input);
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

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
}
