/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author tangm
 */
import Entity.Staff;
import Boundary.MainUI;

public class UserAuthenticationControl {
    private String userId;
    private String password;

    public UserAuthenticationControl(String userId, String password){
        this.userId = userId;
        this.password = password;
    }

    public boolean authenticate(){

        // boolean authenticated = false;

        // String staffName;
        String staffPassword;
        
        Staff staff = new Staff();
        staffPassword = staff.getPassword(userId);
        // staffName = staff.getName(userId);

        if( password.equals(staffPassword) ){

            MainUI mainUI = new MainUI();
            mainUI.start();
            mainUI.loginSuccess();

            return true;
        }
        
        return false;
    }

}
