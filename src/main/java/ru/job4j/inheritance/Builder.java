package ru.job4j.inheritance;

import java.util.Date;

public class Builder extends Engineer {

    public Builder(String name, String surname, String education, Date birthday, boolean isRemote) {
        super(name, surname, education, birthday, isRemote);
    }

    public Builder() {
    }

    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.isRemote();
    }
}
