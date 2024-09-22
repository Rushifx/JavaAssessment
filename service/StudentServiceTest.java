package java_assessment.service;

import java_assessment.model.Course;
import java_assessment.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    private StudentService studentService = new StudentService();

    @BeforeEach
    void setUp() {
        studentService = new StudentService();          //creates an instance of studentService before the test is run
    }

    @Test
    void testfindStudent() {
        Student student = studentService.findStudent("stu01");
        //check whether the student exists though assertion
        assertNotNull(student, "Student should be found");
        assertEquals("Adrian", student.getFirstName(), "First name should be Adrian");
        assertEquals("Tan", student.getLastName(), "Last name should be Tan");
        assertEquals("adriantan@gmail.com", student.getEmail(), "Email should be adriantan@gmail.com");
    }

    @Test
    void testNotFoundStudent(){
        Student student = studentService.findStudent("stu09");

        assertNull(student, "Student doesnt exist!");
    }

    @Test
    void testisSubscribed() {
        assertTrue(studentService.isSubscribed("stu01"));//Test that the student exists

        assertFalse(studentService.isSubscribed("stu07"));//test that the student does NOT exist
    }

    @Test
    void testIsAttendingCourse(){
        Student student = new Student("Tony", "Stark", "starktech@gmail.com", new Date(101,0,17),"stu99");
        Course courseJava = new Course("Introduction to Computer Science", "INTRO-CS-J", 9);
        student.enrollToCourse(courseJava);
        assertTrue(student.isAttending("INTRO-CS-J"), "student is attending course");
        assertFalse(student.isAttending("INTRO-CS-X"),"student should not be in this course");
    }
}