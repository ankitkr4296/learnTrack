package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Course;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CourseRepository implements Repository<Course> {
    private final List<Course> courses = new ArrayList<>();

    @Override
    public void save(Course course) {
        courses.add(course);
    }

    @Override
    public Course findById(int id) {
        for (Course c : courses) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Course> findAll() {
        return Collections.unmodifiableList(courses);
    }
}
