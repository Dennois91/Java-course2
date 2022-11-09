package assignment_3d;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;
    private Teacher teacher;

    Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void addTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void RemoveTeacher() {
        this.teacher = null;
    }
}
