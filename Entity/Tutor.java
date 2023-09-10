
package Entity;

import Adt.*;
import java.io.Serializable;
import java.util.Random;
import java.util.UUID;

/**
 *
 * @author Li Hao
 */

public class Tutor implements Comparable<Tutor>, Serializable{
    private String tutorID;
    private String tutorType;
    private String tutorName;
    private String qualification;
    private String tutorPhone;
    
    //private static int numTutor = 0;

    public Tutor() {
    }

    public Tutor(String tutorID) {
        this.tutorID = tutorID;
    }
   
    public Tutor(int tutorType, String tutorName, String tutorPhone, String qualification) {
        /*
        numTutor++;
        int id = 1000 + numTutor;       
        this.tutorID = "23TARC" + Integer.toString(id);
        */
             
        this.tutorID = generateRandomTutorID();
        
        if(tutorType == 1){
            this.tutorType = "FullTime Tutor";
        }
        else if(tutorType == 2){
            this.tutorType = "PartTime Tutor";
        }
        
        this.tutorName = tutorName;
        this.qualification = qualification;
        this.tutorPhone = tutorPhone;     
    }

    public String getTutorID() {
        return tutorID;
    }

    public void setTutorID(String tutorID) {
        this.tutorID = tutorID;
    }

    public String getTutorType() {
        return tutorType;
    }

    public void setTutorType(String tutorType) {
        this.tutorType = tutorType;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification= qualification;
    }

    public String getTutorPhone() {
        return tutorPhone;
    }

    public void setTutorPhone(String tutorPhone) {
        this.tutorPhone = tutorPhone;
    }
    
     private String generateRandomTutorID() {      
         /*  
        Random random = new Random();
        int randomNumber = random.nextInt(100); // Generate a random number between 0 and 99
        String formattedNumber = String.format("%02d", randomNumber); // Ensure 2-digit formatting
        return "23TARC00" + formattedNumber;
          */
                 
        int numericPart = (int) (Math.random() * 100); // Generates a random number between 0 and 99
        String formattedNumber = String.format("%02d", numericPart); // Ensure 2-digit formatting

        // Extract the first two characters of a UUID string
        String uuidPart = UUID.randomUUID().toString().substring(0, 1);
        uuidPart = replaceDigitsWithLetters(uuidPart);
     
        // Combine the two parts to form the tutorID
        String uniqueID = "tarc@"  + formattedNumber +  uuidPart ;
        uniqueID = uniqueID.toUpperCase();
        return uniqueID;        
    }
         
     private String replaceDigitsWithLetters(String input) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                // Replace digits (0-9) with corresponding letters (a-j); mapping (0 -> a, 1 -> b, 2 -> c, ..., 9 -> j).
                result.append((char) ('a' + Integer.parseInt(String.valueOf(c))));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
     
        
    @Override
    public int compareTo(Tutor t){
        /*
        if(this.tutorID.compareTo(t.tutorID)>0){
            return 1;
        }
        else if(this.tutorID.equals(t.tutorID)){
            return 0;
        }
        else{
            return -1;
        }
        */
       // Compare tutors based on the last two digits of the tutorID
        String id1 = this.getTutorID().substring(5); // Extract last two digits
        String id2 = t.getTutorID().substring(5);
        return id1.compareTo(id2);
    }
    
    @Override
    public String toString(){
        return "Tutor ID : " + tutorID
                + "\nTutor Type : " + tutorType
                + "\nTutor Name : " + tutorName
                + "\nPhone Number : " + tutorPhone    
                + "\nAcademic Qualification : " + qualification;                       
    }
    
}
