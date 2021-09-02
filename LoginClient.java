/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package login;

/**
 *
 * @author Acer
 * 
 * * Shahrose Khaliq
 * 13L-4322
 * AP - 8A
 * 
 * This program is the client side implementation of Login Page of Hypothetical Web site. It contains the GUI screens and front end validations.
 * 
 */

//import libraries for making GUI, implementing action listeners and sockets
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.net.*;
import java.io.*;

//class for implmeneting client side of Login Page of hypothetical website
public class LoginClient extends JFrame implements ActionListener
{
    //declaring frames for each screen.
    JFrame frameMenu, frameLogin, frameUsername, framePassword, frameRegister;
    
    //declaring buttons for each screen
    JButton addBtn1, addBtn2, changeUsernameBtn1, changeUsernameBtn2, changePasswordBtn1, changePasswordBtn2, loginBtn1, loginBtn2, cancelBtn1, cancelBtn2, cancelBtn3, cancelBtn4, clearBtn1, clearBtn2, clearBtn3, clearBtn4;
    
    //declaring labels for each screen
    JLabel usernameLbl, passwordLbl, newUsernameLbl, newPasswordLbl, welcomeLbl;
    
    //declaring text fields for each screen
    JTextField usernameFld1,usernameFld4,usernameFld3,usernameFld2, usernameFld5, passwordFld1,passwordFld2,passwordFld3,passwordFld4, passwordFld5;
    
    //declaring variables for getting user input
    String username, password, newUsername, newPassword;
    
    //initializing color variable for background of GUI screens
    public static final Color lightBlue = new Color(51,153,255);
    
    //declaring container object
    Container con;
    
    //method for making Menu GUI screen
    public void initMenu()
    {
        //initialize the frame for Menu GUI screen
        frameMenu = new JFrame("Login");
        
        //setting the frame in container
        con = frameMenu.getContentPane();
        
        //setting background color of container
        con.setBackground(lightBlue);
        
        //initializing buttons for Menu GUI screen
        addBtn1 = new JButton("Register");
        changeUsernameBtn1 = new JButton("Change Username");
        changePasswordBtn1 = new JButton("Change Password");
        loginBtn1 = new JButton("Login");
        
        //initializing label for Menu GUI screen
        welcomeLbl = new JLabel("Welcome to MyWebsite");
        
        //setting the font
        welcomeLbl.setFont(new Font("Courier New", Font.ITALIC + Font.BOLD, 25));
       
        //setting the layout to null
        con.setLayout(null);
        
        //setting title of Menu GUI screen
        frameMenu.setTitle("Login Form");
        
        //setting the size and location of all buttons in Menu GUI screen
        welcomeLbl.setBounds(75, 25, 300, 100);
        addBtn1.setBounds(125, 125, 100, 30);
        loginBtn1.setBounds(250, 125, 100, 30);
        changeUsernameBtn1.setBounds(45, 175, 200, 30);
        changePasswordBtn1.setBounds(250, 175, 200, 30);
        
        //adding buttons in container
        con.add(welcomeLbl);
        con.add(addBtn1);
        con.add(loginBtn1);
        con.add(changeUsernameBtn1);
        con.add(changePasswordBtn1);
        
        //registering action listeners of Menu GUI screen
        addBtn1.addActionListener(this);
        loginBtn1.addActionListener(this);
        changeUsernameBtn1.addActionListener(this);
        changePasswordBtn1.addActionListener(this);
        
        //Setting the height and width of the frame as 500 by 500.
        frameMenu.setSize(500,500);
        
        //Setting the close button to exit the frame by pressing cross button.
        frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Setting the resizeable property of frame to false.
        frameMenu.setResizable(false);
        
        //Setting the visible property of frame to true.
        frameMenu.setVisible(true);
    }
    
