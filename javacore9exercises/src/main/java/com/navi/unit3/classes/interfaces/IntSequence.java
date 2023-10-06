package com.navi.unit3.classes.interfaces;

public interface IntSequence {

    boolean hasNext ();

    int next ();


    //static methods
    public static IntSequence of (int... args) {
        class FiniteSequence implements IntSequence{
            private int i = 0;
            private int[] values;

            public FiniteSequence (int[] values) {
                this.values = values;
            }
            
            public boolean hasNext () {
                if (i < values.length) {
                    return true;
                } else {
                    return false;
                }
            }
            public int next () {
                i += 1;
                return values[i-1];
            }
        }
        return new FiniteSequence(args);
    }

    public static IntSequence constant (int num) {
        class InfiniteSequence implements IntSequence {
            private int i;
            public InfiniteSequence (int i) {this.i = i;}
            public boolean hasNext () {return true;}
            public int next () {return i;}
        }
        return new InfiniteSequence(num);
    }
}
