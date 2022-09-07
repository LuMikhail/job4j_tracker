package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setLastnameFirstnamePatronymic("Korzow Nikolay Olegovich");
        student.setGroup("Biology");
        student.setEntrance(new Date());

        System.out.println(student.getLastnameFirstnamePatronymic()
                + " joined the group "
                + student.getGroup()
                + " " + student.getEntrance());
    }
}
