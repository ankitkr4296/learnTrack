package com.airtribe.learntrack.service;

import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.util.IdGenerator;
import java.util.List;

public class EnrollmentService {
    private final EnrollmentRepository repository = new EnrollmentRepository();
    private final StudentService students;
    private final CourseService courses;

    public EnrollmentService(StudentService students, CourseService courses) {
        this.students = students;
        this.courses = courses;
    }

    public Enrollment enrollStudent(int studentId, int courseId) {
        Student s = students.findStudentById(studentId);
        Course c = courses.findCourseById(courseId);
        if (!s.isActive()) {
            throw new InvalidInputException("Cannot enroll an inactive student.");
        }
        if (!c.isActive()) {
            throw new InvalidInputException("Cannot enroll in an inactive course.");
        }
        if (repository.existsActive(studentId, courseId)) {
            throw new InvalidInputException("Student already has an active enrollment in this course.");
        }
        Enrollment e = new Enrollment(studentId, courseId);
        e.setId(IdGenerator.getNextEnrollmentId());
        repository.save(e);
        return e;
    }

    public List<Enrollment> listEnrollments() {
        return repository.findAll();
    }

    public List<Enrollment> getEnrollmentsForStudent(int studentId) {
        students.findStudentById(studentId);
        return repository.findByStudentId(studentId);
    }

    public Enrollment findEnrollmentById(int id) {
        Enrollment enrollment = repository.findById(id);
        if (enrollment == null) {
            throw new EntityNotFoundException("Enrollment ID " + id + " was not found.");
        }
        return enrollment;
    }

    public void updateStatus(int id, EnrollmentStatus status) {
        Enrollment e = findEnrollmentById(id);
        if (e.getStatus() != EnrollmentStatus.ACTIVE) {
            throw new InvalidInputException("Only ACTIVE enrollments can be completed or cancelled.");
        }
        if (status == null || status == EnrollmentStatus.ACTIVE) {
            throw new InvalidInputException("Choose COMPLETED or CANCELLED.");
        }
        e.setStatus(status);
    }
}
