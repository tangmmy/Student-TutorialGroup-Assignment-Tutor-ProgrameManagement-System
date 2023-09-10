
package Control;

import adt.*;
import entity.*;
import java.util.Scanner;
import boundary.*;
import dao.*;
/**
 *
 * @author Li Hao
 */

public class TutorControl {  
     
     lihaoListInterface<Tutor> tutorList = new lihaoLinkedList<>();
     
     //list all tutor
     public static void listAllTutor(lihaoListInterface<Tutor> tutorList){                            
        System.out.println("\n=====================================================================================================");
        System.out.println("                 All Tutor Details    "); 
        System.out.println("======================================================================================================");
        System.out.println("|   ID         | NAME                | Phone             | Qualification  | Tutor Type      |");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
                       
            for (int i = 1; i <= tutorList.getNumberOfEntries(); i++) {
                System.out.printf("|  %-12s| %-20s| %-18s| %-15s| %-16s|\n" , tutorList.getEntry(i).getTutorID(), tutorList.getEntry(i).getTutorName(), tutorList.getEntry(i).getTutorPhone(),
                  tutorList.getEntry(i).getQualification(), tutorList.getEntry(i).getTutorType());
            }                       
     }
            
    // add Tutor (create)
    public static void addTutor(lihaoListInterface<Tutor> tutorList){     
        Scanner scanner = new Scanner(System.in);     
        boolean validate = false;
        char confirmAdd;
        String name;
        String qualification;
        String phone = "";
        int tutorType = 0;
        String tutorTypeString;
        boolean continueAdd = true;
        
        // add tutor type
        do{
            System.out.println("\n===============================================");
            System.out.println("               Tutor Registration Page           ");
            System.out.println("===============================================");           
            try{
                System.out.println("\nPlease select Tutor Type");
                System.out.println("1. FullTime Tutor");
                System.out.println("2. PartTime Tutor");
                tutorType = scanner.nextInt();
                if (tutorType != 1 && tutorType != 2){
                    System.out.println("Please only select 1 or 2 ");
                    scanner.nextLine();
                }            
            }
            catch(Exception ex){
                System.out.println("Invalid Input!!!");
                scanner.nextLine();
            }            
            }while(tutorType != 1 && tutorType != 2 );
        
        //add tutor name
        do{
            System.out.print("\nEnter tutor name: ");
            name = scanner.nextLine();
            for(int i =0; i<name.length(); i++){
                if(!Character.isLetter(name.charAt(i))){
                    validate = false;
                }
                else{
                    validate = true;
                }
            }
            if(validate == false){
                System.out.print("Invalid input, please re-enter tutor name!!!");
            }       
        }while(validate != true);
        
        //add tutor phone
        do{
            do{
                try{
                    System.out.print("\nEnter tutor phone number: ");
                    phone = scanner.next();
                    scanner.nextLine();
                    validate = validatePhone(phone);
                    if(validate == false){
                        System.out.println("Phone number must at least 10 or 11 digits!!!");    
                    }
                    else{
                        continueAdd = false;
                    }           
                }
                catch(Exception ex){
                    System.out.println("Invalid input, please re-enter tutor phone!!!");
                    scanner.nextLine();
                }
            }while(continueAdd);         
        }while(validate != true);
           
         // add academic qualification         
         do{
             System.out.print("\nPlease enter academic qualification(Degree/Master/Phd): ");
             qualification = scanner.next();          
             validate = isValidQualification(qualification);
             if(validate == true){
                 qualification = capitalizeFirstLetter(qualification);
             }
             else{
                 System.out.print("Invalid input, please re-enter qualification!!!");
             }
         }while(validate != true);
                      
        System.out.println("\n------------------------------");
        System.out.println("     Tutor Information");
        System.out.println("----------------------------------");
        if(tutorType == 1){
            tutorTypeString = "FullTime Tutor";
        }
        else{
            tutorTypeString = "PartTime Tutor";
        }
        System.out.println("Tutor Type: " + tutorTypeString);
        System.out.println("Tutor name: " + name);
        System.out.println("Tutor phone number: " + phone);
        System.out.println("Academic Qualification: " + qualification);
        
        do{
            System.out.print("\nAre you sure to add tutor into the system? Y(Yes)/N(No)");
            confirmAdd = scanner.next().charAt(0);
            if(Character.toUpperCase(confirmAdd) == 'Y'){                  
                tutorList.add(new Tutor(tutorType,name,phone, qualification));      
                System.out.println("##New Tutor is added into the system##");
                System.out.println("\n--------------------------------------");
                System.out.println("          Tutor Information      ");
                System.out.println("---------------------------------------");
                System.out.println(tutorList.getEntry(tutorList.getNumberOfEntries()));
                TutorUI.tutorMenu();
                                   
            }
            else{
                System.out.println("Please enter Y or N only");              
            }
        } while(Character.toUpperCase(confirmAdd) != 'Y' && Character.toUpperCase(confirmAdd) != 'N');        
    }
           
