package com.navi.unit4.classes;

public abstract class Shape {

    protected Point point;

    public void moveBy (double dx, double dy) {
        point = new Point(point.x+dx, point.y+dy);
    }

    public abstract Point getCenter ();
}
