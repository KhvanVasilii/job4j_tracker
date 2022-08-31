package ru.job4j.inheritance;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yy hh:mm");
        System.out.println(localDateTime.format(dateTimeFormatter));
    }
}
