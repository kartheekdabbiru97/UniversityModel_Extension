/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example;

import com.github.javafaker.Faker;
import com.github.javafaker.University;
import com.mifmif.common.regex.Main;
import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author kal bugrara
 */
public class Info5001UniversityExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Department department = new Department("Information Systems");

        Course info5100 = department.newCourse("Application Engineering Design", "INFO 5100", 4);
        Course info6250 = department.newCourse("Data Science Method and Tools", "INFO 6250", 4);
        Course info6230 = department.newCourse("Database Management and Design", "INFO 6230", 4);

        CourseSchedule courseschedule = department.newCourseSchedule("Spring 2021");

        CourseOffer courseofferinfo5100 = courseschedule.newCourseOffer("INFO 5100");
        CourseOffer courseofferinfo6250 = courseschedule.newCourseOffer("INFO 6250");
        CourseOffer courseofferinfo6230 = courseschedule.newCourseOffer("INFO 6230");
        
        courseofferinfo5100.generatSeats(50);
        courseofferinfo6250.generatSeats(25);
        courseofferinfo6230.generatSeats(25);
        
        PersonDirectory pd = department.getPersonDirectory();
        StudentDirectory sd = department.getStudentDirectory();
        for(int i = 0; i < 48; i++){
            
            Faker f= new Faker(new Random(i));
            Person person = pd.newPerson(f.idNumber().ssnValid(), f.name().fullName());
            StudentProfile student = sd.newStudentProfile(person);
            CourseLoad courseload = student.newCourseLoad("Spring 2021"); 
            courseload.newSeatAssignment(courseofferinfo5100); //register student in INFO 5100 class
            if(i % 2 == 0){
                courseload.newSeatAssignment(courseofferinfo6250); //register student in INFO 6250 class
            }else{
                courseload.newSeatAssignment(courseofferinfo6230); //register student in INFO 6230 class
            }
           
        }
        
        Faker fff = new Faker(new Random(3));
        StudentProfile sss = sd.findStudent(fff.idNumber().ssnValid());
        Person ppp = sss.personobj();
        System.out.println(ppp.getName() + ppp.getPersonId());
        CourseLoad css = sss.getCurrentCourseLoad();
        CourseLoad y = sss.getCourseLoadBySemester("Spring 2021");
        System.out.println("Course load semester"+y.getSemester());
        System.out.println("************************"+sss.getCourseLoadBySemester("Spring 2021"));
        
        System.out.println(css.getSemester());
        css.getCoursesListofStudent();
        //sss.PrintTranscript();
        
        
        
        int total = department.calculateRevenuesBySemester("Spring 2021");
        System.out.print("Total: " + total);
    }

    
    public static ArrayList<Person> generateStudentData(){
        
        return null;
        
    }
}
