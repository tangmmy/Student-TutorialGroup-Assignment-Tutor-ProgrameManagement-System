package Control;

//@author YeohYaoWen

import ADT.SortedArrayList;
import Entity.AssignmentTeam;
import Entity.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AssignmentTeamControl {
    private SortedArrayList<AssignmentTeam> assignmentTeams;
    private static final String STUDENTS_FILE_PATH = "./src/Database/student.txt";
    //File Path Modify Here

    public AssignmentTeamControl() {
        this.assignmentTeams = new SortedArrayList<>();
    }

    public void createAssignmentTeam(String assignmentId, String teamName) {
        AssignmentTeam newTeam = new AssignmentTeam(assignmentId, teamName);
        assignmentTeams.add(newTeam);
    }

    public boolean removeAssignmentTeam(String assignmentId) {
        AssignmentTeam teamToRemove = findAssignmentTeam(assignmentId);
        if (teamToRemove != null) {
            assignmentTeams.remove(teamToRemove);
            return true;
        }
        return false;
    }

    public boolean amendAssignmentTeamDetails(String assignmentId, String newTeamName) {
        AssignmentTeam teamToAmend = findAssignmentTeam(assignmentId);
        if (teamToAmend != null) {
            teamToAmend.setTeamName(newTeamName);
            return true;
        }
        return false;
    }

    public void listAssignmentTeams() {
        for (AssignmentTeam team : assignmentTeams) {
            System.out.println(team);
        }
    }

    public AssignmentTeam findAssignmentTeam(String assignmentId) {
        for (AssignmentTeam team : assignmentTeams) {
            if (team.getAssignmentId().equals(assignmentId)) {
                return team;
            }
        }
        return null;
    }

    public boolean addStudentToTeam(String assignmentId, String studentId) {
        AssignmentTeam team = findAssignmentTeam(assignmentId);
        Student student = findStudentInFile(studentId, STUDENTS_FILE_PATH);

        if (team != null && student != null) {
            if (!team.getStudents().contains(student)) {
                team.addStudent(student);
                return true; // Student added to the team successfully
            }
            return false; // Student already exists in the team
        } else {
            return false; // Assignment Team not found or Student not found
        }
    }

    public boolean removeStudentsFromTeam(String assignmentId, String[] studentIds) {
    AssignmentTeam team = findAssignmentTeam(assignmentId);
    if (team != null) {
        boolean removed = false;
        for (int i = 0; i < studentIds.length; i++) {
            // Checking if the student ID exists in the team
            if (team.hasStudent(studentIds[i])) {
                team.removeStudent(studentIds[i]);
                removed = true;
            }
        }
        return removed;
    }
    return false;
}

    public void listStudentsInTeam(String assignmentId) {
    AssignmentTeam team = findAssignmentTeam(assignmentId);
    if (team != null) {
        System.out.println("Students in team " + team.getTeamName() + ":");
        for (Student student : team.getStudents()) {
            System.out.println(student);  // It will use the `toString` method from Student class
        }
    } else {
        System.out.println("Assignment team not found.");
    }
}

    public void reportTeamsWithAllStudents() {
    System.out.println("Teams and their students:");
    
    for (AssignmentTeam team : assignmentTeams) {
        System.out.println("Assignment ID: " + team.getAssignmentId());  // Printing the assignment ID
        System.out.println("Team: " + team.getTeamName());
        
        if (team.getStudents().size() == 0) {
            System.out.println("\tNo students in this team.");
        } else {
            for (Student student : team.getStudents()) {
                System.out.println("\t" + student);  // Assumes `Student` class has an appropriate `toString` method.
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
            e.printStackTrace();
        }
    }

    private Student findStudentInFile(String studentId, String filePath) {
    //System.out.println("Searching for studentId: " + studentId); // Commented out debugging print

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {

            // Adjusted to match the "name,id,tutorialgroup" format
            String[] parts = line.split(",");
            if (parts.length == 3 && parts[1].trim().equals(studentId)) { // Use parts[1] for studentId and parts[0] for studentName
                return new Student(parts[0].trim(), parts[1].trim());
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}



}
