/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package multithreadedlogin;

/**
 *
 * @author Acer
 * 
 * Shahrose Khaliq
 * 13L-4322
 * AP - 8A
 * 
 * This program is the implementation of Multi threaded server of a hypothetical web site login page. It contains the functionality of creating a thread for each time a client calls a function of login, register user, change username and change password.
 * 
 */

//libraries for implementing sockets, multithreading and databases
import java.net.*;
import java.io.*;
import java.util.*;
import java.sql.*;

//class for creating a multi threaded server
public class ThreadedServer
{
    //main method for creating threads
    public static void main(String args[])
    {
        //legend message
        System.out.println("This program is the implementation of multi threaded server of hypothetical login page. It contains the functionality for creating a thread for each incoming client. Each time client requests the operations of login, register user, change password, change username, a new thread is invoked.");
        //creating a server socket object
        ServerSocket server = null;
        
        //creating a threaded server object
        ThreadedServer ts = new ThreadedServer();
        
        //try block for server socket exception
        try
        {
            //assigning the port number 2223 for server socket
            server = new ServerSocket(2223);
            
            //set server address to true, so server can accept connections even when it is in timeout
            server.setReuseAddress(true);
            
            //loop for listening incoming clients
            while(true)
            {
                //client socket for accepting incoming client requests
                Socket client = server.accept();
                                
                //assign the client object to request handler class
                RequestHandler clientSocket = new RequestHandler(client);
                
                //create a thread for client
                new Thread(clientSocket).start();
            }
        }
        catch(IOException e) //IOException for socket
        {
            System.out.println(e);
        }
        finally
        {
            //if server has clients
            if(server != null)
            {
                try
                {
                    //close server
                    server.close();
                }
                catch(IOException e) //Socket exception for server
                {
                    System.out.println(e);
                }
            }
        }
    }
    
    //class to implement multithreading
    private static class RequestHandler implements Runnable
    {
        //create a client socket object
        private final Socket clientSocket;
        
        //create a connection object
        Connection conn;
        
        //library for encrypting passwords
        Base64.Encoder encrypt;
        
        //constructor for this class
        public RequestHandler(Socket socket)
        {
            //assign the client socket object to incoming client
            this.clientSocket = socket;
            
            //initialize the encryption library
            encrypt = Base64.getEncoder();
        }
        
        //Method for establishing a connection to the database AddressBookDB
        public Connection getDBConnection()
        {
            //set connection object to null
            Connection conn = null;
            try
            {
                //The JDBC driver for establishing a connection
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

                //The path of the database AddressBookDB
                String url="jdbc:ucanaccess://C:\\Users\\Acer\\Documents\\userList.accdb";

                //Passing the connection to conn object
                conn=DriverManager.getConnection(url);
            }
            catch(Exception e) // catch block for exceptions
            {
                System.out.println(e);
            }

            //Returing the conn varible for connection to be called in specific methods to connect to database.
            return conn;
        }

        //method for logging the user into hypothetical web site
        public Boolean loginUser(String username, String password)
        {
            //establish conneciton to userListDB
            conn = getDBConnection();

            //boolean variable for if the user exists in the database
            Boolean found = false;

            //query for searching the given user in database
            String sql = "Select * from userListDB where username = ? and password = ?";

            //encrpt the given password
            String passwordEncrypt = encrypt.encodeToString(password.getBytes());

            try
            {
                //prepare statement object for executing sql quert
                PreparedStatement pSt = conn.prepareStatement(sql);

                //setting the username and encrypted password in query
                //test: username="ali", password="1234" in encrypted form
                pSt.setString(1,username);
                pSt.setString(2, passwordEncrypt);

                //contains the result of running the query
                ResultSet rs = pSt.executeQuery();

                //if result set is not empty, user is found
                if(rs.next())
                {
                    found = true;
                }

                //closing db connection
                conn.close();
            }
            catch(Exception e) //exception for sql query
            {
                System.out.println(e);
            }

            //return if user is found or not
            return found;
        }
        
        //method for registering a user in database
        public Boolean addUser(String username, String password)
        {
            //establishing the db connection
            conn = getDBConnection();

            //bool variable if user is added to db or not
            Boolean added = false;

            //query for inserting the user into database
            String sql = "Insert into userListDB values(?,?)";

            //encrypting the password
            String passwordEncrypt = encrypt.encodeToString(password.getBytes());

            try
            {
                //prepapre statement object for running query
                PreparedStatement pSt = conn.prepareStatement(sql);

                //setting the username and password in query
                //test: username="ali" and password = "1234" in encrypted form
                pSt.setString(1, username);
                pSt.setString(2, passwordEncrypt);

                //running the query
                int rows = pSt.executeUpdate();

                //if rows is greater than 0, then user was added
                if(rows>0)
                {
                    added = true;
                }

                //closing the db connection
                conn.close();
            }
            catch(Exception e) //exception for sql query
            {
                System.out.println(e);
            }

            //return bool variable if user is added or not
            return added;
        }

