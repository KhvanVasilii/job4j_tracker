package ru.job4j.inheritance;

import java.util.Date;

public class Surgeon extends Doctor {

    public Surgeon(String name, String surname, String education, Date birthday) {
        super(name, surname, education, birthday);
    }

    public Surgeon() {
    }

    public static void main(String[] args) {
        Surgeon surgeon = new Surgeon();
        Pacient pacient = new Pacient();
        surgeon.heal(pacient);
    }
}
