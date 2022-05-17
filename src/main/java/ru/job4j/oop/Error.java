package ru.job4j.oop;

public class Error {

    boolean active;
    int status;
    String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error one = new Error();
        one.printInfo();
        Error two = new Error(true, 7, "None");
        two.printInfo();
        Error three = new Error(true, 1, "Error message");
        three.printInfo();
    }
}
