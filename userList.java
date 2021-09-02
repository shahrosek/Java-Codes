/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package loginforum;
import java.util.*;
import javax.swing.*;
import java.io.*;
/**
 *
 * @author Acer
 */
public class userList {
    ArrayList<user> users;
    
    public userList()
    {
        users = new ArrayList<user>();
    }
    
    public boolean readFile(String username, String password)
    {
        FileReader fr = null;
        BufferedReader br = null;
        
        try 
        {
            fr = new FileReader("C:\\Users\\Acer\\Documents\\NetBeansProjects\\LoginForum\\src\\loginforum\\userList.txt");
            br = new BufferedReader(fr);
            
            String input;
            int count = 0;
            if(users.size()>0)
            {
                for(int i=0;i<users.size();i++)
                {
                    users.remove(i);
                }
            }
            while((input = br.readLine()) != null)
            {
                String[] tokens = input.split(" ");
                user u = new user(tokens[0], tokens[1]);
                users.add(u);
                if (tokens[0].equals(username) && tokens[1].equals(password))
                {
                    JOptionPane.showMessageDialog(null, "User exists.");
                    br.close();
                    fr.close();
                    return true;
                }
            }
            br.close();
            fr.close();
            
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        
        return false;
    }
    
    public void login(String u, String p)
    {
            boolean registeredUser = readFile(u,p);
            if(registeredUser == true)
            {
                JOptionPane.showMessageDialog(null, "You have Successfully Logged In.");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Login Failed, Invalid username or password.");
            }
    }
    
    public void addUser()
    {
        FileWriter fw = null;
        PrintWriter pw = null;
        String uname = JOptionPane.showInputDialog("Enter Username:");
        String pass = JOptionPane.showInputDialog("Enter Password:");
        
        while(true)
        {
            if(uname.length()>=20 || uname.length()<=0)
            {
              String tempuname = JOptionPane.showInputDialog("Username length, Please Enter Username of lenth <= 20:");
              uname = tempuname;
            }
            else
            {
                break;
            }
        }

        while(true)
        {
            if(pass.length()<4 || pass.length()>10)
            {
                String temppass = JOptionPane.showInputDialog("Invalid Password, Password should be >=4 and <=10, Please enter password again:");
                pass = temppass;
            }
            else
            {
                break;
            }
        }
        user u = new user(uname,pass);
        
        boolean registeredUser = readFile(uname,pass);
        
        if (registeredUser == false)
        {
            users.add(u);
        }
        
        try
        {
            fw = new FileWriter("C:\\Users\\Acer\\Documents\\NetBeansProjects\\LoginForum\\src\\loginforum\\userList.txt");
            pw = new PrintWriter(fw);
            
            pw.print("");
            
            for(int i=0;i<users.size();i++)
            {
                user use = (user)users.get(i);
                String output = use.username+" "+use.password;
                //System.out.println(use.password);
                pw.println(output);
                pw.flush();
            }
            
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
    
    public void changeUsername(String u, String p)
    {
        boolean registeredUser = readFile(u,p);
        if(registeredUser == false)
        {
            JOptionPane.showMessageDialog(null,"User doesnt exist");
        }
        else
        {
            ArrayList<user> userTemp = new ArrayList<user>();
            FileReader fr = null;
            BufferedReader br = null;
            FileWriter fw = null;
            PrintWriter pw = null;

            try
            {
                fr = new FileReader("C:\\Users\\Acer\\Documents\\NetBeansProjects\\LoginForum\\src\\loginforum\\userList.txt");
                br = new BufferedReader(fr);

                String input;
                while((input = br.readLine())!=null)
                {
                    String [] input1 = input.split(" ");
                    user user1 = new user(input1[0], input1[1]);
                    userTemp.add(user1);
                }

                if(userTemp.size()>0)
                {
                    for(int i=0;i<userTemp.size();i++)
                    {
                        user user2 = (user)userTemp.get(i);
                        if(u.equals(user2.username) && p.equals(user2.password))
                        {
                            String username = JOptionPane.showInputDialog("Enter new username = ");
                            while(true)
                            {
                                if(username.length()>=20 || username.length()<=0)
                                {
                                  String tempuname = JOptionPane.showInputDialog("Username Invalid, Please Enter Username of lenth <= 20:");
                                  username = tempuname;
                                }
                                else
                                {
                                    break;
                                }
                            }
                            user user3 = new user(username, p);
                            userTemp.remove(i);
                            userTemp.add(i, user3);
                            break;
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
                br.close();
                fr.close();
            try
            {
                fw = new FileWriter("C:\\Users\\Acer\\Documents\\NetBeansProjects\\LoginForum\\src\\loginforum\\userList.txt");
                pw = new PrintWriter(fw);
                if(users.size()>0)
                {
                    for(int i=0;i<users.size();i++)
                    {
                        users.remove(i);
                    }
                }
                pw.print("");
                for(int i=0;i<userTemp.size();i++)
                {
                    user use = (user)userTemp.get(i);
                    String output = use.username+" "+use.password;
                    users.add(use);
                    pw.println(output);
                    pw.flush();
                }
                pw.close();
                fw.close();
            }
            catch(IOException e)
            {
                System.out.println(e);
            }
            }
            catch(IOException e)
            {
                System.out.println(e);
            }
        }
    }
    
    public void changePassword(String u, String p)
    {
        boolean registeredUser = readFile(u,p);
        if(registeredUser == false)
        {
            JOptionPane.showMessageDialog(null,"User doesnt exist");
        }
        else
        {
            ArrayList<user> userTemp = new ArrayList<user>();
            FileReader fr = null;
            BufferedReader br = null;
            FileWriter fw = null;
            PrintWriter pw = null;

            try
            {
                fr = new FileReader("C:\\Users\\Acer\\Documents\\NetBeansProjects\\LoginForum\\src\\loginforum\\userList.txt");
                br = new BufferedReader(fr);

                String input;
                while((input = br.readLine())!=null)
                {
                    String [] input1 = input.split(" ");
                    user user1 = new user(input1[0], input1[1]);
                    userTemp.add(user1);
                }

                if(userTemp.size()>0)
                {
                    for(int i=0;i<userTemp.size();i++)
                    {
                        user user2 = (user)userTemp.get(i);
                        if(u.equals(user2.username) && p.equals(user2.password))
                        {
                            String password = JOptionPane.showInputDialog("Enter new password = ");
                            while(true)
                            {
                                if(password.length()<4 || password.length()>10)
                                {
                                    String temppass = JOptionPane.showInputDialog("Invalid Password, Password should be >=4 and <=10, Please enter password again:");
                                    password = temppass;
                                }
                                else
                                {
                                    break;
                                }
                            }
                            user user3 = new user(u, password);
                            userTemp.remove(i);
                            userTemp.add(i, user3);
                            break;
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
                br.close();
                fr.close();
            try
            {
                fw = new FileWriter("C:\\Users\\Acer\\Documents\\NetBeansProjects\\LoginForum\\src\\loginforum\\userList.txt");
                pw = new PrintWriter(fw);
                if(users.size()>0)
                {
                    for(int i=0;i<users.size();i++)
                    {
                        users.remove(i);
                    }
                }
                pw.printf("");
                for(int i=0;i<userTemp.size();i++)
                {
                    user use = (user)userTemp.get(i);
                    String output = use.username+" "+use.password;
                    users.add(use);
                    pw.println(output);
                    pw.flush();
                }
                pw.close();
                fw.close();
            }
            catch(IOException e)
            {
                System.out.println(e);
            }
            }
            catch(IOException e)
            {
                System.out.println(e);
            }  
        }
    }
}

