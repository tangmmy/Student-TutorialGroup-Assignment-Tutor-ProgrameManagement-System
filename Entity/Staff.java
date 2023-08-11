/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author tangm
 */
import Database.Database;
public class Staff {
    private String userId;
    private String password;

    public String getPassword(String userId) {
        Database database = new Database();
       
        password = database.getStaffPwd(userId);

        return password;
    }
}