    //method for making Login GUI screen
    public void loginScreen()
    {
        //closing Menu GUI screen
        frameMenu.setVisible(false);
        
        //initializing Login frame
        frameLogin = new JFrame("Login Page");
        
        //setting the frame of Login in container
        con = frameLogin.getContentPane();
        
        //setting the background color of Login GUI screen
        con.setBackground(lightBlue);
        
        //initializing all buttons of Login GUI screen
        loginBtn2 = new JButton("Login");
        cancelBtn1 = new JButton("Cancel");
        clearBtn1 = new JButton("Clear");
        
        //initializing labels of Login GUI screen
        usernameLbl = new JLabel("Username");
        passwordLbl = new JLabel("Password");
        
        //initializing text fields of Login GUI screen
        usernameFld1 = new JTextField(50);
        passwordFld1 = new JTextField(50);
        
        //setting font of labels in Login GUI screen
        usernameLbl.setFont(new Font("Verdana", Font.PLAIN+Font.BOLD, 15));
        passwordLbl.setFont(new Font("Verdana", Font.PLAIN+Font.BOLD, 15));

        //setting layout to null
        con.setLayout(null);
        
        //setting the size and location of labels, fields and buttons
        usernameLbl.setBounds(150, 100, 100, 30);
        usernameFld1.setBounds(150, 125, 250, 30);
        passwordLbl.setBounds(150, 160, 100, 30);
        passwordFld1.setBounds(150, 185, 250, 30);
        loginBtn2.setBounds(150, 240, 100, 30);
        cancelBtn1.setBounds(300, 240, 100, 30);
        clearBtn1.setBounds(225, 280, 100, 30);
        
        //adding labels, fields and buttons in container
        con.add(usernameLbl);
        con.add(usernameFld1);
        con.add(passwordLbl);
        con.add(passwordFld1);
        con.add(loginBtn2);
        con.add(cancelBtn1);
        con.add(clearBtn1);
        
        //registering action listeners to buttons
        loginBtn2.addActionListener(this);
        cancelBtn1.addActionListener(this);
        clearBtn1.addActionListener(this);
        
         //Setting the height and width of the frame as 500 by 500.
        frameLogin.setSize(500,500);
        
        //Setting the close button to exit the frame by pressing cross button.
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Setting the resizeable property of frame to false.
        frameLogin.setResizable(false);
        
        //Setting the visible property of frame to true.
        frameLogin.setVisible(true);   
    }
    
    //method for making Registeration GUI screen
    public void registerScreen()
    {
        //close Menu GUI Screen
        frameMenu.setVisible(false);
        
        //initializing Register frame
        frameRegister = new JFrame("Registration Page");
        
        //setting the register frame in container
        con = frameRegister.getContentPane();
        
        //setting the background color of Register GUI screen
        con.setBackground(lightBlue);
        
        //initializing buttons of Register GUI screen
        addBtn2 = new JButton("Register");
        cancelBtn4 = new JButton("Cancel");
        clearBtn4 = new JButton("Clear");
        
        //initializing labels of Register GUI screen
        usernameLbl = new JLabel("Username");
        passwordLbl = new JLabel("Password");
        
        //initialize text fields of Register GUI screen
        usernameFld5 = new JTextField(50);
        passwordFld5 = new JTextField(50);
        
        //setting font of labels of Register GUI screen
        usernameLbl.setFont(new Font("Verdana", Font.PLAIN+Font.BOLD, 15));
        passwordLbl.setFont(new Font("Verdana", Font.PLAIN+Font.BOLD, 15));

        //setting the layout to null
        con.setLayout(null);
        
        //setting the size and locations of labels, buttons and text fields of Register GUI Screen
        usernameLbl.setBounds(150, 100, 100, 30);
        usernameFld5.setBounds(150, 125, 250, 30);
        passwordLbl.setBounds(150, 160, 100, 30);
        passwordFld5.setBounds(150, 185, 250, 30);
        addBtn2.setBounds(150, 240, 100, 30);
        cancelBtn4.setBounds(300, 240, 100, 30);
        clearBtn4.setBounds(225, 280, 100, 30);
        
        //adding labels, text fields, and buttons in container
        con.add(usernameLbl);
        con.add(usernameFld5);
        con.add(passwordLbl);
        con.add(passwordFld5);
        con.add(addBtn2);
        con.add(cancelBtn4);
        con.add(clearBtn4);
        
        //registering action listeners to buttons
        addBtn2.addActionListener(this);
        cancelBtn4.addActionListener(this);
        clearBtn4.addActionListener(this);
        
         //Setting the height and width of the frame as 500 by 500.
        frameRegister.setSize(500,500);
        
        //Setting the close button to exit the frame by pressing cross button.
        frameRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Setting the resizeable property of frame to false.
        frameRegister.setResizable(false);
        
        //Setting the visible property of frame to true.
        frameRegister.setVisible(true);
    }
    
