package ru.job4j.inheritance;

import java.util.Date;

public class Builder extends Engineer {
    private int experience;

    public Builder(String name, String surname, String education, String birthday, boolean isRemote, int experience) {
        super(name, surname, education, birthday, isRemote);
        this.experience = experience;
    }

    public static void main(String[] args) {
        Builder builder = new Builder("Andrey", "Volkov", "University", "23.12.1990",
                false, 2);
        builder.isRemote();
    }
}
