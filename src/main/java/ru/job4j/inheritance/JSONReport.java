package ru.job4j.inheritance;

public class JSONReport extends TextReport {
    public String generate(String name, String body) {
        String curlyEnd = "{";
        String tab = "\t";
        String markName = "\"name\" : ";
        String markBody = "\"body\" : ";
        String mark = "\"";
        String comma = ",";
        String curlyFinish = "}";
        return curlyEnd + System.lineSeparator()
                + tab + markName + mark + name  + mark + comma
                + System.lineSeparator()
                + tab + markBody + mark + body + mark
                + System.lineSeparator() + curlyFinish;
    }
}
