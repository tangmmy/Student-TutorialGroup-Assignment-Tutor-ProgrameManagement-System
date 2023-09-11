package Entity;
//@author YeohYaoWen
import ADT.DynamicArray;
import Boundary.AssignmentTeamUI;

public class AssignmentTeam implements Comparable<AssignmentTeam> {
    private String assignmentId;
    private String teamName;
    private DynamicArray<Student> students;  // Declaration of DynamicArray of Student objects

  
    public AssignmentTeam(String assignmentId, String teamName) {
        this.assignmentId = assignmentId;
        this.teamName = teamName;
        this.students = new DynamicArray<>();  // Creation of a new DynamicArray
    }

 
    public String getAssignmentId() {
        return assignmentId;
    }


    public String getTeamName() {
        return teamName;
    }


    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    // Add a student to the team
    public void addStudent(Student student) {
        students.add(student);  // Invoking the add method of the students collection ADT
    }

    // Check if the team has a student with a given studentId
    public boolean hasStudent(String studentId) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).toString().contains(studentId)) {
                return true;
            }
        }
        return false;
    }

    // Remove a student with a given studentId from the team
    public boolean removeStudent(String studentId) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).toString().contains(studentId)) {
                students.remove(i);  // Invoking the remove method of the students collection ADT
                return true;
            }
        }
        return false;
    }

    // List all students in the team
    public void listStudents() {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);  // Invoking the get method of the students collection ADT
            System.out.println(student);
        }
    }

    // Getter for the list of students in the team
    public DynamicArray<Student> getStudents() {
        return students;
    }

   
    @Override
    public String toString() {
        return "Assignment ID: " + assignmentId + ", Team Name: " + teamName;
    }

    // Implementation of the compareTo method for sorting AssignmentTeams by assignmentId
    @Override
    public int compareTo(AssignmentTeam otherTeam) {
        return this.assignmentId.compareTo(otherTeam.assignmentId);
    }
}
