package java_assessment.service;

import java_assessment.model.Course;
import java_assessment.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseServiceTest {

    private CourseService courseService;        //private instance
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        courseService = new CourseService();      //initialize courseService
        studentService = new StudentService();    //initialize studentService
    }

    @Test
    void testEnrollStudent() {
        Student student = studentService.findStudent("stu01");
        Student student2 = studentService.findStudent("stu02");

        courseService.enrollStudent("INTRO-CS-01", student);
        courseService.enrollStudent("INTRO-CS-01", student2);

        List<Student> enrolledStudents = courseService.enrolledStudents.get("INTRO-CS-01");

        assertNotNull(enrolledStudents, "list of current students should not be Null");
        assertEquals(2, enrolledStudents.size(), "enrolled student size should be 1");
    }

    @Test
    void testgetCourse() {
        Course course = courseService.getCourse("INTRO-CS-5");
        assertNotNull(course, "Course should be found");
        assertEquals( "INTRO-CS-5",course.getId(), "CourseId should match");
        assertNotEquals("INTRO-CS-9", course.getId(),"CourseId should not match");
    }
}