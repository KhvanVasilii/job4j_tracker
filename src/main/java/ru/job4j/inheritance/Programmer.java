package ru.job4j.inheritance;

import java.util.Date;

public class Programmer extends Engineer {

    public Programmer(String name, String surname, String education, Date birthday, boolean isRemote) {
        super(name, surname, education, birthday, isRemote);
    }

    public Programmer() {
    }

    public static void main(String[] args) {
        Programmer programmer = new Programmer();
        programmer.isRemote();
    }
}
