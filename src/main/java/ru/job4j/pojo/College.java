package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Борисов Николай Андреевич");
        student.setStudentClass("4ПО");
        student.setDateAdmission("11.04.2021");
        System.out.println(student.getFullName() + " - студент группы " + student.getStudentClass()
                + " дата поступления " + student.getDateAdmission());
    }
}