    //method for making Change Username GUI screen
    public void usernameScreen()
    {
        //close Menu GUI screen
        frameMenu.setVisible(false);
        
        //initialize change username frame
        frameUsername = new JFrame("Change Username Page");
        
        //set the change username frame in container
        con = frameUsername.getContentPane();
        
        //set background color the frame
        con.setBackground(lightBlue);
        
        //initiaize buttons of Change Username GUI screen
        changeUsernameBtn2 = new JButton("Change Username");
        cancelBtn2 = new JButton("Cancel");
        clearBtn2 = new JButton("Clear");
        
        //initialize labels of Change Username GUI screen
        usernameLbl = new JLabel("Old Username");
        passwordLbl = new JLabel("Password");
        newUsernameLbl = new JLabel("New Username");
        
        //initialize text fields of Change Username GUI screen
        usernameFld2 = new JTextField(50);
        passwordFld2 = new JTextField(50);
        usernameFld3 = new JTextField(50);
        
        //setting fonts of labels in Change Username screen
        usernameLbl.setFont(new Font("Verdana", Font.PLAIN+Font.BOLD, 15));
        passwordLbl.setFont(new Font("Verdana", Font.PLAIN+Font.BOLD, 15));
        newUsernameLbl.setFont(new Font("Verdana", Font.PLAIN+Font.BOLD, 15));
        
        //set the layout to null
        con.setLayout(null);
        
        //setting the size and locations of labels, text fields and buttons
        usernameLbl.setBounds(150, 100, 150, 30);
        usernameFld2.setBounds(150, 125, 250, 30);
        passwordLbl.setBounds(150, 160, 100, 30);
        passwordFld2.setBounds(150, 185, 250, 30);
        newUsernameLbl.setBounds(150, 220, 150, 30);
        usernameFld3.setBounds(150, 245, 250, 30);
        changeUsernameBtn2.setBounds(150, 305, 140, 30);
        cancelBtn2.setBounds(300, 305, 100, 30);
        clearBtn2.setBounds(225, 345, 100, 30);
        
        //adding the labels, text fields and buttons in container
        con.add(usernameLbl);
        con.add(usernameFld2);
        con.add(passwordLbl);
        con.add(passwordFld2);
        con.add(newUsernameLbl);
        con.add(usernameFld3);
        con.add(changeUsernameBtn2);
        con.add(cancelBtn2);
        con.add(clearBtn2);
        
        //registering the action listeners to buttons
        changeUsernameBtn2.addActionListener(this);
        cancelBtn2.addActionListener(this);
        clearBtn2.addActionListener(this);
        
         //Setting the height and width of the frame as 500 by 500.
        frameUsername.setSize(500,500);
        
        //Setting the close button to exit the frame by pressing cross button.
        frameUsername.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Setting the resizeable property of frame to false.
        frameUsername.setResizable(false);
        
        //Setting the visible property of frame to true.
        frameUsername.setVisible(true);
    }
    
