package assignment_3a_b_c;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private List<Course> attends;

    public Student(String name, int idNumber) {
        super(name, idNumber);
        attends = new ArrayList<>();
    }

    public void addCourse(Course course) {
        attends.add(course);
    }
}
