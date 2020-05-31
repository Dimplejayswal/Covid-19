package com.example.android19;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        return person1.getFirstName().compareTo(person2.getFirstName());
    }
}
