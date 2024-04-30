package com.navi.other;

import com.navi.other.classes.CountableArrayList;
import com.navi.other.classes.ModeableIntList;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        /*
          I created a class ModeableIntList, which extends the ArrayList class, and has the methods mode() and modes().

          modes() returns the list of modes, while mode() returns one mode (or the greatest if there are multiple)
         */
        var list = new ModeableIntList(List.of(1, 2, 3, 4, 1, 8, 1, 2));
        System.out.println(list.mode()); // returns 1

        var list1 = new ModeableIntList(List.of(1, 2, 5, 5, 2, 8, 1, 3));
        System.out.println(list1.modes()); // returns [1, 2, 5]
        System.out.println(list1.mode()); // returns 5

        /*
          Bonus: I also made a generic CountableArrayList class, which is the parent class of the first one, and has the
          methods countOccurrencesOf() and ElementOccurrenceMapping().
         */

        var list2 = new CountableArrayList<>(List.of("a", "asd", "asd", "dsa", "a", "s", "dsa", "asd", "d", "a", "asd"));
        System.out.println(list2.countOccurrencesOf("a")); // returns 3
        System.out.println(list2.ElementOccurrenceMapping()); // returns {a=3, asd=4, dsa=2, s=1, d=1}
    }
}
