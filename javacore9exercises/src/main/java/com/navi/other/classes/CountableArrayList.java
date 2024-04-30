package com.navi.other.classes;

import java.util.*;

public class CountableArrayList<E> extends ArrayList<E> {

    public CountableArrayList (List<E> list) {
        super(list);
    }

    public HashMap<E, Integer> ElementOccurrenceMapping() {

        var elemSet = new HashSet<>(this);
        var elemMapping = new HashMap<E, Integer>();

        elemSet.forEach(elem -> elemMapping.put(elem, countOccurrencesOf(elem)));

        return elemMapping;
    }

    public Integer countOccurrencesOf(E elem) {
        return (int) this.stream().filter(i -> i.equals(elem)).count();
    }
}
