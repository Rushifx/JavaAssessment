package java_assessment.utils;

import java_assessment.model.Student;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PrinterHelper
{

    public static void showMainMenu(){
        System.out.println( "|-------------------------------|" );
        System.out.println( "| Welcome to StudentGen         |" );
        System.out.println( "|--------------------------------------|" );
        System.out.println( "| Select 1 option:                     |" );
        System.out.println( "| . 1 Register Student                 |" );
        System.out.println( "| . 2 Find Student                     |" );
        System.out.println( "| . 3 Grade Student                    |" );
        System.out.println( "| . 4 Enroll Student to Course         |" );
        System.out.println( "| . 5 Show Students Summary            |" );
        System.out.println( "| . 6 Show Courses Summary             |" );
        System.out.println("| . 7 Display Average Grade for Course |");
        System.out.println( "| . 8 Exit                             |" );
        System.out.println( "|--------------------------------------|" );
    }

    public static Student createStudentMenu( Scanner scanner )
        throws ParseException
    {
        System.out.println( "|-------------------------------------|" );
        System.out.println( "| . 1 Register Student                |" );
        System.out.println( "|-------------------------------------|" );
        System.out.println( "| Enter student's first name:         |" );
        String firstName = scanner.next();
        System.out.println( "| Enter student's last name:         |" );
        String lastName = scanner.next();
        System.out.println( "| Enter student ID:                   |" );
        String id = scanner.next();
        System.out.println( "| Enter student email:                |" );
        String email = scanner.next();

        Date birthDate = null;
        DateFormat formatter = new SimpleDateFormat( "mm/dd/yyyy");
        formatter.setLenient(false);
        while (birthDate == null) {
            System.out.println("| Enter student birth date (MM/DD/YYYY) |");
            String dateInput = scanner.next();
            try {
                birthDate = formatter.parse(dateInput);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter the date in numbered MM/DD/YYYY format.");
            }
        }

        System.out.println( "|-------------------------------------|" );
        Student student = new Student( firstName, lastName, email, birthDate, id );
        System.out.println( "Student Successfully Registered! " );
        System.out.println(student);
        return student;
    }

}
