package com.navi.unit3.classes.interfaces;

import java.util.Random;

public interface IntSequence {

    boolean hasNext ();

    int next ();

    //static fields
    static Random generator = new Random();

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

    class ConstantSequence implements IntSequence {
        private int i;
        public ConstantSequence (int i) {this.i = i;}
        public boolean hasNext () {return true;}
        public int next () {return i;}
    }

    class RandomSequence implements IntSequence {

        private int low;
        private int high;

        public RandomSequence (int low, int high) {this.low = low; this.high = high;}
        public int next () {return low + generator.nextInt(high - low + 1);}
        public boolean hasNext () {return true;}
    }

    //static methods
    public static IntSequence of (int... args) {
        return new FiniteSequence(args);
    }

    public static IntSequence constant (int num) {
        return new ConstantSequence(num);
    }

    

    public static IntSequence randomInts (int low, int high) {
        return new RandomSequence(low, high);
    }
}
