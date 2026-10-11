package com.airtribe.learntrack.entity;

public class Person {
    private int id;
    private String firstName, lastName, email;

    public Person() {
    }

    public Person(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String v) {
        firstName = v;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String v) {
        lastName = v;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String v) {
        email = v;
    }

    public String getDisplayName() {
        return firstName + " " + lastName;
    }
}
