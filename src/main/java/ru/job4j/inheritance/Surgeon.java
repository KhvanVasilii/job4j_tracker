package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private String specialties;

    public Surgeon(String name, String surname, String education, String birthday, char sex, String specialties) {
        super(name, surname, education, birthday, sex);
        this.specialties = specialties;
    }

    public static void main(String[] args) {
        Surgeon surgeon = new Surgeon("Anton", "Demidov", "University", "13.04.1985",
                'M', "General surgeon");
        Pacient pacient = new Pacient();
        surgeon.heal(pacient);
    }
}
