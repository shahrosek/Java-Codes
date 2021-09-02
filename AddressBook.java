/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package addressbook;

/**
 *
 * @author Acer
 */
/* Shahrose Khaliq
13L-4322
Section - 8A
This program is the implementation Addrees Book with GUI and Database. It prvoides the functionality of adding, searching, updating and deleting a person in Address Book.
*/
//importing the neccessary libraries for database connection, and gui implementation
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.*;
import java.sql.*;

//class for implementating the default functionalities of Address Book with GUI
public class AddressBook extends JFrame implements ActionListener {

    /**
     * @param args the command line arguments
     */
    
    
    //Declaring the variables for initializing a GUI.
    JFrame frame;
    JButton addBtn, deleteBtn, updateBtn, searchBtn, clearBtn;
    JLabel nameLbl, addressLbl, genderLbl, phoneLbl, cnicLbl, noteLbl;
    JTextField nameFld, addressFld, genderFld, phoneFld, cnicFld, noteFld;
    
    //Declaring the panels for holding general purpose containers.
    JPanel p1, p2, p3;
    
    //Declaring a variable for container
    Container con;
    
    //Declaring a variable to hold Connection variable
    Connection conn;
    
    //Declaring default parameters for person.
    String name, address, gender, phone, cnic;
    
    //Method for initailizing a GUI
    public void initGUI()
    {
        //Making a frame object to store the GUI
        frame = new JFrame("Address Book");
        
        //Getting the programmable space for implementing a GUI
        con = frame.getContentPane();
        
        //Initializing the buttons with their name as parameter for GUI
        addBtn = new JButton("Add");
        deleteBtn = new JButton("Delete");
        updateBtn = new JButton("Update");
        searchBtn = new JButton("Search");
        clearBtn = new JButton("Clear");
        
        //Initializing the Labels with their name as parameter for GUI
        nameLbl = new JLabel("Name");
        addressLbl = new JLabel("Address");
        cnicLbl = new JLabel("CNIC");
        genderLbl = new JLabel("Gender");
        phoneLbl = new JLabel("Phone No.");
        noteLbl = new JLabel("Note");
        
        //Initializing the Input text fields with their preferred size for GUI
        nameFld = new JTextField(50);
        addressFld = new JTextField(50);
        cnicFld = new JTextField(50);
        genderFld = new JTextField(50);
        phoneFld = new JTextField(50);
        noteFld = new JTextField(50);
        
        //Initializing the panel with GridLayout as general purpose containers
        p1 = new JPanel(new GridLayout(6,1, 10, 20));
        p2 = new JPanel(new GridLayout(6,1, 10, 20));
        p3 = new JPanel(new GridLayout(1,5, 0, 20));
        
        //adding the labels and input text fiels in the panels p1 and p2.
        p1.add(nameLbl);
        p2.add(nameFld);
        p1.add(addressLbl);
        p2.add(addressFld);
        p1.add(cnicLbl);
        p2.add(cnicFld);
        p1.add(genderLbl);
        p2.add(genderFld);
        p1.add(phoneLbl);
        p2.add(phoneFld);
        p1.add(noteLbl);
        p2.add(noteFld);
        
        //adding the buttons in the panel p3
        p3.add(addBtn);
        p3.add(searchBtn);
        p3.add(deleteBtn);
        p3.add(clearBtn);
        p3.add(updateBtn);
        
        //setting the layout of top level container as BorderLayout
        con.setLayout(new BorderLayout());
        
        //adding the panel p1 for labels to left side i.e. WEST, panel p2 for input fields to the CENTER and panel p3 for buttons to the bottom i.e.SOUTH
        con.add(p1, BorderLayout.WEST);
        con.add(p2, BorderLayout.CENTER);
        con.add(p3, BorderLayout.SOUTH);
        
        //Registering the Buttons to their Action Listeners.
        addBtn.addActionListener(this);
        searchBtn.addActionListener(this);
        deleteBtn.addActionListener(this);
        updateBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        //Setting the height and width of the frame as 500 by 500.
        frame.setSize(500,500);
        
        //Setting the close button to exit the frame by pressing cross button.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Setting the resizeable property of frame to false.
        frame.setResizable(false);
        
        //Setting the visible property of frame to true.
        frame.setVisible(true);

    }
    
