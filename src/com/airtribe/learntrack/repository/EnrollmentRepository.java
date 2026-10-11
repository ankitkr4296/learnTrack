package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.entity.Enrollment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnrollmentRepository implements Repository<Enrollment> {
    private final List<Enrollment> enrollments = new ArrayList<>();

    @Override
    public void save(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    @Override
    public Enrollment findById(int id) {
        for (Enrollment e : enrollments) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    @Override
    public List<Enrollment> findAll() {
        return Collections.unmodifiableList(enrollments);
    }

    public List<Enrollment> findByStudentId(int studentId) {
        List<Enrollment> result = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.getStudentId() == studentId) {
                result.add(e);
            }
        }
        return result;
    }

    public boolean existsActive(int studentId, int courseId) {
        for (Enrollment e : enrollments) {
            if (e.getStudentId() == studentId && e.getCourseId() == courseId
                    && e.getStatus() == EnrollmentStatus.ACTIVE) {
                return true;
            }
        }
        return false;
    }
}
