package Entity;

//@author YeohYaoWen

import ADT.DynamicArray;

public class AssignmentTeam implements Comparable<AssignmentTeam> {
    private String assignmentId;
    private String teamName;
    private DynamicArray<Student> students;

    // Constructor to initialize an AssignmentTeam with an assignmentId and teamName
    public AssignmentTeam(String assignmentId, String teamName) {
        this.assignmentId = assignmentId;
        this.teamName = teamName;
        this.students = new DynamicArray<>();
    }

    // Getter for assignmentId
    public String getAssignmentId() {
        return assignmentId;
    }

    // Getter for teamName
    public String getTeamName() {
        return teamName;
    }

    // Setter for teamName
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    // Add a student to the team
    public void addStudent(Student student) {
        students.add(student);
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
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    // List all students in the team
    public void listStudents() {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println(student);
        }
    }

    // Getter for the list of students in the team
    public DynamicArray<Student> getStudents() {
        return students;
    }

    // Override toString method to provide a string representation of the AssignmentTeam
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
