package ru.job4j.inheritance;

public class Engineer extends Profession {

    private boolean isRemote;

    public Engineer(String name, String surname, String education, String birthday, boolean isRemote) {
        super(name, surname, education, birthday);
        this.isRemote = isRemote;
    }

    public boolean isRemote() {
        return isRemote;
    }
}
