package java_assessment.model;

import java.util.*;

public class Student implements Evaluation {

    // attributes for the student
    String firstName;                   // first name
    String lastName;                    // last name
    String email;                       // email
    Date birthdate;                      // birthday
    int grade;                          // grade
    String id;                          // id

    // student's enrolled courses
    ArrayList<Course> enrolledCourses = new ArrayList<>();

    Map<String, Course> approvedCourses = new HashMap<>();// approved courses taken by the student

    // Map to store grades for each course
    Map<String, Integer> courseGrades = new HashMap<>();


    public Student(String firstName, String lastName, String email, Date birthdate, String id) {           // default constructor to create an of a student
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthdate = birthdate;
        this.grade = 0;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getGrade(Student student) {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Method to set the grade for a specific course
    public void setCourseGrade(String courseId, int grade) {
        if (isAttending(courseId)) {
            courseGrades.put(courseId, grade);
        } else {
            System.out.println("Student is not enrolled in this course.");
        }
    }

    // Method to get the grade for a specific course
    public Integer getCourseGrade(String courseId) {
        return courseGrades.get(courseId);
    }

    public List<Course> findPassedCourses() {
        List<Course> passedCourses = new ArrayList<>();
        for (Course course : enrolledCourses) {
            Integer grade = courseGrades.get(course.getId());
            if (grade >= 50) { // Assuming 50 is the passing grade
                passedCourses.add(course);
            }
        }
        return passedCourses;
    }

    public boolean enrollToCourse(Course course){

        //TODO if course is not found in HashMap approvedCourses
        //TODO add it to the student's approvedCourses

        if (!approvedCourses.containsKey(course.getId()))
            approvedCourses.put(course.getId(), course);

        return enrolledCourses.add(course);
    }

    public int totalEnrolledCourses(){
        return enrolledCourses.size();
    }

    public boolean unEnrollCourse(Course course){
        return enrolledCourses.remove(course);
    }

    public void printFullName(){
        System.out.println(this.firstName + " " + this.lastName);
    }

    public ArrayList<Course> getEnrolledCourses(){
        return enrolledCourses;
    }
    @Override                                                        // Overriding the default toString() method of a java class
    public String toString(){
        return "Student{'" + "firstName': '" +
                firstName + "', '" + "lastName': '" +
                lastName + "', '" +
                "grade': " + grade + ", '" +
                "email': " + email + ", '" +
                 "birth date': " + birthdate + ", '" +
                "id': '" + id + "'}";
    }

    @Override
    public double getAverage() {
        return 0;
    }

    @Override
    public List<Course> getApprovedCourses() {

        //TODO implement this method
        //TODO return the list of courses that are found in approved courses

        ArrayList<Course> approvedCourses = new ArrayList<>();
        boolean status = approvedCourses.addAll(this.approvedCourses.values());

        if (!status){
            return null;
        }

        return approvedCourses;
    }

    public boolean isApproved (String courseId){
        return approvedCourses.containsKey(courseId);
    }

    public boolean isAttending (String courseId){
        //TODO return true if student is attending the course by courseId
        Course course = approvedCourses.get(courseId);
        return enrolledCourses.contains(course);

    }
}
