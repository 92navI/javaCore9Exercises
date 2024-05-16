package com.navi.unit10.classes;

public class Matrix {

    public int[][] matrix;

    public Matrix() {
        matrix = new int[2][2];
    }

    public Matrix(int tl, int tr, int bl, int br) {
        matrix = new int[][] { { tl, tr }, { bl, br } };
    }

    public Matrix(int[][] array) {
        matrix = new int[][] {
                {
                        array[0][0],
                        array[0][1]
                },
                {
                        array[1][0],
                        array[1][1]
                } };
    }

    public Matrix multiply(Matrix other) {
        return new Matrix(
                matrix[0][0] * other.matrix[0][0],
                matrix[0][1] * other.matrix[0][1],
                matrix[1][0] * other.matrix[1][0],
                matrix[1][1] * other.matrix[1][1]);
    }
}
