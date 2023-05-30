package ru.job4j.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        
        for (String value : deps) {
            StringJoiner start = new StringJoiner("/");
            for (String el : value.split("/")) {
                start.add(el);
                tmp.add(start.toString());
            }
        }
        return tmp.stream().toList();
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }

}
