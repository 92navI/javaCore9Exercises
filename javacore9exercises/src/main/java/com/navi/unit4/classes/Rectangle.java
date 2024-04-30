package com.navi.unit4.classes;

public class Rectangle extends Shape {

    private final double width;

    private final double height;

    public Rectangle(Point topLeft, double width, double height) {
        this.point = topLeft;
        this.width = width;
        this.height = height;
    }

    public Point getCenter() {
        return new Point(point.x + width / 2, point.y - height / 2);
    }

    @Override
    public String toString() {
        return String.format("Rectangle(%s, width=%s, height=%s)",
                point, width, height);
    }

    @Override
    public Rectangle clone() {
        return new Rectangle(point, width, height);
    }
}
