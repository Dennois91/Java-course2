package assignment_3d;

import java.util.List;

public class Teacher extends Person {

    protected List<Course> teaches;

    public Teacher(String name, int idNumber) {
        super(name, idNumber);
    }

    public String getName() {
        return name;
    }

    public void addTeacherToCourse(Course course){
        teaches.add(course);
    }
    public void removeTeacher(Course course){
        teaches.remove(course);
    }

}