    //method for making Change Password GUI screen
    public void passwordScreen()
    {
        //close the Menu frame
        frameMenu.setVisible(false);
        
        //initializing the frame
        framePassword = new JFrame("Change Password Page");
        
        //setting the frame in container
        con = framePassword.getContentPane();
        
        //setting the background color of the frame
        con.setBackground(lightBlue);
        
        //initialize the buttons of Change Password GUI screen
        changePasswordBtn2 = new JButton("Change Password");
        cancelBtn3 = new JButton("Cancel");
        clearBtn3 = new JButton("Clear");
        
        //initialize the labels of Change Password GUI screen
        usernameLbl = new JLabel("Username");
        passwordLbl = new JLabel("Old Password");
        newPasswordLbl = new JLabel("New Password");
        
        //initialize the text fields of Change Password GUI screen
        usernameFld4 = new JTextField(50);
        passwordFld3 = new JTextField(50);
        passwordFld4 = new JTextField(50);
        
        //set the fonts labels
        usernameLbl.setFont(new Font("Verdana", Font.PLAIN+Font.BOLD, 15));
        passwordLbl.setFont(new Font("Verdana", Font.PLAIN+Font.BOLD, 15));
        newPasswordLbl.setFont(new Font("Verdana", Font.PLAIN+Font.BOLD, 15));
        
        //set the layout to null
        con.setLayout(null);
        
        //set the size and locations of labels, text fields, and buttons
        usernameLbl.setBounds(150, 100, 150, 30);
        usernameFld4.setBounds(150, 125, 250, 30);
        passwordLbl.setBounds(150, 160, 150, 30);
        passwordFld3.setBounds(150, 185, 250, 30);
        newPasswordLbl.setBounds(150, 220, 150, 30);
        passwordFld4.setBounds(150, 245, 250, 30);
        changePasswordBtn2.setBounds(150, 305, 140, 30);
        cancelBtn3.setBounds(300, 305, 100, 30);
        clearBtn3.setBounds(225, 345, 100, 30);
        
        //adding the labels, text fields and button in container
        con.add(usernameLbl);
        con.add(usernameFld4);
        con.add(passwordLbl);
        con.add(passwordFld3);
        con.add(newPasswordLbl);
        con.add(passwordFld4);
        con.add(changePasswordBtn2);
        con.add(cancelBtn3);
        con.add(clearBtn3);
        
        //registering the action listeners to buttons
        changePasswordBtn2.addActionListener(this);
        cancelBtn3.addActionListener(this);
        clearBtn3.addActionListener(this);
        
         //Setting the height and width of the frame as 500 by 500.
        framePassword.setSize(500,500);
        
        //Setting the close button to exit the frame by pressing cross button.
        framePassword.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Setting the resizeable property of frame to false.
        framePassword.setResizable(false);
        
        //Setting the visible property of frame to true.
        framePassword.setVisible(true);
    }
    
    //method for navigating to Menu GUI screen
    public void cancelPasswordScreen()
    {
        //close Change Password GUI screen
        framePassword.setVisible(false);
        
        //open Menu GUI screen
        frameMenu.setVisible(true);
    }
    
    //method for clearing all the text field in Change Password GUI screen
    public void clearPasswordScreen()
    {
        //set the text fields to empty string
        usernameFld4.setText("");
        passwordFld3.setText("");
        passwordFld4.setText("");
    }
    
    //method for navigating to Manu GUI Screen
    public void cancelUsernameScreen()
    {
        //close Change Username GUI screen
        frameUsername.setVisible(false);
        
        //open Menu GUI screen
        frameMenu.setVisible(true);
    }
    
    //method for clearing the text fields of Change Username GUI screen
    public void clearUsernameScreen()
    {
        //set all the text fields to empty string
        usernameFld2.setText("");
        usernameFld3.setText("");
        passwordFld2.setText("");
    }
    
    //method for clearing the text fields of Registration GUI screen
    public void clearRegisterScreen()
    {
        //set the text fields to empty string
        usernameFld5.setText("");
        passwordFld5.setText("");
    }
    