        //method for changing the username of an existing user in database
        public Boolean changeUsername(String username, String password, String newUsername)
        {
            //bool variable for indicating is username is changed or not
            Boolean changed = false;

            //establishing a db connection
            conn = getDBConnection();

            //query for changing the old username
            String sql = "Update userListDB set username = ?"+"where username = ? and password = ?";

            //encrypting the password
            String passwordEncrypt = encrypt.encodeToString(password.getBytes());

            try
            {
                //prepare statement for running query
                PreparedStatement pSt = conn.prepareStatement(sql);

                //setting parameters for running query
                //test: username="ali", new username = "raza", password = "1234" in encrypted form
                pSt.setString(1, newUsername);
                pSt.setString(2, username);
                pSt.setString(3, passwordEncrypt);

                //running query for update
                int rows = pSt.executeUpdate();

                //if rows is greater than 0, update successful
                if(rows>0)
                {
                    changed = true;
                }

                //closing the db connection
                conn.close();
            }
            catch(Exception e) //exception for sql query
            {
                System.out.println(e);
            }

            //return true if username is changed and false if not
            return changed;
        }

        //method for changing password for an exisitng user in database
        public Boolean changePassword(String username, String password, String newPassword)
        {
            //bool variable to indicated if password is changed or not
            Boolean changed = false;

            //establsh db connection
            conn = getDBConnection();

            //query for changing password of a given user
            String sql = "Update userListDB set password = ?"+"where username = ? and password = ?";

            //encrypt old password
            String passwordEncrypt = encrypt.encodeToString(password.getBytes());

            //encrypt new password
            String newPasswordEncrypt = encrypt.encodeToString(newPassword.getBytes());

            try
            {
                //prepare statment object for running query
                PreparedStatement pSt = conn.prepareStatement(sql);

                //setting parameters for running the query
                //test: new password = "12345" in encrypt form, username = "raza" , password = "1234" in encrypt form
                pSt.setString(1, newPasswordEncrypt);
                pSt.setString(2, username);
                pSt.setString(3, passwordEncrypt);

                //run the query
                int rows = pSt.executeUpdate();

                //if rows greater than 0. password is changed
                if(rows>0)
                {
                    changed = true;
                }

                //close db connection
                conn.close();
            }
            catch(Exception e) // exception block for sql query
            {
                System.out.println(e);
            }

            //return true if password changed and false if not
            return changed;
        }
        
        public void run()
        {
            try 
            {
                //for reading client messages from input socket
                InputStream is= clientSocket.getInputStream();
                InputStreamReader isr=new InputStreamReader(is);
                BufferedReader br=new BufferedReader(isr);

                //for writing server response in output socket
                OutputStream out = clientSocket.getOutputStream();
                PrintWriter pw = new PrintWriter(out, true);

                //get username from client
                String username = br.readLine();

                //get password from client
                String password = br.readLine();

                //get command from client
                String command = br.readLine();

                //if command is login, then call login method
                if(command.equals("Login"))
                {
                    //login method of user
                    //username and password as paramteres
                    //method returns true if user is found
                    Boolean found = loginUser(username, password);

                    //if user found, write "Login Successful" to client socket
                    if(found == true)
                    {
                        pw.println("Login Successful");
                    }
                    else // if user not found, print error message "Login Failed"
                    {
                        pw.println("User with given credentials does not exist. Login Failed");
                    }
                }
                else if(command.equals("Register User")) //if command is "Register User", call addUser method
                {
                    //provide username, password as arguments in addUser method
                    //method returns true if user is added
                    Boolean added = addUser(username, password);
                    if(added == true)
                    {
                        //wrtie "User Registered Successfully" to client socket
                        pw.println("User Registered Successfully");
                    }
                    else
                    {
                        //write error message if user is not add "User Registration failed"
                        pw.println("User with given username already exists. User Registration Failed");
                    }
                }
                else if(command.equals("Change Username")) //is command is "Change Username", then call loginUser method first to check if user exists, if it does then call changeUsername method
                {
                    //check if user exists
                    Boolean found = loginUser(username, password);

                    if(found == true)
                    {
                        //if user found, write "User exists in client socket"
                        pw.println("User exists");

                        //get new username from client socket
                        String newUsername = br.readLine();

                        //call changeUsername method and provide old username, password, and new username as parameters
                        Boolean changed = changeUsername(username, password, newUsername);

                        if(changed == true)
                        {
                            //if username is changed, write "Username Changed Successfully" in client socket
                            pw.println("Username Changed Successfully");
                        }
                        else
                        {
                            //if username is not changed, write error message "Change of Username Failed"
                            pw.println("Change of Username Failed");
                        }
                    }
                    else
                    {
                        //write error message that user does not exist and change username operation failed.
                        pw.println("User with given credentials does not exist. Change Username Operation Failed");
                    }
                }
                else if(command.equals("Change Password")) //if command is "Change Password", call loginUser first to see if user exists, if it does then call changePassword method
                {
                    //check if user exists
                    Boolean found = loginUser(username, password);

                    if(found == true)
                    {
                        //if user exists, write "User exists" in client socket
                        pw.println("User exists");

                        //get new password from client socket
                        String newPassword = br.readLine();

                        //call changePassword method and provide username , old password and new password as parameters
                        Boolean changed = changePassword(username, password, newPassword);

                        if(changed == true)
                        {
                            //write "Password Changed Successfully" client socket if password changed
                            pw.println("Password Changed Successfully");
                        }
                        else
                        {
                            //write "Change of Password Failed" in client socket if password not changed
                            pw.println("Change of Password Failed");
                        }
                    }
                    else
                    {
                        //write error message that Change Password operation Failed, if user does not exist.
                        pw.println("User with provided credentials does not exist. Change Password Operation Failed");
                    }
                }

                //close input reader
                br.close();

                //close output writer
                pw.close();

                //close accepting socket
                clientSocket.close();
            }
            catch(Exception e) //Exception block for socket
            {
                System.out.println(e);
            }
        }
    }   
}
