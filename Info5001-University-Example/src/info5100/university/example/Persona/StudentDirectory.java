/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona;

import info5100.university.example.Department.Department;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kal bugrara
 */
public class StudentDirectory {

    Department department;
    ArrayList<StudentProfile> studentlist;
    private Map<String, StudentAccount> listOfStudents;

    public Map<String, StudentAccount> getListOfStudents() {
        return listOfStudents;
    }

    public StudentDirectory(Department d) {

        department = d;
        studentlist = new ArrayList();
        listOfStudents = new HashMap<String, StudentAccount>();
    }

    public StudentDirectory() {

        studentlist = new ArrayList();
        listOfStudents = new HashMap<String, StudentAccount>();
    }

    public StudentProfile newStudentProfile(Person p) {

        StudentProfile sp = new StudentProfile(p);
        studentlist.add(sp);
        return sp;
    }

    public StudentProfile findStudent(String id) {

        for (StudentProfile sp : studentlist) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
        return null; //not found after going through the whole list
    }

    public void addStudentToDirectory(String studentID, String studentName, String email, long phoneNum, String password) {
        StudentAccount studentAccount = new StudentAccount();
        studentAccount.setId(studentID);
        studentAccount.setName(studentName);
        studentAccount.setEmail(email);
        studentAccount.setPhoneNumber(phoneNum);
        studentAccount.setPassword(password);
        listOfStudents.put(studentID, studentAccount);

    }
}
