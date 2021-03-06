/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseLoad {
    String semester;

    

    public String getSemester() {
        return semester;
    }
    ArrayList<SeatAssignment> seatassignments;
    
    public void getCoursesListofStudent(){
        
        for(int i=0;i<seatassignments.size();i++){
            System.out.println(seatassignments.get(i));
        } 
    }
    
    public CourseLoad(String s){
        seatassignments = new ArrayList<SeatAssignment>();
        semester = s;
    }
    public SeatAssignment newSeatAssignment(CourseOffer co){
        
        Seat seat = co.getEmptySeat(); // seat linked to courseoffer
        if (seat==null){ 
            System.out.println("No Seats Left");
            return null;
        }
        SeatAssignment sa = seat.newSeatAssignment();
        seatassignments.add(sa);  //add to students course 
        return sa;
    }
    
    public void registerStudent(SeatAssignment sa){
        
        
        sa.assignSeatToStudent(this);
        seatassignments.add(sa);
    }
    
}
