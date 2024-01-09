package com.navi.unit4.classes;

import java.util.Objects;

import lombok.Getter;

@Getter
public class LabeledPoint extends Point {
    protected String label;

    public LabeledPoint(String label, double x, double y) {
        super(x, y);
        this.label = label;
    }

    @Override
    public String toString() {
        return String.format("LabeledPoint(x=%s, y=%s, label=%s)",
                getX(), getY(), label);
    }

    @Override
    public boolean equals (Object obj) {

        if (obj == null) return false;

        if (obj == this) return true;

        if (getClass() != obj.getClass()) return false;

        LabeledPoint otherLPoint = (LabeledPoint)obj;
        return x==otherLPoint.x &&
                y==otherLPoint.y &&
                Objects.equals(label, otherLPoint.label);
    }
}
