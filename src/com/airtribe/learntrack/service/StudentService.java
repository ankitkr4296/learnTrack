package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.util.InputValidator;
import java.util.List;

public class StudentService {
    private final StudentRepository repository = new StudentRepository();

    public Student addStudent(Student student) {
        if (student == null) {
            throw new InvalidInputException("Student cannot be null.");
        }
        validateAndNormalize(student);
        student.setId(IdGenerator.getNextStudentId());
        repository.save(student);
        return student;
    }

    public List<Student> listStudents() {
        return repository.findAll();
    }

    public Student findStudentById(int id) {
        Student student = repository.findById(id);
        if (student == null) {
            throw new EntityNotFoundException("Student ID " + id + " was not found.");
        }
        return student;
    }

    public void deactivateStudent(int id) {
        findStudentById(id).setActive(false);
    }

    public void activateStudent(int id) {
        findStudentById(id).setActive(true);
    }

    public void removeStudent(int id) {
        deactivateStudent(id);
    }

    public Student updateStudent(Student updated) {
        if (updated == null) {
            throw new InvalidInputException("Student cannot be null.");
        }
        validateAndNormalize(updated);
        Student existing = findStudentById(updated.getId());
        existing.setFirstName(updated.getFirstName());
        existing.setLastName(updated.getLastName());
        existing.setEmail(updated.getEmail());
        existing.setBatch(updated.getBatch());
        return existing;
    }

    public Student updateStudentBatch(Student updated) {
        if (updated == null) {
            throw new InvalidInputException("Student cannot be null.");
        }
        Student existing = findStudentById(updated.getId());
        existing.setBatch(InputValidator.requireText(updated.getBatch(), "Batch"));
        return existing;
    }

    public Student updateStudentStatus(Student updated) {
        if (updated == null) {
            throw new InvalidInputException("Student cannot be null.");
        }
        Student existing = findStudentById(updated.getId());
        existing.setActive(updated.isActive());
        return existing;
    }

    private void validateAndNormalize(Student s) {
        s.setFirstName(InputValidator.requireText(s.getFirstName(), "First name"));
        s.setLastName(InputValidator.requireText(s.getLastName(), "Last name"));
        s.setEmail(InputValidator.optionalEmail(s.getEmail()));
        s.setBatch(InputValidator.requireText(s.getBatch(), "Batch"));
    }
}
