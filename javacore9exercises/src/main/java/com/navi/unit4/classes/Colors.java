package com.navi.unit4.classes;

import java.util.List;

public enum Colors {
    RED(List.of(255, 0, 0)),
    GREEN(List.of(0, 255, 0)),
    BLUE(List.of(0, 0, 255)),
    CYAN(List.of(0, 255, 255)),
    MAGENTA(List.of(255, 0, 355)),
    YELLOW(List.of(255, 255, 0)),
    WHITE(List.of(255, 255, 255)),
    BLACK(List.of(0, 0, 0));

    public List<Integer> rgb;

    Colors(List<Integer> rgb) {
        this.rgb = rgb;
    }

    public int getRed () {
        return rgb.get(0);
    }

    public int getGreen () {
        return rgb.get(1);
    }

    public int getBlue () {
        return rgb.get(2);
    }
}
