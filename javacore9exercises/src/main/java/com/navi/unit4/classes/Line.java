package com.navi.unit4.classes;

public class Line extends Shape {
    private Point endPoint;

    public Line(Point startPoint, Point endPoint) {
        this.point = startPoint;
        this.endPoint = endPoint;
    }

    public Point getCenter() {
        return point;
    }

    @Override
    public void moveBy (double dx, double dy) {
        point = new Point(point.x+dx, point.y+dy);
        endPoint = new Point(endPoint.x+dx, endPoint.y+dy);
    }

    @Override
    public String toString () {
        return String.format("Line(%s, %s)", point, endPoint);
    }

    public Line clone() {
        return new Line(point, endPoint);
    }
}
