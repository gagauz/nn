package com.xl0e.nn.core.util;

public class SB {
    private StringBuilder sb;

    public SB(String s) {
        sb = new StringBuilder(s);
    }

    public SB() {
        sb = new StringBuilder();
    }

    public SB append(String s) {
        sb.append(s);
        return this;
    }

    public SB append(Object s) {
        sb.append(s.toString());
        return this;
    }

    public SB append(double d) {
        sb.append(String.format("%.2f", d));
        return this;
    }

    @Override
    public String toString() {
        return sb.toString();
    }

}
