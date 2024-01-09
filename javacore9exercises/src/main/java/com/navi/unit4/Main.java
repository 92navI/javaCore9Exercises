package com.navi.unit4;

import com.navi.unit4.classes.Point;
import com.navi.unit4.classes.Rectangle;
import com.navi.unit4.classes.Circle;
import com.navi.unit4.classes.Colors;
import com.navi.unit4.classes.LabeledPoint;
import com.navi.unit4.classes.Line;

public class Main {

    private static Point point = new Point(23, 34.1);
    private static LabeledPoint labeledPoint = new LabeledPoint("POINT", 23, 34.1);
    public static void main(String[] args) {

        // Task 1        
        System.out.println(point);
        System.out.println(labeledPoint);

        // Task 2
        System.out.println(labeledPoint.equals(point));

        // Task 3
        System.out.println(labeledPoint.getX());
        // System.out.println(labeledPoint.x); will not work

        // Task 4 & 5
        var circle = new Circle(point, 5d);
        circle.moveBy(25, -10);
        System.out.println(circle);
        var line = new Line(point, new Point(10, 1));
        System.out.println(line);
        var rect = new Rectangle(point, 20, 10);
        System.out.println(rect);

        // T0D0: Task 6
        

        // Task 7
        System.out.println(Colors.YELLOW);
        System.out.println(Colors.MAGENTA.getRed());
        
    }
}
