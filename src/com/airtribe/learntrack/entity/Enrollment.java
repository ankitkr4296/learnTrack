package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.enums.EnrollmentStatus;
import java.time.LocalDate;

public class Enrollment {
    private int id, studentId, courseId;
    private LocalDate enrollmentDate = LocalDate.now();
    private EnrollmentStatus status = EnrollmentStatus.ACTIVE;

    public Enrollment() {
    }

    public Enrollment(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int v) {
        id = v;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int v) {
        studentId = v;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int v) {
        courseId = v;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate v) {
        enrollmentDate = v;
    }

    public EnrollmentStatus getStatus() {
        return status;
    }

    public void setStatus(EnrollmentStatus v) {
        status = v;
    }

    @Override
    public String toString() {
        return "ID=" + id + ", studentId=" + studentId + ", courseId=" + courseId + ", date=" + enrollmentDate
                + ", status=" + status;
    }
}
