package com.navi.unit4.classes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Circle extends Shape {

    private Double radius;

    public Circle(Point center, Double radius) {
        this.point = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return point;
    }

    @Override
    public String toString() {
        return String.format("Circle(%s, radius=%s)", point, radius);
    }

    @Override
    public Circle clone() {
        return new Circle(point, radius);
    }
}