    //method for navigating to Menu GUI screen
    public void cancelRegisterScreen()
    {
        //close Registration GUI screen
        frameRegister.setVisible(false);
        
        //open the Menu GUI screen
        frameMenu.setVisible(true);
    }
    
    //method for registration of user and communicating its details to server
    public void registerUser()
    {
        //get username from user
        //test: username = "ali"
        username = usernameFld5.getText();
        //echo message
        System.out.println("User entered username: "+username);
        
        //get password from user
        //test: password= "1234"
        password = passwordFld5.getText();
        //echo message
        System.out.println("User entered password: "+password);

        //declaring bool variables for validating details
        boolean allEntered = true;
        boolean userVal = true;
        boolean passVal = true;
        
        //if user entered nothing in username
        if(username.equals(""))
        {
            //set error message in user name field
            usernameFld5.setText("Username not entered");
            
            //set allEntered = false
            allEntered = false;
        }
        
        //if user entered nothing in password
        if(password.equals(""))
        {
            //set error message in password field
            passwordFld5.setText("Password not entered");
            
            //set allEntered to false
            allEntered = false;
        }
        
        //check length of username
        if(username.length()>20)
        {
            //if length greater than 20, then set error message in username field
            usernameFld5.setText("Username Invalid");
            
            //set userVal to false
            userVal = false;
        }
        
        //check length of password
        if(password.length()>0 && (password.length()<4 || password.length()>10))
        {
            //if password is not between 4 and 10 charaters, set error message in password field
            passwordFld5.setText("Password Invalid");
            
            //set passVal to false
            passVal = false;
        }
        
        //check if there is any invalid entry
        if(allEntered == false || userVal == false || passVal == false)
        {
            //if there is any valid entry, show dialog error
            JOptionPane.showMessageDialog(null,"Registration Failed");
            
            //quit operation Registration
            return;
        }
        
        try
        {   
            //open client socket
            Socket s = new Socket("localhost", 2223);
            
            //make writing objects for writing into socket
            OutputStream out = s.getOutputStream();
            PrintWriter pw = new PrintWriter(out, true);
            
            //make reading objects from socket
            InputStream is=s.getInputStream();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader br=new BufferedReader(isr);
            
            //send username and password to server via socket
            pw.println(username);
            pw.println(password);
            
            //send command "Register User" to server via socket
            pw.println("Register User");
            
            //get input from server for confirmation
            String confirmation = br.readLine();
            
            //display the confirmation message in dialog box
            JOptionPane.showMessageDialog(null, confirmation);
            
            //close the read/write objects
            br.close();
            pw.close();
            out.close();
            
            //close the client socket
            s.close();
            
        }
        catch(Exception e) //exception for connecting to server via socket
        {
            System.out.println(e);
        }
    }
        
