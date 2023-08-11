/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Boundary;

/**
 *
 * @author tangm
 */
import java.util.*;
import Control.UserAuthenticationControl;
public class LoginUI extends UI{
    private String userId;
    private String password;
    private boolean success;
  
    public LoginUI(){
        this.success=false;
    }
    public boolean getSuccess(){
        return this.success;
    }
    public void start(){
        System.out.println("\nLogin Page");
        
    }

    public void displayLoginUI(){
        Scanner input = new Scanner(System.in);

        System.out.println("\nPlz input your user ID and password.");

        System.out.print("User ID: ");
        userId = input.nextLine();

        System.out.print("password: ");
        password = input.nextLine();
        
        System.out.println();
    }

    public void login(){

        displayLoginUI();

        UserAuthenticationControl userAuthenticationControl = new UserAuthenticationControl(
            userId, password
        );

        if(!(userAuthenticationControl.authenticate())){
           
            loginFail();
        }
        else this.success=true;

        // userAuthenticationControl.authenticate();

        // if( userAuthenticationControl.authenticate() ){
        //     System.out.println("Login successfully!");
        // }
        // else{
        //     System.out.println("Login fail... Plz try another account or password.");
        // }
        
    }

    public void loginFail(){
        System.out.println("\nLogin fail... Plz try another account or password.");
        this.success=false;
    }
}
