package com.example.schedule.Schedule;

public class Lesson {

    public String lessonName = "";
    public String teacherName = "";
    public String teacherEmail = "";

    public Lesson() {

    }

    public Lesson(String lessonName, String teacherName, String teacherEmail) {
        this.lessonName = lessonName;
        this.teacherName = teacherName;
        this.teacherEmail = teacherEmail;
    }

}
