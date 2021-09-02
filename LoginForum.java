/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package loginforum;
import javax.swing.*;
import java.util.*;
/**
 *
 * @author Acer
 */
public class LoginForum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        userList u = new userList();
        String input,username, password;
        int ch;
        
        while(true)
        {
            input = JOptionPane.showInputDialog("Welcome to myWebsite \nEnter 1 to Add a new user \nEnter 2 to Change Password \nEnter 3 to change username \nEnter 4 to login to myWebsite \nEnter 5 to Exit.");
            try{
                ch = Integer.parseInt(input);
                switch(ch)
                {
                    case 1:
                        u.addUser();
                        break;

                    case 2:
                        username = JOptionPane.showInputDialog("Please enter your username: ");
                        password = JOptionPane.showInputDialog("Please enter your old password: ");
                        u.changePassword(username, password);
                        break;

                    case 3:
                        username = JOptionPane.showInputDialog("Please enter your old username: ");
                        password = JOptionPane.showInputDialog("Please enter your password: ");
                        u.changeUsername(username, password);
                        break;

                    case 4:
                        username = JOptionPane.showInputDialog("Please enter your username: ");
                        password = JOptionPane.showInputDialog("Please enter your password: ");
                        u.login(username, password);
                        break;

                    case 5:
                        System.exit(0);
                }
            }catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null,"Login Page was canceled");
                System.exit(0);
            }
        }
    }
    
}
