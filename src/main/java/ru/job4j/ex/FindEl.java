package ru.job4j.ex;

public class FindEl {

    public static void indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < value.length; index++) {
                if (value[index].equals(key)) {
                    rsl = index;
                    break;
                }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Element not found");
        }
    }

    public static void main(String[] args) {
        String[] word = {"Мама", "Папа", "Брат"};
        try {
            indexOf(word, "Брата");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