    //Method for establishing a connection to the database AddressBookDB
    public Connection getDBConnection()
    {
        Connection conn = null;
        try
        {
            //The JDBC driver for establishing a connection
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            //The path of the database AddressBookDB
            String url="jdbc:ucanaccess://C:\\Users\\Acer\\Desktop\\AddressBookDB.accdb";
            
            //Passing the connection to conn object
            conn=DriverManager.getConnection(url);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        //Returing the conn varible for connection to be called in specific methods to connect to database.
        return conn;
    }
    
    //This method clears the text field values
    public void clear()
    {
        //set name text field to empty string
        nameFld.setText("");
        
        //set address text field to empty string
        addressFld.setText("");
        
        //set cnic text field to empty string
        cnicFld.setText("");

        //set phone text field to empty string
        phoneFld.setText("");
                
        //set gender text field to empty string
        genderFld.setText("");
        
        //set note text field to empty string
        noteFld.setText("");
    }
    
    //This method searches for a person if their name or cnic is provided
    public void searchPerson()
    {
        //Get the text field values of name and cnic from gui
        name = nameFld.getText();
        cnic = cnicFld.getText();
        
        //Initialize a PersonInfo object
        PersonInfo person;
        
        //If name and cnic both are not input by user, then quit the search and display error message
        //Test: if name = "" and cnic = "", print "Please enter either name or cnic to search for a Person in the Address Book"
        if(name.equals("") && cnic.equals(""))
        {
            //echo message
            System.out.println("User entered name "+ name);
            System.out.println("User entered cnic "+ cnic);

            noteFld.setText("Please enter either name or cnic to search for a Person in the Address Book.");
            return;
        }
        
        //calling the method searchPersonDB with parameeters name and cnic to search a person in AddressBookDB
        person = searchPersonDB(name, cnic);
        
        //If person not found then display error message and quit search operation.
        //Test: if name = abcd or cnic = 12345-2345678-2, then display in note text field "No Person found with such credentials" and quit search 
        if(person == null)
        {
            noteFld.setText("No person found with such credentials.");
            return;
        }
        else
        {
            //If person object not equal to null, then display Person's name in input text field 
            //Test: "Shahrose"
            nameFld.setText(person.name);
            
            //display person's address in address text field
            //Test: "123 town Lahore"
            addressFld.setText(person.address);
            
            //display person's CNIC in cnic text field
            //Test: 12345-1234567-1
            cnicFld.setText(person.cnic);
            
            //display person's gender in gender text field
            //test: "Male"
            genderFld.setText(person.gender);
            
            //display person's phone number in phone text field
            //Test: 12345678912
            phoneFld.setText(person.phone);
        }    
    }
    
    //This method takes the parameters name and cnic and searches the database AddressBookDB for the person and returns a PersonInfo object
    public PersonInfo searchPersonDB(String name, String cnic)
    {
        //Declaring sql string for taking the query parameter
        String sql;
        
        //initializing a personinfo object to null 
        PersonInfo person = null;
        
        //if cnic = "", then search the database with name
        if(cnic.equals(""))
        {
            //query for searching the database with name
            //Test: Select * from AddressBookDB where PersonName like Shahrose
            sql = "Select * from AddressBookDB where PersonName like '%"+name+"%'";
        }
        else if(name.equals("")) // if name = "", then search the database with CNIC
        {
            //query for searching the database with CNIC
            //Test: Select * from AddressBookDB where PersonCNIC like 12345=1234567-1
            sql = "Select * from AddressBookDB where PersonCNIC like '%"+cnic+"%'";
        }
        else // if both name and cnic are given, then search the database with CNIC
        {
            //query for searching the database with CNIC
            //Test: Select * from AddressBookDB where PersonCNIC like 12345=1234567-1
            sql = "Select * from AddressBookDB where PersonCNIC like '%"+cnic+"%'";
        }
        
        //Establish DB conneciton with AddressBookDB 
        Connection dbConnection = getDBConnection();
        
        //try catch block for SQL Exception
        try
        {
            //Initialize a PreparedStatement object with the given query
            PreparedStatement pSt = dbConnection.prepareStatement(sql);
            
            //Execute the query and store the result set in rs
            ResultSet rs = pSt.executeQuery();
            
            //loop for traversing the result set to find the desired person
            while(rs.next())
            {
                //getting the person object details from result set of each person
                String pname = rs.getString("PersonName");
                String pcnic = rs.getString("PersonCNIC");
                String paddress = rs.getString("PersonAddress");
                String pphone = rs.getString("PersonPhone");
                String pgender = rs.getString("PersonGender");
                
                // if name or cnic matches the result set variables, then initializing personinfo object and stop traversing the loop
                if(pname.equals(name) || pcnic.equals(cnic))
                {
                    //Test: person = new PersonInfo("Shahrose", "123 town Lahore", "12345-1234567-1", "Male", "12345678912");
                    person = new PersonInfo(pname, paddress, pcnic, pgender, pphone);
                    
                    //terminate the loop
                    break;
                }
            }
            
            //close the database connection
            dbConnection.close();
        }
        catch(Exception e) //catch block if any SQL exception occurs.
        {
            //print the SQL exception on console
            System.out.println(e);
        }
        
        //return the PersonInfo object
        return person;
    }
    
    //method for adding a person in database AddressBookDB
    public void addPerson()
    {
        //get the name value from name text field
        name = nameFld.getText();
        
        // if name text field is null, display error message in name text field
        // Test: if name text feild = "", display "Name not found. Addition of person Failed"
        if(name.equals(""))
        {
            //echo message
            System.out.println("User entered name"+name);
            
            nameFld.setText("Name not found. Addition of Person Failed");
            return;
        }
        
        //echo message
        System.out.println("User entered name"+name);
        
        //get the cnic text field value
        cnic = cnicFld.getText();
        
        // if cnic text field is null, display error message in cnic text field
        // Test: if cnic text feild = "", display "CNIC not found. Addition of person Failed"
        if(cnic.equals(""))
        {
            //echo message
            System.out.println("User entered cnic "+cnic);
            
            cnicFld.setText("CNIC not found. Addition of Person Failed");
            return;
        }
        
        //echo message
        System.out.println("User entered cnic "+cnic);
        
        //get the address text field value
        address = addressFld.getText();
        
        // if address text field is null, display error message in address text field
        // Test: if address text feild = "", display "Address not found. Addition of person Failed"
        if(address.equals(""))
        {
            //echo message
            System.out.println("User entered address "+address);
            
            addressFld.setText("Address not found. Addition of Person Failed");
            return;
        }
        
        //echo message
        System.out.println("User entered address "+address);
        
        //get the phone text field value
        phone = phoneFld.getText();
        
        // if phone text field is null, display error message in phone text field
        // Test: if phone text feild = "", display "Phone number not found. Addition of person Failed"
        if(phone.equals(""))
        {
            //echo message
            System.out.println("User entered phone number "+phone);
            
            phoneFld.setText("Phone number not found. Addition of Person Failed");
            return;
        }
        
        //echo message
        System.out.println("User entered phone number "+phone);
        
        //get the gender text field value
        gender = genderFld.getText();
        
        // if gender text field is null, display error message in name text field
        // Test: if gender text feild = "", display "Gender not found. Addition of person Failed"
        if(gender.equals(""))
        {
            //echo message
            System.out.println("User entered gender "+ gender);
            
            genderFld.setText("Gender not found. Addition of Person Failed");
            return;
        }
        
        //echo message
        System.out.println("User entered gender "+ gender);
        
        //search the database AddressBookDB to find the find the person with give name and cnic
        PersonInfo person = searchPersonDB(name, cnic);
        
        //if person object is not equal to null, then this person already exists.
        //Test: if person not equal to null, then display This Person Already exits" in the note text field
        if(person != null)
        {
            noteFld.setText("This Person Already exists");
        }  
        else // if person object is null, then the person doesnt exist and addition will proceed.
        {
            //try catch block for sql exception
            try
            {
                //Query for inserting a person in AddressBookDB
                String sql = "Insert into AddressBookDB values(?,?,?,?,?)";

                //Establish a database connection with AddressBookDB
                Connection dbConnection = getDBConnection();
                
                //A prepared statement object to run the query in java
                PreparedStatement pSt = dbConnection.prepareStatement(sql);

                //setting the parameters for addition
                
                //Test: PersonName = "Shahrose"
                pSt.setString(1, name);
                
                //Test: PersonAddress = "123 town Lahore"
                pSt.setString(2, address);
                
                //Test: PersonCNIC = "12345-1234567-1"
                pSt.setString(3, cnic);
                
                //Test: PersonPhone = "12345678912"
                pSt.setString(4, phone);
                
                //Test: PersonGender = "Male"
                pSt.setString(5, gender);
                
                //execute the the query for addition, it returns the number of rows affected
                int rows = pSt.executeUpdate();
                
                //close the database connection
                dbConnection.close();
            }
            catch(SQLException e) // catch block for SQL exception
            {
                //print the sql exception on console
                System.out.println(e);
            }
        }
    }
    
    //method for deleting a person in the database AddressBookDB
    public void deletePerson()
    {
        //get the name and cnic text field values
        name = nameFld.getText();
        cnic = cnicFld.getText();
        
        //declaring a variable for sql query
        String sql;
        
        //declaring a variable to store the result for deleting a record
        int result = 0;
        
        //if name and cnic are not provided, then print error message and quit
        //Test: if name="" and cnic="", then display "Please enter either name or cnic to Remove a Person in the Address Book" in note text field and quit deletion.
        if(name.equals("") && cnic.equals(""))
        {
            //echo message
            System.out.println("User entered name "+name);
            System.out.println("User entered cnic "+cnic);

            noteFld.setText("Please enter either name or cnic to Remove a Person in the Address Book.");
            return;
        }
        
        //echo message
        System.out.println("User entered name "+name);
        System.out.println("User entered cnic "+cnic);
        
        //create a personinfo object and search the database to see if a person exists with the given name or cnic
        PersonInfo person = searchPersonDB(name, cnic);
        
        //If person is null, then the person doesnt exist. display error messgae.
        //Test: if person is null, display "Person with such credentials does not exist."
        if(person == null)
        {
            noteFld.setText("Person with such credentials does not exist.");
        }
        else
        {
            // if person is not null, then proceed with delete operation
            
            try // try catch block for sql exception
            {
                //establish a connection with database AddressBookDB
                Connection dbConnection = getDBConnection();
                
                //If name is null, then search the person with cnic
                if(name.equals(""))
                {
                    //Test: Delete from AddressBookDB where PersonCNIC = 12345-1234567-1
                    sql = "Delete from AddressBookDB where PersonCNIC = ?";

                }
                else if(cnic.equals("")) //if cnic equals null, then search the person with name
                {
                    //TESt: "Delete from AddressBookDB where PersonName = "Shahrose"
                    sql = "Delete from AddressBookDB where PersonName = ?";
                }
                else // If name and cnic are both given, then serarch the person with cnic
                {
                    sql = "Delete from AddressBookDB where PersonCNIC = ?";                
                }
                
                //prepared statement object for performing delete in java
                PreparedStatement pSt = dbConnection.prepareStatement(sql);

                //if name is null, set string with cnic
                if(name.equals(""))
                    //TEst: set string with cnic = "12345-1234567-1"
                    pSt.setString(1,cnic);
                // if cnic is null, set string with name
                else if(cnic.equals(""))
                    // Test: set string with name = "shahrose"
                    pSt.setString(1, name);
                //if name and cnic are both given, then set string with cnic
                else
                    //Test: set string with cnic = "12345-1234567-1"
                    pSt.setString(1,cnic);
                
                //Perform the query and the save the number of affected rows in result
                result = pSt.executeUpdate();
            }
            catch(SQLException e)//catch block for sql exception
            {
                //print sql exception on console.
                System.out.println(e);
            }
        }
    }
    
    //method for updating a person in the database AddressBookDB
    public void updatePerson()
    {
       //get the name value from name text field
        name = nameFld.getText();
        
        // if name text field is null, display error message in name text field
        // Test: if name text feild = "", display "Name not found. Update Failed"
        if(name.equals(""))
        {
            //echo message
            System.out.println("User entered name"+name);
            
            nameFld.setText("Name not found. Update Failed");
            return;
        }
        
        //echo message
        System.out.println("User entered name"+name);
        
        //get the cnic text field value
        cnic = cnicFld.getText();
        
        // if cnic text field is null, display error message in cnic text field
        // Test: if cnic text feild = "", display "CNIC not found. Udpate Failed"
        if(cnic.equals(""))
        {
            //echo message
            System.out.println("User entered cnic "+cnic);
            
            cnicFld.setText("CNIC not found. Update Failed");
            return;
        }
        
        //echo message
        System.out.println("User entered cnic "+cnic);
        
        //get the address text field value
        address = addressFld.getText();
        
        // if address text field is null, display error message in address text field
        // Test: if address text feild = "", display "Address not found. Update Failed"
        if(address.equals(""))
        {
            //echo message
            System.out.println("User entered address "+ address);
            
            addressFld.setText("Address not found. Update Failed");
            return;
        }
        
        //echo message
        System.out.println("User entered address "+ address);
        
        //get the phone text field value
        phone = phoneFld.getText();
        
        // if phone text field is null, display error message in phone text field
        // Test: if phone text feild = "", display "Phone number not found. Update Failed"
        if(phone.equals(""))
        {
            //echo message
            System.out.println("User entered phone number "+ phone);
            
            phoneFld.setText("Phone number not found. Update Failed");
            return;
        }
        
        //echo message
        System.out.println("User entered phone number "+ phone);
        
        //get the gender text field value
        gender = genderFld.getText();
        
        // if gender text field is null, display error message in name text field
        // Test: if gender text feild = "", display "Gender not found. Update Failed"
        if(gender.equals(""))
        {
            //echo message
            System.out.println("User entered gender "+ gender);
            
            genderFld.setText("Gender not found. Update Failed");
            return;
        }
        
        //echo message
        System.out.println("User entered gender "+ gender);
        
        try // try catch block 
        {
            //Establishing a connection with database
            Connection dbConnection = getDBConnection();
            
            //sql query for update
            String sql = "Update AddressBookDB set PersonName = ?, PersonAddress = ?, PersonPhone = ?, PersonGender = ?"+"where PersonCNIC = ?";
            
            //prepared statement object for updating a person
            PreparedStatement pSt = dbConnection.prepareStatement(sql);
            
            //setting parameters for update query
            
            //Test:set PersonName = "Ali"
            pSt.setString(1, name);
            
            //Test: set PersonAddress = "456 town Multan"
            pSt.setString(2, address);
            
            //Test: set PersonPhone = "23456789123"
            pSt.setString(3, phone);
            
            //Test: set PersonGender = "Male"
            pSt.setString(4, gender);
            
            //Test: set PersonCNIC = "23456-1235467-2"
            pSt.setString(5, cnic);
            
            //Perform the query for update save the number of affected rows in rows
            int rows = pSt.executeUpdate();
            
            //close the database connection
            dbConnection.close();

            
        }
        catch(Exception e) // catch block for sql exception
        {
            //print sql exception on console
            System.out.println(e);
        }
    }
    
    //method for overriding actionPerformed method of ActionListener class to call function when a certain button is pressed
    public void actionPerformed(ActionEvent e)
    {
        // if button pressed = "Add" call method addPerson()
        if(e.getSource() == addBtn)
            addPerson();
        // if button pressed = "Update" call method updatePerson()
        else if(e.getSource() == updateBtn)
            updatePerson();
        // if button pressed = "Delete" call method deletePerson()
        else if(e.getSource() == deleteBtn)
            deletePerson();
        //if button pressed = "Search" call method searchPerson()
        else if(e.getSource() == searchBtn)
            searchPerson();
        // if button pressed = "Clear" call method clear()
        else if(e.getSource() == clearBtn)
            clear();
    }
    
    //default constructor for class AddressBook
    public AddressBook()
    {
        //setting default parameters for AddressBook to empty string
        name = "";
        address = "";
        cnic = "";
        phone = "";
        gender = "";
        
        //calling the method for creating GUI
        initGUI();
    }
    
    //Driver method for testing the AddressBook class
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Legend Messgae
        JOptionPane.showMessageDialog(null, "Welcome to Address Book. This Program is a GUI application which contains the functionality of adding a Person with attributes Name, CNIC, Address, Phone number, and Gender. You can also delete a person with his name or cnic. You can search a person with his name or cnic. You can update a person with his name or cnic.");
        
        //Initializing AddressBook object 
        AddressBook a = new AddressBook();
        
    }
    
}
