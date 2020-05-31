package com.example.android19;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "person_table")

public class Person implements Comparable<Person> {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    int id;
    String firstName;
    String lastName;
    int age;
    int priority;
    boolean travelled;
    int waitingList;

    public Person() {
    }


    public Person(String firstName, String lastName, int age, int priority, boolean travelled, int waitingList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.priority = priority;
        this.travelled = travelled;
        this.waitingList = waitingList;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getWaitingList() {
        return waitingList;
    }

    public void setWaitingList(int waitingList) {
        this.waitingList = waitingList;
    }

    public boolean isTravelled() {
        return travelled;
    }

    public void setTravelled(boolean travelled) {
        this.travelled = travelled;
    }


    @Override
    public int compareTo(Person person) {
        return person.getPriority() - priority;
        //return 0;
    }
}
