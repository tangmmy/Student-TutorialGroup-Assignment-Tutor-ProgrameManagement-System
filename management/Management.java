/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package management;

/**
 *
 * @author tangm
 */
import Boundary.*;
public class Management {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.out.println();

        // Login
        // User ID: uid, Password: pwd 
        /*
        LoginUI loginUI=new LoginUI();
        while(loginUI.getSuccess()==false){
            loginUI.start();
            loginUI.login();
        }
        */
        OptionUI optionUI=new OptionUI();
        while(optionUI.getChoice()!=100){
            
            optionUI.start();
            optionUI.makeOption();
        }
        
    }
    
}
