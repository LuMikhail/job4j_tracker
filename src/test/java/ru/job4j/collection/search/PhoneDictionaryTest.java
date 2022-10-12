package ru.job4j.collection.search;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("534");
        assertThat(persons.get(0).getName()).isEqualTo("Petr");
    }

    @Test
    public void whenFindByNothing() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> empty = new ArrayList<>();
        ArrayList<Person> personsNotFound = phones.find("89");
        assertThat(personsNotFound).isEqualTo(empty);
    }
}
