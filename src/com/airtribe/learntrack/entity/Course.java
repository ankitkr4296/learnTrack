package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.enums.CourseStatus;

public class Course {
    private int id, durationInWeeks;
    private String courseName, description;
    private boolean active = true;

    public Course() {
    }

    public Course(String name, String description, int weeks) {
        this.courseName = name;
        this.description = description;
        this.durationInWeeks = weeks;
    }

    public int getId() {
        return id;
    }

    public void setId(int v) {
        id = v;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String v) {
        courseName = v;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String v) {
        description = v;
    }

    public int getDurationInWeeks() {
        return durationInWeeks;
    }

    public void setDurationInWeeks(int v) {
        durationInWeeks = v;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean v) {
        active = v;
    }

    public CourseStatus getStatus() {
        return active ? CourseStatus.ACTIVE : CourseStatus.INACTIVE;
    }

    @Override
    public String toString() {
        return "ID=" + id + ", course=" + courseName + ", description=" + description + ", duration=" + durationInWeeks
                + " weeks, status=" + getStatus();
    }
}