    //find specific tutor
    public static void findTutor(lihaoListInterface<Tutor> tutorList){    
         Scanner scanner = new Scanner(System.in);       
         char choice = ' ';
         String findID;     
         Tutor findTutor = new Tutor();
         
         System.out.println("\n=======================================================");
         System.out.println("        Find Tutor Page    ");
         System.out.println("========================================================");    
         do {
            try{
            System.out.print("Enter Tutor ID: ");
            findID = scanner.next();
            findID = findID.toUpperCase();
            if (tutorList.search(new Tutor(findID)) != null) {
                findTutor = tutorList.search(new Tutor(findID));
                System.out.println("\n--------------------------------------------------------");
                System.out.println("                      Tutor Details  ");
                System.out.println("--------------------------------------------------------");
                System.out.println(findTutor.toString());              
            }
            else{
               System.out.println("Tutor ID: "+ findID + " is not in our system"); 
            }
            }
            catch(Exception ex){
                System.out.println("Invalid Input!!!");
                scanner.nextLine();               
            }           
             System.out.println("Do you want to find for another tutor? Y(Yes)/N(No)");
             choice = scanner.next().charAt(0);     
        }while(Character.toUpperCase(choice) == 'Y');           
    }
         
   //amend tutor details
    public static void editTutor( lihaoListInterface<Tutor> tutorList){      
         Scanner scanner = new Scanner(System.in);    
         boolean validate = false;
         boolean contInput = true;
         boolean contAdd = true;
         int option = 0;
         char confirmEdit;
         char choice = ' ';
         String editID;
         int positionTutor = 0;
         
         Tutor editTutor = new Tutor();
         int newTutorType = 0;
         String newTutorTypeString;
         String newName;
         String newPhone = "";
         String newQualification;
         
        System.out.println("\n======================================================");
        System.out.println("      Edit Tutor Details Page   ");
        System.out.println("=========================================================");    
        do{
            try{
            System.out.println("Please enter Tutor ID: ");
            editID = scanner.next();
            editID = editID.toUpperCase();       
            if(tutorList.search(new Tutor(editID)) != null){
                positionTutor = tutorList.getPosition(new Tutor(editID));
                editTutor = tutorList.search(new Tutor(editID));
                System.out.println("\n------------------------------------------------------");
                System.out.println("   Tutor Details To Be Edited   ");
                System.out.println("----------------------------------------------------");        
                do{
                    do{
                        try{
                            System.out.println("\n            Edit Selection          ");
                            System.out.println("-------------------------------------");
                            System.out.println("1. Edit Name");
                            System.out.println("2. Edit Phone Number");
                            System.out.println("3. Edit Tutor Type");
                            System.out.println("4 .Edit Academic Qualification");
                            System.out.println("5. Edit All Details");
                            System.out.println("6. Exit");
                            
                            System.out.println("Enter option: ");
                            option = scanner.nextInt();
                            contInput = false;
                        }
                        catch(Exception ex){
                            System.out.println("Invalid Input!!!");
                            scanner.nextLine();
                        }
                    }while(contInput);
                
                    switch(option){                       
                        case 1:
                            do{
                                System.out.print("\nEnter new name:");
                                newName = scanner.nextLine();
                                for (int i = 0; i < newName.length(); i++) {
                                    if (!Character.isLetter(newName.charAt(i))) {
                                        validate = false;
                                    } 
                                    else {
                                        validate = true;
                                    }
                                }
                                if (validate == false) {
                                    System.out.println("Invalid Tutor Name");
                                }                           
                            }while(validate != true);                         
                            System.out.print("Confirm update to new name? Y(Yes)/N(No):");
                            confirmEdit = scanner.next().charAt(0);
                            if (Character.toUpperCase(confirmEdit) == 'Y') {                              
                                editTutor.setTutorName(newName);
                                System.out.println("New name is updated successfully ");
                                tutorList.edit(editTutor, positionTutor);
                                System.out.println("\n--------------------------------------------------------");
                                System.out.println("                Updated Tutor Details  ");
                                System.out.println("--------------------------------------------------------");
                                System.out.println(tutorList.search(new Tutor(editID)).toString());
                            }
                            else {
                                System.out.println("\n##Tutor Details Remain Unchange##\n");
                                System.out.println("--------------------------------------------------------\n");
                                positionTutor = tutorList.getPosition(new Tutor(editID));
                                editTutor = tutorList.search(new Tutor(editID));
                                System.out.println("\n--------------------------------------------------------");
                                System.out.println("                      Tutor Details  ");
                                System.out.println("--------------------------------------------------------");
                                System.out.println(editTutor.toString());
                            }
                            break;
                                                   
                        case 2:
                            do {
                                do {
                                    try {
                                        System.out.print("\nEnter new phone number:");
                                        newPhone = scanner.next();
                                        scanner.nextLine();
                                        validate = validatePhone(newPhone);
                                        if (validate == false) {
                                            System.out.println("Phone number must at least 10 or 11 digits");
                                        } else {
                                            contAdd = false;
                                        }
                                    } catch (Exception ex) {
                                        System.out.println("Invalid Input!!!");
                                        scanner.nextLine();
                                    }
                                } while (contAdd);                            
                            } while (validate != true);                  
                            System.out.print("Confirm update to new phone number? Y(Yes)/N(No):");
                            confirmEdit = scanner.next().charAt(0);
                            if (Character.toUpperCase(confirmEdit) == 'Y') {
                                editTutor.setTutorPhone(newPhone);
                                System.out.println("New phone is updated successfully ");
                                tutorList.edit(editTutor, positionTutor);
                                System.out.println("\n--------------------------------------------------------");
                                System.out.println("                Updated Tutor Details  ");
                                System.out.println("--------------------------------------------------------");
                                System.out.println(tutorList.search(new Tutor(editID)).toString());
                            } 
                            else {
                                System.out.println("\n##Tutor Details Remain unchange##\n");                               
                            }
                            break;
                                            
                        case 3:
                            do {
                                try {
                                    System.out.print("\nSelect Tutor Type [1- FullTime Tutor ; 2- PartTime Tutor] :");
                                    newTutorType = scanner.nextInt();
                                    if (newTutorType != 1 && newTutorType != 2) {
                                        System.out.println("Please select 1 or 2 only");
                                    }
                                } 
                                catch (Exception ex) {
                                    System.out.println("Invalid Input!!!");
                                    scanner.nextLine();
                                }
                            } while (newTutorType != 1 && newTutorType != 2);
                            
                            if (newTutorType == 1) {
                                newTutorTypeString = "FullTime Tutor";
                            } 
                            else {
                                newTutorTypeString = "Parttime Tutor";
                            }                    
                            System.out.print("Confirm update to new tutor type? Y(Yes)/N(No):");
                            confirmEdit = scanner.next().charAt(0);
                            if (Character.toUpperCase(confirmEdit) == 'Y') {
                                editTutor.setTutorType(newTutorTypeString);
                                System.out.println("New tutor type is updated successfully ");
                                tutorList.edit(editTutor, positionTutor);
                                System.out.println("\n--------------------------------------------------------");
                                System.out.println("                Updated Tutor Details  ");
                                System.out.println("--------------------------------------------------------");
                                System.out.println(tutorList.search(new Tutor(editID)).toString());
                            } 
                            else {
                                System.out.println("\n##Tutor Details Remain Unchange##\n");
                            }
                            break;                                            
                            
                         case 4:                
                            do{
                                System.out.print("\nPlease enter new academic qualification(Degree/Master/Phd): ");
                                newQualification = scanner.next();
             
                                validate = isValidQualification(newQualification);
                                if(validate == true){
                                   newQualification = capitalizeFirstLetter(newQualification);
                                }
                                else{
                                   System.out.print("Invalid input!!!");
                                }
                            }while(validate != true);                        
                            System.out.print("Confirm update to new academic qualification? Y(Yes)/N(No):");
                            confirmEdit = scanner.next().charAt(0);
                            if (Character.toUpperCase(confirmEdit) == 'Y') {
                                editTutor.setQualification(newQualification);
                                System.out.println("New academic qualification is updated successfully ");
                                tutorList.edit(editTutor, positionTutor);
                                System.out.println("\n--------------------------------------------------------");
                                System.out.println("                Updated Tutor Details  ");
                                System.out.println("--------------------------------------------------------");
                                System.out.println(tutorList.search(new Tutor(editID)).toString());
                            } 
                            else {
                                System.out.println("\n##Tutor Details Remain Unchange##\n");
                            }
                            break;                       
                            
                        case 5:
                            //edit new name
                            do {
                                System.out.print("\nEnter new name: ");
                                newName = scanner.nextLine();
                                for (int i = 0; i < newName.length(); i++) {
                                    if (!Character.isLetter(newName.charAt(i))) {
                                        validate = false;
                                    } 
                                    else {
                                        validate = true;
                                    }
                                }
                                if (validate == false) {
                                    System.out.println("Invalid Tutor Name");
                                }
                            } while (validate != true);

                            //edit new phone
                            do {
                                do {
                                    try {
                                        System.out.print("Enter new phone number:");
                                        newPhone = scanner.next();
                                        scanner.nextLine();
                                        validate = validatePhone(newPhone);
                                        if (validate == false) {
                                            System.err.println("Phone number must at least 10 or 11 digits");
                                        }
                                        else {
                                            contAdd = false;
                                        }
                                    } 
                                    catch (Exception ex) {
                                        System.out.println("Invalid Input!!!");
                                        scanner.nextLine();
                                    }
                                } while (contAdd);                                
                            } while (validate != true);

                            //edit new tutor type 
                            do {
                                try {
                                    System.out.print("Select Donor Type [1- FullTime Tutor ; 2- PartTime Tutor] :");
                                    newTutorType = scanner.nextInt();
                                    if (newTutorType != 1 && newTutorType != 2) {
                                        System.out.println("Please select 1 or 2 only");
                                    }
                                } 
                                catch (Exception ex) {
                                    System.out.println("Invalid Input!!!");
                                    scanner.nextLine();
                                }
                            } while (newTutorType != 1 && newTutorType != 2);
                            
                            if (newTutorType == 1) {
                                newTutorTypeString = "FullTime Tutor";
                            } 
                            else {
                                newTutorTypeString = "PartTime Tutor";
                            }

                            //edit new qualification                         
                            do{
                                System.out.print("\nPlease enter new academic qualification(Degree/Master/Phd): ");
                                newQualification = scanner.next();
             
                                validate = isValidQualification(newQualification);
                                if(validate == true){
                                   newQualification = capitalizeFirstLetter(newQualification);
                                }
                                else{
                                   System.out.print("Invalid input!!!");
                                }
                            }while(validate != true);
                                                     
                            //update all tutor details
                            editTutor.setTutorName(newName);
                            editTutor.setTutorPhone(newPhone);
                            editTutor.setTutorType(newTutorTypeString);
                            editTutor.setQualification(newQualification);
                            System.out.print("Confirm update all to new details? Y(Yes)/N(No):");
                            confirmEdit = scanner.next().charAt(0);
                            if (Character.toUpperCase(confirmEdit) == 'Y') {
                                System.out.println("All details are updated successfully ");
                                tutorList.edit(editTutor, positionTutor);
                                System.out.println("\n--------------------------------------------------------");
                                System.out.println("                Updated Tutor Details  ");
                                System.out.println("--------------------------------------------------------");
                                System.out.println(tutorList.search(new Tutor(editID)).toString());
                            } 
                            else {
                                System.out.println("\n##Tutor Details Remain Unchange##\n");
                            }
                            break;
                                                 
                         case 6:
                            break;
                                                   
                        default:
                            System.out.println("Please Select Again!!!");
                            scanner.nextLine();
                            break;                      
                    }                
                } while(option != 6);
            }           
            else{
                System.out.println("Tutor ID: "+ editID + " is not in our system.");
            }
            }
            catch(Exception ex){
                 System.out.println("Invalid Input!!!");
                scanner.nextLine(); 
            }            
            System.out.print("\nDo you want to continue edit other tutor details? Y(Yes)/N(No) :");
            choice = scanner.next().charAt(0);
            System.out.println("--------------------------------------------------------\n");       
        } while (Character.toUpperCase(choice) == 'Y');     
    }
        
