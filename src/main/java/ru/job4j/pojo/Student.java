package ru.job4j.pojo;

import java.util.Date;
public class Student {
    private String lastnameFirstnamePatronymic;
    private String group;
    private Date entrance;

    public String getLastnameFirstnamePatronymic() {
        return lastnameFirstnamePatronymic;
    }

    public void setLastnameFirstnamePatronymic(String lastnameFirstnamePatronymic) {
        this.lastnameFirstnamePatronymic = lastnameFirstnamePatronymic;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Date getEntrance() {
        return entrance;
    }

    public void setEntrance(Date entrance) {
        this.entrance = entrance;
    }
}
