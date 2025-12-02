package com.a2;

import java.util.Comparator;

/**
 * Visitor comparator: sort by age ascending, then by name alphabetically
 */
public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        int ageCompare = Integer.compare(v1.getAge(), v2.getAge());
        if (ageCompare != 0) {
            return ageCompare;
        }
        return v1.getName().compareTo(v2.getName());
    }
}