    //remove tutor
    public static void removeTutor(lihaoListInterface<Tutor> tutorList){
        Scanner scanner = new Scanner(System.in);
        char choice;

        System.out.println("\n===============================================");
        System.out.println("     Remove Tutor Page  ");
        System.out.println("===================================================");
        do {
            try {
                System.out.print("Please enter Tutor ID: ");
                String removeID = scanner.next().toUpperCase();
                Tutor removedTutor = tutorList.search(new Tutor(removeID));
                if (removedTutor != null) {
                    System.out.println("\n-----------------------------------");
                    System.out.println("   Tutor Information To Be Removed");
                    System.out.println("------------------------------------------");
                    System.out.println(removedTutor.toString());
                    System.out.print("\nAre you sure you want to delete this tutor? (Y/N): ");
                    char confirmDelete = scanner.next().charAt(0);
                    if (Character.toUpperCase(confirmDelete) == 'Y') {
                        int count = tutorList.getPosition(removedTutor);
                        tutorList.remove(count); // Use your custom remove method
                        System.out.println("\nTutor is deleted successfully!");
                    } else {
                        System.out.println("\nTutor was not deleted.");
                    }
                } else {
                    System.out.println("Tutor ID: " + removeID + " is not in our system");
                }
            } catch (Exception ex) {
                System.out.println("Invalid Input!!!");
                scanner.nextLine();
            }
            System.out.print("\nDo you want to remove another tutor? Y(Yes)/N(No): ");
            choice = scanner.next().charAt(0);
        } while (Character.toUpperCase(choice) == 'Y');                 
    }
         
