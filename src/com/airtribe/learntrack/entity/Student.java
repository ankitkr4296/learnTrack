package com.airtribe.learntrack.entity;

public class Student extends Person {
    private String batch;
    private boolean active = true;

    public Student() {
        super();
    }

    public Student(String firstName, String lastName, String batch) {
        this(firstName, lastName, null, batch);
    }

    public Student(String firstName, String lastName, String email, String batch) {
        super(0, firstName, lastName, email);
        this.batch = batch;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String v) {
        batch = v;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean status) {
        active = status;
    }

    @Override
    public String getDisplayName() {
        return "Student: " + super.getDisplayName();
    }

    @Override
    public String toString() {
        return "ID=" + getId() + ", name=" + getDisplayName() + ", email=" + getEmail() + ", batch=" + batch
                + ", active=" + active;
    }
}
