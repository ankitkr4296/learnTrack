package com.airtribe.learntrack;

import com.airtribe.learntrack.enums.EnrollmentStatus;
import static com.airtribe.learntrack.constants.AppConstants.*;
import static com.airtribe.learntrack.constants.MenuOptions.*;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentService studentService = new StudentService();
    private static final CourseService courseService = new CourseService();
    private static final EnrollmentService enrollmentService =
            new EnrollmentService(studentService, courseService);

    public static void main(String[] args) {
        System.out.println(APP_TITLE);
        boolean exit = false;
        while (!exit) {
            showMainMenu();
            int choice = readInt(OPTION_PROMPT);
            switch (choice) {
                case MAIN_STUDENTS:
                    studentManagement();
                    break;
                case MAIN_COURSES:
                    courseManagement();
                    break;
                case MAIN_ENROLLMENTS:
                    enrollmentManagement();
                    break;
                case EXIT_OR_BACK:
                    exit = true;
                    break;
                default:
                    System.out.println(OPTION_NOT_FOUND);
            }
        }
        System.out.println(GOODBYE_MESSAGE);
        scanner.close();
    }

    private static void showMainMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Student Management");
        System.out.println("2. Course Management");
        System.out.println("3. Enrollment Management");
        System.out.println("0. Exit");
    }

    // ---------- Student Management ----------

    private static void studentManagement() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add student");
            System.out.println("2. View all students");
            System.out.println("3. Search student by ID");
            System.out.println("4. Update student (batch or status)");
            System.out.println("0. Back");
            int choice = readInt(OPTION_PROMPT);
            try {
                switch (choice) {
                    case STUDENT_ADD:
                        addStudent();
                        break;
                    case STUDENT_VIEW_ALL:
                        printList(studentService.listStudents());
                        break;
                    case STUDENT_SEARCH:
                        searchStudent();
                        break;
                    case STUDENT_UPDATE:
                        updateStudent();
                        break;
                    case EXIT_OR_BACK:
                        back = true;
                        break;
                    default:
                        System.out.println(OPTION_NOT_FOUND);
                }
            } catch (EntityNotFoundException | InvalidInputException e) {
                System.out.println(OPERATION_FAILED + e.getMessage());
            }
        }
    }

    private static void addStudent() {
        Student student = readStudent();
        System.out.println(studentService.addStudent(student));
    }

    private static void searchStudent() {
        int id = readInt("Student ID: ");
        System.out.println(studentService.findStudentById(id));
    }

    private static void updateStudent() {
        int id = readInt("Student ID to update: ");
        studentService.findStudentById(id);
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Update Student ---");
            System.out.println("1. Update batch");
            System.out.println("2. Update status");
            System.out.println("0. Back");
            int choice = readInt(OPTION_PROMPT);
            try {
                switch (choice) {
                    case STUDENT_UPDATE_BATCH:
                        updateStudentBatch(id);
                        break;
                    case STUDENT_UPDATE_STATUS:
                        updateStudentStatus(id);
                        break;
                    case EXIT_OR_BACK:
                        back = true;
                        break;
                    default:
                        System.out.println(OPTION_NOT_FOUND);
                }
            } catch (EntityNotFoundException | InvalidInputException e) {
                System.out.println(OPERATION_FAILED + e.getMessage());
            }
        }
    }

    private static void updateStudentBatch(int id) {
        Student student = new Student();
        student.setId(id);
        student.setBatch(readText("New batch: "));
        System.out.println(studentService.updateStudentBatch(student));
    }

    private static void updateStudentStatus(int id) {
        Student student = new Student();
        student.setId(id);
        student.setActive(readActiveStatus());
        System.out.println(studentService.updateStudentStatus(student));
    }

    private static boolean readActiveStatus() {
        while (true) {
            int choice = readInt("Status (1 = Active, 2 = Inactive): ");
            if (choice == 1) {
                return true;
            }
            if (choice == 2) {
                return false;
            }
            System.out.println("Enter 1 or 2.");
        }
    }

    private static Student readStudent() {
        Student student = new Student();
        student.setFirstName(readText("First name: "));
        student.setLastName(readText("Last name: "));
        student.setEmail(readText("Email (optional): "));
        student.setBatch(readText("Batch: "));
        return student;
    }

    // ---------- Course Management ----------

    private static void courseManagement() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Course Management ---");
            System.out.println("1. Add course");
            System.out.println("2. View all courses");
            System.out.println("3. Update course (duration or status)");
            System.out.println("0. Back");
            int choice = readInt(OPTION_PROMPT);
            try {
                switch (choice) {
                    case COURSE_ADD:
                        addCourse();
                        break;
                    case COURSE_VIEW_ALL:
                        printList(courseService.listCourses());
                        break;
                    case COURSE_UPDATE:
                        updateCourse();
                        break;
                    case EXIT_OR_BACK:
                        back = true;
                        break;
                    default:
                        System.out.println(OPTION_NOT_FOUND);
                }
            } catch (EntityNotFoundException | InvalidInputException e) {
                System.out.println(OPERATION_FAILED + e.getMessage());
            }
        }
    }

    private static void addCourse() {
        Course course = readCourse();
        System.out.println(courseService.addCourse(course));
    }

    private static void updateCourse() {
        int id = readInt("Course ID to update: ");
        courseService.findCourseById(id);
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Update Course ---");
            System.out.println("1. Update duration");
            System.out.println("2. Update status");
            System.out.println("0. Back");
            int choice = readInt(OPTION_PROMPT);
            try {
                switch (choice) {
                    case COURSE_UPDATE_DURATION:
                        updateCourseDuration(id);
                        break;
                    case COURSE_UPDATE_STATUS:
                        updateCourseStatus(id);
                        break;
                    case EXIT_OR_BACK:
                        back = true;
                        break;
                    default:
                        System.out.println(OPTION_NOT_FOUND);
                }
            } catch (EntityNotFoundException | InvalidInputException e) {
                System.out.println(OPERATION_FAILED + e.getMessage());
            }
        }
    }

    private static void updateCourseDuration(int id) {
        Course course = new Course();
        course.setId(id);
        course.setDurationInWeeks(readInt("New duration in weeks: "));
        System.out.println(courseService.updateCourseDuration(course));
    }

    private static void updateCourseStatus(int id) {
        Course course = new Course();
        course.setId(id);
        course.setActive(readActiveStatus());
        System.out.println(courseService.updateCourseStatus(course));
    }

    private static Course readCourse() {
        Course course = new Course();
        course.setCourseName(readText("Course name: "));
        course.setDescription(readText("Description: "));
        course.setDurationInWeeks(readInt("Duration in weeks: "));
        return course;
    }

    // ---------- Enrollment Management ----------

    private static void enrollmentManagement() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Enrollment Management ---");
            System.out.println("1. Enroll student in a course");
            System.out.println("2. View enrollments for a student");
            System.out.println("3. Mark enrollment as completed");
            System.out.println("4. Mark enrollment as cancelled");
            System.out.println("5. View all enrollments");
            System.out.println("0. Back");
            int choice = readInt(OPTION_PROMPT);
            try {
                switch (choice) {
                    case ENROLLMENT_ENROLL:
                        enrollStudent();
                        break;
                    case ENROLLMENT_VIEW_FOR_STUDENT:
                        viewStudentEnrollments();
                        break;
                    case ENROLLMENT_COMPLETE:
                        changeEnrollmentStatus(EnrollmentStatus.COMPLETED);
                        break;
                    case ENROLLMENT_CANCEL:
                        changeEnrollmentStatus(EnrollmentStatus.CANCELLED);
                        break;
                    case ENROLLMENT_VIEW_ALL:
                        printList(enrollmentService.listEnrollments());
                        break;
                    case EXIT_OR_BACK:
                        back = true;
                        break;
                    default:
                        System.out.println(OPTION_NOT_FOUND);
                }
            } catch (EntityNotFoundException | InvalidInputException e) {
                System.out.println(OPERATION_FAILED + e.getMessage());
            }
        }
    }

    private static void enrollStudent() {
        int studentId = readInt("Student ID: ");
        int courseId = readInt("Course ID: ");
        System.out.println(enrollmentService.enrollStudent(studentId, courseId));
    }

    private static void viewStudentEnrollments() {
        int studentId = readInt("Student ID: ");
        printList(enrollmentService.getEnrollmentsForStudent(studentId));
    }

    private static void changeEnrollmentStatus(EnrollmentStatus status) {
        int id = readInt("Enrollment ID: ");
        enrollmentService.updateStatus(id, status);
        System.out.println("Status changed to " + status + ".");
    }

    // ---------- Input / output helpers ----------

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(INVALID_NUMBER);
            }
        }
    }

    private static String readText(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static void printList(List<?> list) {
        if (list.isEmpty()) {
            System.out.println(NO_RECORDS);
            return;
        }
        for (Object item : list) {
            System.out.println(item);
        }
    }
}
