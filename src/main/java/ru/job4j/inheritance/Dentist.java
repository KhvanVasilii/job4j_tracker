package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private String specialties;

    public Dentist(String name, String surname, String education, String birthday, char sex, String specialties) {
        super(name, surname, education, birthday, sex);
        this.specialties = specialties;
    }

    public static void main(String[] args) {
        Dentist dentist = new Dentist("Vladimir", "Kosov", "Univerity", "12.04.1993",
                'W', "Orthodontist");
        Pacient pacient = new Pacient();
        dentist.heal(pacient);
    }
}
