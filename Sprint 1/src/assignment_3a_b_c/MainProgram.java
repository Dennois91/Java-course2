package assignment_3a_b_c;

public class MainProgram {

    public MainProgram() {
        Course course1 = new Course("Math");
        Course course2 = new Course("Science");
        Student student1 = new Student("Elin", 1990);
        Student student2 = new Student("Elias", 1980);
        Student student3 = new Student("Felix", 1970);
        Teacher teacher = new Teacher("Master", 666);

        course1.addStudents(student1);
        course1.addStudents(student2);
        course2.addStudents(student2);
        course2.addStudents(student3);

        course1.addTeacher(teacher);
        course2.addTeacher(teacher);

        student1.addCourse(course1);
        student2.addCourse(course1);
        student2.addCourse(course2);
        student3.addCourse(course2);

        printCourse(course1);
        System.out.println();
        printCourse(course2);

    }
    public void printCourse(Course course) {
        System.out.println("Course: " + course.getName());
        System.out.println("Teacher: " + course.getTeacher().getName());

        for(Student student : course.getStudents()){
            System.out.println("Student: "+ student.getName());
        }
    }
    public static void main(String[] args) {
        MainProgram mainProgram = new MainProgram();
    }
}

