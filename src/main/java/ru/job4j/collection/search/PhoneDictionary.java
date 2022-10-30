package ru.job4j.collection.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> nameFind = p -> p.getName().contains(key);
        Predicate<Person> surnameFind = p -> p.getSurname().contains(key);
        Predicate<Person> addressFind = p -> p.getAddress().contains(key);
        Predicate<Person> phoneFind = (p -> p.getSurname().contains(key));
        Predicate<Person> combine = nameFind.or(surnameFind).or(addressFind).or(phoneFind);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