    public void changePassword()
    {
        //get username from user
        //test: username= "Ali"
        username = usernameFld4.getText();
        //echo message
        System.out.println("User entered username: "+username);
        
        //get password from user
        //test: password="asdf"
        password = passwordFld3.getText();
        //echo message
        System.out.println("User entered password: "+password);
        
        //get new password from user
        //Test: new password = "qwer"
        newPassword = passwordFld4.getText();
        System.out.println("User entered new password: "+newPassword);
        
        //bool variables for validating details
        boolean allEntered = true;
        boolean userVal = true;
        boolean passVal = true;
        boolean newPassVal = true;
        
        //if user entered nothing in user name field
        if(username.equals(""))
        {
            //set error message in username field
            usernameFld4.setText("Username not entered");
            
            //set allEntered to false
            allEntered = false;
        }
        
        //if user entered nothing in the password field
        if(password.equals(""))
        {
            //set error message in password field
            passwordFld3.setText("Password not entered");
            
            //set allEntered to false
            allEntered = false;
        }
        
        //if user entered new password in newPassword field
        if(newPassword.equals(""))
        {
            //set error message in new password field
            passwordFld4.setText("New Password not entered");
            
            //set allEntered to false
            allEntered = false;
        }
        
        //check length of username
        if(username.length()>20)
        {
            //set error message in username field if username length is invalid
            usernameFld4.setText("Username Invalid");
            
            //set userVal to false
            userVal = false;
        }
        
        //check length of password
        if(newPassword.length()>0 && (newPassword.length()<4 || newPassword.length()>10))
        {
            //if password is not between 4 and 10, set error message in password field
            passwordFld4.setText("New Password Invalid");
            
            //set newPasVal to false
            newPassVal = false;
        }
        
        //check length of password
        if(password.length()>0 && (password.length()<4 || password.length()>10))
        {
            //if password is not between 4 and 10, set error message in password field
            passwordFld2.setText("Password Invalid");
            
            //set passVal to false
            passVal = false;
        }
        
        //check if there are any invalid or missing details
        if(allEntered == false || userVal == false || passVal == false || newPassVal == false)
        {
            //if there are, then show error message in dialog box
            JOptionPane.showMessageDialog(null,"Change Password Failed");
            
            //quit change password operation
            return;
        }
        
        try
        {
            //open the client socket in localhot with port 2223
            Socket s = new Socket("localhost", 2223);
            
            //make a writing object for socket
            OutputStream out = s.getOutputStream();
            PrintWriter pw = new PrintWriter(out, true);
            
            //make a reading object for socket
            InputStream is=s.getInputStream();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader br=new BufferedReader(isr);
            
            //send username and password to server via socket
            pw.println(username);
            pw.println(password);
            
            //send command Change Password to socket
            pw.println("Change Password");
            
            //get confirmation if user exists
            String userExists = br.readLine();
            
            //if user exists
            if(userExists.equals("User exists"))
            {
                //send new password to server via socket
                pw.println(newPassword);
                
                //get confirmation if password is changed
                String confirmation = br.readLine();
                
                //display confirmation message in dialog box
                JOptionPane.showMessageDialog(null, confirmation);
            }
            else
            {
                //user doesnt exits and display error message in dialog box
                JOptionPane.showMessageDialog(null, userExists);
            }
            
            //close reading and writing objects
            br.close();
            pw.close();
            out.close();
            
            //close client socket
            s.close();
        }
        catch(Exception e) //exception block for socket
        {
            System.out.println(e);
        }        
    }
    
