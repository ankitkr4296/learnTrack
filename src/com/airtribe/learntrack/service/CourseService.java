package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.repository.Repository;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.util.InputValidator;
import java.util.List;

public class CourseService {
    private final Repository<Course> repository = new CourseRepository();

    public Course addCourse(Course course) {
        if (course == null) {
            throw new InvalidInputException("Course cannot be null.");
        }
        validateAndNormalize(course);
        course.setId(IdGenerator.getNextCourseId());
        repository.save(course);
        return course;
    }

    public List<Course> listCourses() {
        return repository.findAll();
    }

    public Course findCourseById(int id) {
        Course course = repository.findById(id);
        if (course == null) {
            throw new EntityNotFoundException("Course ID " + id + " was not found.");
        }
        return course;
    }

    // Only duration and status can be updated; name and description never change.
    // In both methods the id of the passed course selects the stored record.
    public Course updateCourseDuration(Course updated) {
        if (updated == null) {
            throw new InvalidInputException("Course cannot be null.");
        }
        Course existing = findCourseById(updated.getId());
        existing.setDurationInWeeks(InputValidator.requirePositive(updated.getDurationInWeeks(), "Duration"));
        return existing;
    }

    public Course updateCourseStatus(Course updated) {
        if (updated == null) {
            throw new InvalidInputException("Course cannot be null.");
        }
        Course existing = findCourseById(updated.getId());
        existing.setActive(updated.isActive());
        return existing;
    }

    public void deactivateCourse(int id) {
        findCourseById(id).setActive(false);
    }

    public void activateCourse(int id) {
        findCourseById(id).setActive(true);
    }

    private void validateAndNormalize(Course c) {
        c.setCourseName(InputValidator.requireText(c.getCourseName(), "Course name"));
        c.setDescription(InputValidator.requireText(c.getDescription(), "Description"));
        InputValidator.requirePositive(c.getDurationInWeeks(), "Duration");
    }
}
