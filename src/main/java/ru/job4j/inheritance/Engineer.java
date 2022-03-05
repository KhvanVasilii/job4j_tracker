package ru.job4j.inheritance;

import java.util.Date;

public class Engineer extends Profession {

    private boolean isRemote;

    public Engineer(String name, String surname, String education, Date birthday, boolean isRemote) {
        super(name, surname, education, birthday);
        this.isRemote = isRemote;
    }

    public Engineer() {
    }

    public boolean isRemote() {
        return isRemote;
    }
}
