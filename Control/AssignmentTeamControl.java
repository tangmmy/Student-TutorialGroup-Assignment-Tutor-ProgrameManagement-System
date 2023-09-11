package Control;

//@author YeohYaoWen

import ADT.SortedArrayList;  // Importing the SortedArrayList collection ADT
import Boundary.AssignmentTeamUI;
import Entity.AssignmentTeam;
import Entity.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AssignmentTeamControl {
    private SortedArrayList<AssignmentTeam> assignmentTeams;  // Declaration of a SortedArrayList of AssignmentTeam

    private static final String STUDENTS_FILE_PATH = "./src/Database/student.txt";  
    // FILE PATH HERE!!!!!

    public AssignmentTeamControl() {
        this.assignmentTeams = new SortedArrayList<>();  // Creation of a new SortedArrayList
    }

    public void createAssignmentTeam(String assignmentId, String teamName) {
        AssignmentTeam newTeam = new AssignmentTeam(assignmentId, teamName);  // Creating a new AssignmentTeam object
        assignmentTeams.add(newTeam);  // Invoking the add method of the assignmentTeams collection ADT
    }

    public boolean removeAssignmentTeam(String assignmentId) {
        AssignmentTeam teamToRemove = findAssignmentTeam(assignmentId);  // Invoking the findAssignmentTeam method
        if (teamToRemove != null) {
            assignmentTeams.remove(teamToRemove);  
        // Invoking the remove method of the assignmentTeams collection ADT
            return true;
        }
        return false;
    }

    public boolean amendAssignmentTeamDetails(String assignmentId, String newTeamName) {
        AssignmentTeam teamToAmend = findAssignmentTeam(assignmentId);  // Invoking the findAssignmentTeam method
        if (teamToAmend != null) {
            teamToAmend.setTeamName(newTeamName);  
            // Invoking the setTeamName method of the AssignmentTeam object
            return true;
        }
        return false;
    }

    public void listAssignmentTeams() {
        for (AssignmentTeam team : assignmentTeams) {  
            // Iterating through the assignmentTeams collection ADT
            System.out.println(team);
        }
    }

    public AssignmentTeam findAssignmentTeam(String assignmentId) {
        for (AssignmentTeam team : assignmentTeams) {  
            // Iterating through the assignmentTeams collection ADT
            if (team.getAssignmentId().equals(assignmentId)) {
                return team;
            }
        }
        return null;
    }

    public boolean addStudentToTeam(String assignmentId, String studentId) {
        AssignmentTeam team = findAssignmentTeam(assignmentId);  // Invoking the findAssignmentTeam method
        Student student = findStudentInFile(studentId, STUDENTS_FILE_PATH);       
        // Invoking the findStudentInFile method

        if (team != null && student != null) {
             // Invoking the contains method of the students collection ADT
            if (!team.getStudents().contains(student)) {  
                team.addStudent(student);  // Invoking the addStudent method of the team
                return true; // Student added
            }
            return false; // Student already exists in the team
        } else {
            return false; // Assignment Team not found or Student not found
        }
    }
    
    //Loop that iterates through team.getStudents() which is a collection ADT object.
    public boolean removeStudentsFromTeam(String assignmentId, String[] studentIds) {
        AssignmentTeam team = findAssignmentTeam(assignmentId);  // Invoking the findAssignmentTeam method
        if (team != null) {
            boolean removed = false;
            for (int i = 0; i < studentIds.length; i++) {
                // Checking if the student ID exists in the team
                if (team.hasStudent(studentIds[i])) {  // Invoking the hasStudent method of the team
                    team.removeStudent(studentIds[i]);  // Invoking the removeStudent method of the team
                    removed = true;
                }
            }
            return removed;
        }
        return false;
    }

    public void listStudentsInTeam(String assignmentId) {
        AssignmentTeam team = findAssignmentTeam(assignmentId);  // Invoking the findAssignmentTeam method
        if (team != null) {
            System.out.println("Students in team " + team.getTeamName() + ":");
            for (Student student : team.getStudents()) {  // Iterating through the students collection ADT
                System.out.println(student);  // It will use the `toString` method from Student class
            }
        } else {
            System.out.println("Assignment team not found.");
        }
    }

    public void reportTeamsWithAllStudents() {
        System.out.println("Teams and their students:");

        for (AssignmentTeam team : assignmentTeams) {  // Iterating through the assignmentTeams collection ADT
            System.out.println("Assignment ID: " + team.getAssignmentId());  // Printing the assignment ID
            System.out.println("Team: " + team.getTeamName());

            if (team.getStudents().size() == 0) {  // Invoking the size method of the students collection ADT
                System.out.println("\tNo students in this team.");
            } else {
                for (Student student : team.getStudents()) {  // Iterating through the students collection ADT
                    System.out.println("\t" + student);  
                    // Assumes `Student` class has an appropriate `toString` method.
                }
            }
        }
    }

    public void listStudentsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(STUDENTS_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
        }
    }

    private Student findStudentInFile(String studentId, String filePath) {

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {

                // Adjusted to match the "name,id,tutorialgroup" format
                String[] parts = line.split(",");
                if (parts.length == 3 && parts[1].trim().equals(studentId)) { 
                // Use parts[1] for studentId and parts[0] for studentName
                    return new Student(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
        }
        return null;
    }
    
    public static void main(String[] args) {
        AssignmentTeamUI boundary = new AssignmentTeamUI();
        boundary.displayMenu();
    }
}
