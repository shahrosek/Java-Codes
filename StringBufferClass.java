/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stringbufferclass;

import java.util.Scanner;

/**
 *
 * @author Acer
 * Shahrose Khaliq
 * l134322@lhr.nu.edu.pk
 * AP - 8A
 * This program explores some functions of StringBuffer class.
 */
public class StringBufferClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("This program provides exploration of few functions of StringBuffer class.");
        
        //1
        //This block of code takes input from the user of a Long String and Short String contained within the Long String.
        //Test = Long String: 'I think that this course really rules'
        System.out.println("Enter a Long String: ");
        Scanner inp = new Scanner(System.in);
        String longString = inp.nextLine();
        System.out.println("You entered Long String = "+longString);
        
        //Test = Short String: 'this course'
        System.out.println("Enter a short String: ");
        String shortString = inp.nextLine();
        System.out.println("You entered Short String = "+shortString);

        //2
        //This block of code initialized the StringBuffer object. And appends the long string to the object.
        // Test = sb contains the Long String entered by user 'I think that this course really rules'
        StringBuffer sb = new StringBuffer();
        sb.append(longString);
        
        //3
        //This method initializes the StringBuffer object with a paramtereized constrcutor with long string.
        //StringBuffer sb = new StringBuffer(longString);
        
        //4
        //This line of code gets the starting index of short string in the long string in StringBuffer object.
        //Test = posShortString gets the index of 'this course' = 13
        int posShortString = sb.indexOf(shortString);
        
        //5
        //This block of code deletes the short string in long string in the StringBuffer object and prints it.
        //Test = After deleting the short string , resultant StringBuffer object contains 'I think that  really rules'
        int endIndex = posShortString + shortString.length();
        sb.delete(posShortString, endIndex);
        System.out.println(sb);
        
        //6
        //This block of code inserts a new string CS433 in the string index of short string in the StringBuffer object and prints it.
        //Test = After inserting CS433 in StringBuffer object at the position of Short String, resultant StringBuffer object contains = 'I think that CS433 really rules'
        sb.insert(posShortString, "CS433");
        System.out.println(sb);
        
        //7
        //This block of code deletes the last word in the StringBuffer object and prints it.
        //Test = After deleting the last word, StringBuffer object becomes 'I think that CS433 really'
        int lastSpaceIndex = sb.lastIndexOf(" ");
        sb.delete(lastSpaceIndex, sb.length());
        System.out.println(sb);
        
        //8
        //This block of code appends the string rocks in the StringBuffer object and prints it.
        //Test = After appending the string ' rocks', StringBuffer object contains = 'I think that CS433 really rocks'
        String rocks = " rocks";
        sb.append(rocks);
        System.out.println(sb);

        //9
        //This block of code deletes the character in the middle of StringBuffer object and prints it.
        //Test = After deleting the middle character, StringBuffer object contains = 'I think that CS33 really rocks'
        sb.deleteCharAt(sb.length()/2);
        System.out.println(sb);

        //10
        //This block of code reverses the contents of StringBuffer object and prints it.
        //Test = After reversing the contents, the StringBuffer object contains 'skcor yllaer 33SC taht kniht I'
        sb.reverse();
        System.out.println(sb);
    }
    
}
