package com.airtribe.learntrack.util;
public final class IdGenerator {
    private static int studentCounter=1000, courseCounter=2000, enrollmentCounter=3000;

    private IdGenerator(){

    }
    public static int getNextStudentId(){
        return ++studentCounter;
    }
    public static int getNextCourseId(){
        return ++courseCounter;
    }

    public static int getNextEnrollmentId(){
        return ++enrollmentCounter;
    }
}
