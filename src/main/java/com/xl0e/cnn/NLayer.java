package com.xl0e.cnn;

import java.util.Optional;

public abstract class NLayer {

    private NLayer next;

    public NLayer getNext() {
        return next;
    }

    public void setNext(NLayer next) {
        this.next = next;
    }

    public final void forward() {
        Optional.ofNullable(getNext()).ifPresent(n -> n.withPrevious(this));
    }

    public void withPrevious(NLayer nLayer) {

    }

    public abstract int getWidth();

    public abstract int getHeight();

    public abstract int getDepth();
}
