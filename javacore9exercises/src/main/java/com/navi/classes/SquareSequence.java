package com.navi.classes;

import java.math.BigInteger;

public class SquareSequence implements Sequence<BigInteger> {
    private int i;

    public boolean hasNext() {
        return true;
    }

    public BigInteger next() {
        i++;
        var bigI = BigInteger.valueOf(i);
        return bigI.multiply(bigI);
    }
}
