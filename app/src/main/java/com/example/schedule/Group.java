package com.example.schedule;

import java.util.List;

public class Group {
    public String groupName;
    public List students;
    public String scheduleId = "";

    Group() {

    }

    Group(String groupName, List<String> students) {
        this.groupName = groupName;
        this.students = students;
    }

}
