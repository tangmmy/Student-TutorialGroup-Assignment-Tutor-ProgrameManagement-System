package Boundary;

//@author YeohYaoWen

import Control.AssignmentTeamControl;
import Entity.Student;
import Entity.AssignmentTeam;

import java.util.Scanner;

public class AssignmentTeamUI {
    private final AssignmentTeamControl control;
    private final Scanner scanner;

    public AssignmentTeamUI() {
        this.control = new AssignmentTeamControl();
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\nAssignment Team Management System");
            System.out.println("1. Create assignment team");
            System.out.println("2. Remove assignment team");
            System.out.println("3. Amend assignment team details");
            System.out.println("4. List assignment teams");
            System.out.println("5. Add student to team");
            System.out.println("6. Remove students from team");
            System.out.println("7. List students in a team");
            System.out.println("8. Generate Report For all teams and students");
            System.out.println("9. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    createAssignmentTeam();
                    break;
                case 2:
                    removeAssignmentTeam();
                    break;
                case 3:
                    amendAssignmentTeamDetails();
                    break;
                case 4:
                    control.listAssignmentTeams();
                    break;
                case 5:
                    addStudentToTeam();
                    break;
                case 6:
                    removeStudentsFromTeam();
                    break;
                case 7:
                    listStudentsInTeam();
                    break;
                case 8:
                    control.reportTeamsWithAllStudents();
                    break;
                case 9:
                    System.out.println("\nExiting...");
                    return;
                default:
                    System.out.println("\nInvalid choice! Try again.");
            }
        }
    }

    private void createAssignmentTeam() {
        System.out.print("Enter assignment ID: ");
        String assignmentId = scanner.nextLine();

        System.out.print("Enter team name: ");
        String teamName = scanner.nextLine();

        control.createAssignmentTeam(assignmentId, teamName);
        System.out.println("\nTeam created successfully.");
    }

    private void removeAssignmentTeam() {
        System.out.print("Enter assignment ID of the team to remove: ");
        String assignmentId = scanner.nextLine();

        if (control.removeAssignmentTeam(assignmentId)) {
            System.out.println("\nTeam removed successfully.");
        } else {
            System.out.println("\nTeam not found.");
        }
    }

    private void amendAssignmentTeamDetails() {
        System.out.print("Enter assignment ID of the team to amend: ");
        String assignmentId = scanner.nextLine();

        System.out.print("Enter new team name: ");
        String newTeamName = scanner.nextLine();

        if (control.amendAssignmentTeamDetails(assignmentId, newTeamName)) {
            System.out.println("\nTeam details amended successfully.");
        } else {
            System.out.println("\nTeam not found.");
        }
    }

    private void addStudentToTeam() {
        System.out.print("Enter assignment ID: ");
        String assignmentId = scanner.nextLine();

        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();

        if (control.addStudentToTeam(assignmentId, studentId)) {
            System.out.println("\nStudent added successfully.");
        } else {
            System.out.println("\nTeam not found or student already exists.");
        }
    }

    private void removeStudentsFromTeam() {
        System.out.print("Enter assignment ID: ");
        String assignmentId = scanner.nextLine();

        String[] studentIdsToRemove = new String[100]; // Assuming a maximum of 100 student IDs for simplicity.
        int count = 0;

        while (count < studentIdsToRemove.length) {
            System.out.print("Enter student ID to remove (or type 'done' to finish): ");
            String studentId = scanner.nextLine();
            if ("done".equalsIgnoreCase(studentId)) {
                break;
            }
            studentIdsToRemove[count] = studentId;
            count++;
        }

        String[] actualIdsToRemove = new String[count];
        for (int i = 0; i < count; i++) {
            actualIdsToRemove[i] = studentIdsToRemove[i];
        }

        if (control.removeStudentsFromTeam(assignmentId, actualIdsToRemove)) {
            System.out.println("\nStudents removed successfully.");
        } else {
            System.out.println("\nAn error occurred or team not found.");
        }
    }

    private void listStudentsInTeam() {
        System.out.print("Enter assignment ID: ");
        String assignmentId = scanner.nextLine();

        control.listStudentsInTeam(assignmentId);
    }

    public static void main(String[] args) {
        AssignmentTeamUI boundary = new AssignmentTeamUI();
        boundary.displayMenu();
    }
}