    //method for phone validation
     public static boolean validatePhone(String validatePhone) {
        boolean validPhone = false;
        if (validatePhone.length() < 10 || validatePhone.length() > 11) {
            validPhone = false;
        } else {
            for (int i = 0; i < validatePhone.length(); i++) {
                char ch = validatePhone.charAt(i);
                if (!Character.isDigit(ch)) {
                    validPhone = false;
                } else {
                    validPhone = true;
                }
            }
        }
        return validPhone;
    }
     
     //method for qualification validation
     public static  boolean isValidQualification(String qualification) {
        return qualification.equalsIgnoreCase("Degree")
                || qualification.equalsIgnoreCase("Master")
                || qualification.equalsIgnoreCase("Phd");
    }
     
     //method to capitalize first letter for qualification
     public static String capitalizeFirstLetter(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
    }
              
     //filter tutor
     public static void filterTutor(lihaoListInterface<Tutor> tutorList){     
         Scanner scanner = new Scanner(System.in);       
         int option = 0;     
         do{
              System.out.println("\n================================================================");
              System.out.println("      Filter Tutor Page Based on Tutor Type (FullTime/PartTime)  ");
              System.out.println("===================================================================");
              System.out.println(" 1. Filter Tutor (FullTime Tutor)");
              System.out.println(" 2. Filter Tutor (PartTime Tutor)");
              System.out.println(" 3. Exit");
              System.out.print(" Enter option:");
              option = scanner.nextInt();               
             switch(option){                 
                 case 1:
                     System.out.println("\n=====================================================================================================");
                     System.out.println("                Tutor Details (FullTime Tutor)   "); 
                     System.out.println("======================================================================================================");
                     System.out.println("|   ID         | NAME                | Phone             | Qualification  |");
                     System.out.println("----------------------------------------------------------------------------------------------------");                   
                     for (int i = 1; i <= tutorList.getNumberOfEntries(); i++){
                         if(tutorList.getEntry(i).getTutorType().equalsIgnoreCase("FullTime Tutor")){
                             System.out.printf("|  %-12s| %-20s| %-18s| %-15s|\n" , tutorList.getEntry(i).getTutorID(), tutorList.getEntry(i).getTutorName(), tutorList.getEntry(i).getTutorPhone(),
                         tutorList.getEntry(i).getQualification());
                         }
                     }
                 break;
                 
                 case 2:
                     System.out.println("\n=====================================================================================================");
                     System.out.println("                Tutor Details (PartTime Tutor)   "); 
                     System.out.println("======================================================================================================");
                     System.out.println("|   ID         | NAME                | Phone             | Qualification  |");
                     System.out.println("----------------------------------------------------------------------------------------------------");                 
                     for (int i = 1; i <= tutorList.getNumberOfEntries(); i++){
                         if(tutorList.getEntry(i).getTutorType().equalsIgnoreCase("PartTime Tutor")){
                             System.out.printf("|  %-12s| %-20s| %-18s| %-15s|\n" , tutorList.getEntry(i).getTutorID(), tutorList.getEntry(i).getTutorName(), tutorList.getEntry(i).getTutorPhone(),
                        tutorList.getEntry(i).getQualification());
                         }
                     }
                 break;
                             
                 case 3:
                     break;
                                       
                 default:
                      System.out.println("Please Select Again!!!");
                      scanner.nextLine();
                      break;                                       
             }                      
         }while(option != 3);                
     }
         
