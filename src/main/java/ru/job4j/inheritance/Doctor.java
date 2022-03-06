package ru.job4j.inheritance;

public class Doctor extends Profession {
    private char sex;

    public Doctor(String name, String surname, String education, String birthday, char sex) {
        super(name, surname, education, birthday);
        this.sex = sex;
    }

    public Diagnosis heal(Pacient pacient) {
        return null;
    }
}
