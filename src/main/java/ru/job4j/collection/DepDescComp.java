package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o1Split = o1.split("/");
        String[] o2Split = o2.split("/");
        int length = Math.min(o1Split.length, o2Split.length);
        for (int i = 0; i < length; i++) {
            int different = o1Split[i].compareTo(o2Split[i]);
            if (i == 0 && different != 0) {
                return o2Split[i].compareTo(o1Split[i]);
            }
            if (different != 0) {
                return different;
            }
        }
        return Integer.compare(o1Split.length, o2Split.length);
    }
}