    //method for changin username of an existing user
    public void changeUsername()
    {
        //get username from user
        //test: username="shayan"
        username = usernameFld2.getText();
        //echo message
        System.out.println("User entered username: "+username);
        
        //get password from user
        //Test: password="asdfg"
        password = passwordFld2.getText();
        //echo message
        System.out.println("User entered password: "+password);
        
        //get new username from user
        //Test: newusername = "Kashif"
        newUsername = usernameFld3.getText();
        //echo message
        System.out.println("User entered new username: "+newUsername);
        
        //initializing bool variables for validating details
        boolean allEntered = true;
        boolean userVal = true;
        boolean passVal = true;
        boolean newUserVal = true;
        
        //if user entered nothing in username field
        if(username.equals(""))
        {
            //set error message in username field
            usernameFld2.setText("Username not entered");
            
            //set allEntered to false
            allEntered = false;
        }
        
        //if user entered nothing in password field
        if(password.equals(""))
        {
            //set error message in password field
            passwordFld2.setText("Password not entered");
            
            //set allEntered to false
            allEntered = false;
        }
        
        //if user entered nothing in newusername field
        if(newUsername.equals(""))
        {
            //set error message in newusername field
            usernameFld3.setText("New Username not entered");
            
            //set allEntered to false
            allEntered = false;
        }
        
        //check length of username
        if(username.length()>20)
        {
            //if length>20, set error message in username field
            usernameFld2.setText("Username Invalid");
            
            //set userVal to false
            userVal = false;
        }
        
        //check length of new username
        if(newUsername.length()>20)
        {
            //if length of newusername > 20, set error message in newusername field
            usernameFld3.setText("Username Invalid");
            
            //set newuserval to false
            newUserVal = false;
        }
        
        //check length of password
        if(password.length()>0 && (password.length()<4 || password.length()>10))
        {
            //if password is not between 4 and 10 characters, set error message in password field
            passwordFld2.setText("Password Invalid");
            
            //set passVal to false
            passVal = false;
        }
        
        //check if any details are invalid or missing
        if(allEntered == false || userVal == false || passVal == false || newUserVal == false)
        {
            //set error message in dialog box
            JOptionPane.showMessageDialog(null,"Change Username Failed");
            
            //quit change username operation
            return;
        }
        
        try
        {
            //open a client socket
            Socket s = new Socket("localhost", 2223);
            
            //make a write object for socket
            OutputStream out = s.getOutputStream();
            PrintWriter pw = new PrintWriter(out, true);
            
            //make a read object for socket
            InputStream is=s.getInputStream();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader br=new BufferedReader(isr);
            
            //send username and password to server via socket
            pw.println(username);
            pw.println(password);
            
            //send commnad "Change Username" to server via socket
            pw.println("Change Username");
            
            //get confirmation of whether user exists in db
            String userExists = br.readLine();
            
            //if user exists in db
            if(userExists.equals("User exists"))
            {
                //send new user name to server via socket
                pw.println(newUsername);
                
                //get confirmation of whether the username is changed
                String confirmation = br.readLine();
                
                //show confirmation message in dialog box
                JOptionPane.showMessageDialog(null, confirmation);
            }
            else
            {
                //user doesnt exist in db, show error message in dialog box
                JOptionPane.showMessageDialog(null, userExists);
            }
            
            //close read and write objects
            br.close();
            pw.close();
            out.close();
            
            //close client socket
            s.close();
        }
        catch(Exception e) //exception for client socket
        {
            System.out.println(e);
        }        
    }
    
    //method for logging the user
    public void loginUser()
    {
        //get the username from user
        //test: username:"shayan"
        username = usernameFld1.getText();
        //echo message
        System.out.println("User entered username: "+username);
        
        //get password from user
        //test: password: "1234"
        password = passwordFld1.getText();
        //echo message
        System.out.println("User entered password: "+password);
        
        //boolean variables for validating user details
        boolean allEntered = true;
        boolean userVal = true;
        boolean passVal = true;
        
        //if user entered nothing in username field
        if(username.equals(""))
        {
            //set error message in username field
            usernameFld1.setText("Username not entered");
            
            //set allEntered to false
            allEntered = false;
        }
        
        //if user entered nothing in password field
        if(password.equals(""))
        {
            //set error message in password field
            passwordFld1.setText("Password not entered");
            
            //set allEntered to false
            allEntered = false;
        }
        
        //check length of username
        if(username.length()>20)
        {
            //if username length>20, set error message in username field
            usernameFld1.setText("Username Invalid");
            
            //set userVal to false
            userVal = false;
        }
        
        //check length of password
        if(password.length()>0 && (password.length()<4 || password.length()>10))
        {
            //if password length is not between 4 and 10, set error message in password field
            passwordFld1.setText("Password Invalid");
            
            //set passVal to false
            passVal = false;
        }
        
        //check if any details are missing or invalid
        if(allEntered == false || userVal == false || passVal == false)
        {
            //set error message in dialog box
            JOptionPane.showMessageDialog(null,"Login Failed");
            
            //quit Login operation
            return;
        }
        
        try
        {
            //open client socket in localhost in port 2223
            Socket s = new Socket("localhost", 2223);
            
            //make a write object for socket
            OutputStream out = s.getOutputStream();
            PrintWriter pw = new PrintWriter(out, true);
            
            //make a read object for socket
            InputStream is=s.getInputStream();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader br=new BufferedReader(isr);
            
            //send username and password to server via socket
            pw.println(username);
            pw.println(password);
            
            //send command "Login" to server
            pw.println("Login");
            
            //get confirmation if user exists in db
            String confirmation = br.readLine();
            
            //show confirmation message in dialog box
            JOptionPane.showMessageDialog(null, confirmation);
            
            //close read and write objects
            br.close();
            pw.close();
            out.close();
            
            //close client socket
            s.close();
        }
        catch(Exception e) //exception for client socket
        {
            System.out.println(e);
        }
    }
    
