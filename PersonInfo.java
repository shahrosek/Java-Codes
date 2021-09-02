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

/*
Shahrose Khaliq
13L-4322
Section - AP - 8A
*/

//Class for making a person object with name, address, cnic, phone, gender
public class PersonInfo {
    
    //defaut parameters for PersonInfo
    public String name;
    public String address;
    public String cnic;
    public String gender;
    public String phone;
    
    //Parameterized constructor for PersonInfo
    public PersonInfo(String n, String a, String c, String g, String p)
    {
        name = n;
        address = a;
        cnic = c;
        gender = g;
        phone = p;
    }
    
    //Default constructor for PersonInfo
    public PersonInfo()
    {
        
    }
    
    //setter method for name
    public void setName(String n)
    {
        name = n;
    }
    
    //setter method for address
    public void setAddress(String a)
    {
        address = a;
    }
    
    //setter method for cnic
    public void setCnic(String c)
    {
        cnic = c;
    }
    
    //setter method for gender
    public void setGender(String g)
    {
        gender = g;
    }
    
    //setter method for phone
    public void setPhone(String p)
    {
        phone = p;
    }
    
    
    //getter method for name
    public String getName()
    {
        return name;
    }
    
    //getter method for address
    public String getAddress()
    {
        return address;
    }
    
    //getter method for gender
    public String getGender()
    {
        return gender;
    }
    
    //getter method for cnic
    public String getCnic()
    {
        return cnic;
    }
    
    //getter method for phone
    public String getPhone()
    {
        return phone;
    }
}
