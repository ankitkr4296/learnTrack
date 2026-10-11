package com.airtribe.learntrack.entity;

public class Trainer extends Person {
    private String specialty;

    public Trainer(int id, String first, String last, String email, String specialty) {
        super(id, first, last, email);
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String getDisplayName() {
        return "Trainer: " + super.getDisplayName();
    }
}
