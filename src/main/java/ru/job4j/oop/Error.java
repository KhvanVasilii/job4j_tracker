package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    Error() {
    }

    Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Active: " + active);
        System.out.println("Status: " + status);
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        Error error1 = new Error();
        Error error2 = new Error(true, 2, "this is error 2");
        Error error3 = new Error(false, 3, "this is error3");
        error1.printInfo();
        error2.printInfo();
        error3.printInfo();
    }
}