    //method for naviagting to Menu GUI screen
    public void cancelLoginScreen()
    {
        //close LoginGUI screen
        frameLogin.setVisible(false);
        
        //open Menu GUI screen
        frameMenu.setVisible(true);
    }
    
    //method for clearing text fields of Login GUI screen
    public void clearLoginScreen()
    {
        //set username text field to empty string
        usernameFld1.setText("");
        
        //set password text field to empty string
        passwordFld1.setText("");
    }
    
    //override the actionPerformed function to register buttons with fucntions
    public void actionPerformed(ActionEvent e)
    {
        //if user pressed login button in Menu screen, open Login screen
        if(e.getSource() == loginBtn1)
            loginScreen();
        else if(e.getSource() == loginBtn2) //if user pressed Login button in Login screen, call method loginUser
            loginUser();
        else if(e.getSource() == cancelBtn1) //if user pressed cancel button in Login Screen, open Menu screen and close Login screen
            cancelLoginScreen();
        else if(e.getSource() == clearBtn1) //if user pressed clear button in Login screen, clear all the fields in it
            clearLoginScreen();
        else if(e.getSource() == changeUsernameBtn1) //if user pressed change username button in Menu screen, open Change Username Screen
            usernameScreen();
        else if(e.getSource() == changeUsernameBtn2) //if user pressed change username button in change username screen, call changeUsername method
            changeUsername();
        else if(e.getSource() == cancelBtn2) //if user pressed cancel button in username screen, open Manu screen and close chaneg username screen
            cancelUsernameScreen();
        else if(e.getSource() == clearBtn2) //if user pressed clear button in change username screen, clear all the fields in change username screen
            clearUsernameScreen();
        else if(e.getSource() == changePasswordBtn1) //if user pressed change password button in Menu screen, open change password screen and close menu screen
            passwordScreen();
        else if(e.getSource() == changePasswordBtn2) //if user pressed change password button in change password screen, call method changePassword method
            changePassword();
        else if(e.getSource() == clearBtn3) //if user pressed clear button change password screen, clear all the fields in change password screen
            clearPasswordScreen();
        else if(e.getSource() == cancelBtn3) //if user pressed cancel button in change password screen, open menu creen and close change password screen
            cancelPasswordScreen();
        else if(e.getSource() == addBtn1) //if user pressed register button in menu screen, open register user screen and close menu screen
            registerScreen();
        else if(e.getSource() == addBtn2) //if user pressed register button in register user screen, call method registerUser method
            registerUser();
        else if(e.getSource() == cancelBtn4) //if user pressed cancel button in register user screen, open menu screen and close register user screen
            cancelRegisterScreen();
        else if(e.getSource() == clearBtn4) //if user pressed clear button in register user screen, clear all the fields in register user screen
            clearRegisterScreen();
    }
    
    //constructor for LoginClient1 class
    public LoginClient()
    {
        //initialize username and password
        username = "";
        password = "";
        
        //display Menu GUI screen
        initMenu();
    }
    
    //main method for LoginClient1
    public static void main(String args[])
    {
        //Legend Message
        System.out.println("Welcome to Client Side of Login page of Hypotheticla web site. This program contains the GUI screens for Menu, Login user, Change username and password user");
        
        //making an object of class LoginClient1
        LoginClient a = new LoginClient();
    }
}
