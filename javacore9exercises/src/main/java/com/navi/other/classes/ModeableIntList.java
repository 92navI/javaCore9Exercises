package com.navi.other.classes;

import java.util.*;

public class ModeableIntList extends CountableArrayList<Integer> implements Modeable<Integer> {

    public ModeableIntList (List<Integer> list) {
        super(list);
    }

    @Override
    public Integer mode() {
        return Collections.max(modes());
    }

    @Override
    public List<Integer> modes() {

        HashMap<Integer, Integer> numberMapping = this.ElementOccurrenceMapping();

        var max = Collections.max(numberMapping.values());

        var modes = numberMapping.entrySet().stream().filter(e -> e.getValue().equals(max)).toList();

        return modes.stream().map(Map.Entry::getKey).toList();
    }
}
