package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Alex");
        student.setGroup("4-B");
        student.setDate("12 September");
        String ln = System.lineSeparator();
        System.out.println("Name : " + student.getName() + ln
                + "Group : " + student.getGroup() + ln
                + "Date : " + student.getDate());
    }
}
