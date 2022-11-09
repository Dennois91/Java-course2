package assignment_3d;

import java.util.ArrayList;
import java.util.List;

public class MainProgram {
    public static void main(String[] args) {
        MainProgram mainProgram = new MainProgram();
    }
    public MainProgram() {
        Course math = new Course("Math");
        Course science = new Course("Science");
        Student student1 = new Student("Elin", 1990);
        Student student2 = new Student("Elias", 1980);
        Student student3 = new Student("Felix", 1970);
        Teacher teacher = new Teacher("Master", 666);

        math.addTeacher(teacher);
        science.addTeacher(teacher);

        Attendees stud1 = new Attendees(student1, math);
        Attendees stud2 = new Attendees(student2, math);
        Attendees stud3 = new Attendees(student3, math);
        Attendees stud4 = new Attendees(student1, science);
        Attendees stud5 = new Attendees(student2, science);

        List<Attendees> allStudentsInCourse = new ArrayList<>();
        allStudentsInCourse.add(stud1);
        allStudentsInCourse.add(stud2);
        allStudentsInCourse.add(stud3);
        allStudentsInCourse.add(stud4);
        allStudentsInCourse.add(stud5);

        printCourse(math, allStudentsInCourse);
        System.out.println();
        printCourse(science, allStudentsInCourse);
    }

    public void printCourse(Course course, List<Attendees> attendees) {
        System.out.println("Course: " + course.getName());
        System.out.println("Teacher: " + course.getTeacher().getName());

        for (Attendees a : attendees) {
            if (a.getCourse() == course) {
                System.out.println("Student: " + a.getStudent().getName());
            }
        }
    }
}


