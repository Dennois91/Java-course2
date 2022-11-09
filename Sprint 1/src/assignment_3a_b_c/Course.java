package assignment_3a_b_c;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private final String name;
    private Teacher teacher;
    private List<Student> students;


    Course(String name) {
        this.name = name;
        students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudents(Student student) {
        students.add(student);
    }

    public void addTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void RemoveTeacher() {
        this.teacher = null;
    }
}
