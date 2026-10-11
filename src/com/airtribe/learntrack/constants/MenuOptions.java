package com.airtribe.learntrack.constants;

public final class MenuOptions {
    private MenuOptions() {
    }

    // Shared by every menu
    public static final int EXIT_OR_BACK = 0;

    // Main menu
    public static final int MAIN_STUDENTS = 1;
    public static final int MAIN_COURSES = 2;
    public static final int MAIN_ENROLLMENTS = 3;

    // Student menu
    public static final int STUDENT_ADD = 1;
    public static final int STUDENT_VIEW_ALL = 2;
    public static final int STUDENT_SEARCH = 3;
    public static final int STUDENT_UPDATE = 4;
    public static final int STUDENT_UPDATE_BATCH = 1;
    public static final int STUDENT_UPDATE_STATUS = 2;

    // Course menu
    public static final int COURSE_ADD = 1;
    public static final int COURSE_VIEW_ALL = 2;
    public static final int COURSE_UPDATE = 3;
    public static final int COURSE_UPDATE_DURATION = 1;
    public static final int COURSE_UPDATE_STATUS = 2;

    // Enrollment menu
    public static final int ENROLLMENT_ENROLL = 1;
    public static final int ENROLLMENT_VIEW_FOR_STUDENT = 2;
    public static final int ENROLLMENT_COMPLETE = 3;
    public static final int ENROLLMENT_CANCEL = 4;
    public static final int ENROLLMENT_VIEW_ALL = 5;
}
