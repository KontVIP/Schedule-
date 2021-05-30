package com.example.schedule;

import java.util.List;

public class Group {
    public String groupName;
    public List students;
    public String scheduleId = "";
    public String journalId = "";

    public Group() {

    }

    public Group(String groupName, List<String> students) {
        this.groupName = groupName;
        this.students = students;
    }

}