     //generate report
     public static void generateReport(lihaoListInterface<Tutor> tutorList){     
         Scanner scanner = new Scanner(System.in);     
         int option = 0;   
         do{
              System.out.println("\n======================================================");
              System.out.println("      Generate Reort   ");
              System.out.println("=========================================================");
              System.out.println(" 1. Tutor Report (Asc - Tutor ID)");
              System.out.println(" 2. Tutor Report (Desc - Tutor ID)");
              System.out.println(" 3. Exit");
              System.out.print(" Enter option:");
              option = scanner.nextInt();         
              switch(option){
                  case 1:
                       lihaoListInterface<Tutor> tutorSortAsc = new lihaoLinkedList<>();   
                      for (int i = 1; i <= tutorList.getNumberOfEntries(); i++) {
                        tutorSortAsc.add(tutorList.getEntry(i));
                    }
                      tutorSortAsc.selectionSortAsc();                
                        System.out.println("\n=====================================================================================================");
                        System.out.println("                 All Tutor Details (Asc - Tutor ID)   "); 
                        System.out.println("======================================================================================================");
                        System.out.println("|   ID         | NAME                | Phone             | Qualification  | Tutor Type      |");
                        System.out.println("-----------------------------------------------------------------------------------------------------------");                  
                             for (int i = 1; i <= tutorSortAsc.getNumberOfEntries(); i++) {
                                System.out.printf("|  %-12s| %-20s| %-18s| %-15s| %-16s|\n" , tutorSortAsc.getEntry(i).getTutorID(), tutorSortAsc.getEntry(i).getTutorName(), tutorSortAsc.getEntry(i).getTutorPhone(),
                                tutorSortAsc.getEntry(i).getQualification(), tutorSortAsc.getEntry(i).getTutorType());
                            }                       
                   break;
           
                  case 2:
                      lihaoListInterface<Tutor> tutorSortDesc = new lihaoLinkedList<>();      
                      for (int i = 1; i <= tutorList.getNumberOfEntries(); i++) {
                        tutorSortDesc.add(tutorList.getEntry(i));
                    }
                      tutorSortDesc.selectionSortDesc();      
                      System.out.println("\n=====================================================================================================");
                      System.out.println("                      All Tutor Details (Desc - Tutor ID)   "); 
                      System.out.println("======================================================================================================");
                      System.out.println("|   ID         | NAME                | Phone             | Qualification  | Tutor Type      |");
                      System.out.println("-----------------------------------------------------------------------------------------------------------");
                      
                        for (int i = 1; i <= tutorSortDesc.getNumberOfEntries(); i++) {
                                System.out.printf("|  %-12s| %-20s| %-18s| %-15s| %-16s|\n" , tutorSortDesc.getEntry(i).getTutorID(), tutorSortDesc.getEntry(i).getTutorName(), tutorSortDesc.getEntry(i).getTutorPhone(),
                            tutorSortDesc.getEntry(i).getQualification(), tutorSortDesc.getEntry(i).getTutorType());
                            }               
                   break;                  
                             
                  case 3:
                      break;
                                           
                  default:
                      System.out.println("Please Select Again!!!");
                      scanner.nextLine();
                      break;                        
              }             
         }while(option != 3);       
     }
         
     //main function
     public static void main(String[] args){ 
         Scanner scanner = new Scanner(System.in);  
         TutorInitializer t = new TutorInitializer();        
         lihaoListInterface<Tutor> tutorList = t.tutorInitializer();     
         int opt = 0;
         do{
              TutorUI.tutorMenu();
              System.out.print(" Enter option: ");
              opt = scanner.nextInt();
              switch(opt){
                  case 1: listAllTutor(tutorList);
                         break;
                         
                  case 2: addTutor(tutorList);
                          break;
                                                  
                  case 3: findTutor(tutorList);
                          break;
                          
                  case 4: editTutor(tutorList);
                          break;
                   
                  case 5: removeTutor(tutorList);
                          break;
                                        
                  case 6: filterTutor(tutorList);
                         break;
                         
                  case 7:generateReport(tutorList);
                      break;
                      
                  case 8:
                      break;
                         
                  default:
                      System.out.println("Please Select Again!!!");
                      scanner.nextLine();
                      break;                             
              }                     
         }while(opt != 8);                 
     }                 
}
