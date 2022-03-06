package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String language;

    public Programmer(String name, String surname, String education, String birthday, boolean isRemote, String language) {
        super(name, surname, education, birthday, isRemote);
        this.language = language;
    }

    public static void main(String[] args) {
        Programmer programmer = new Programmer("Dmitry", "Chernov", "Institute",
                "12.01.1988", false, "Java");
        programmer.isRemote();
    }
}
