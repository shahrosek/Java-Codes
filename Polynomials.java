/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package polynomials;
import java.util.*;
/**
 *
 * @author Acer
 */
public class Polynomials {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
            
        // TODO code application logic here
        polyDriver p = new polyDriver();
        p.readFile();
        //p.display();
        
        System.out.println("Enter 1 for addition \nEnter 2 for subtraction \nEnter 3 for multiplication \nEnter 4 to quit");
        String choice;
        Scanner obj = new Scanner(System.in);
        
        while(true)
        {
            choice = obj.nextLine();
            try
            {
                    int input = Integer.parseInt(choice);
                    switch(input)
                    {
                        case 1:
                        p.polyAddition();
                        break;

                        case 2:
                        p.polySubtraction();
                        break;

                        case 3:
                        p.polyMultiplication();
                        break;

                        case 4:
                        System.exit(0);
                    }
            }

            catch(NumberFormatException e)
            {
                System.out.println("Exception"+e+" Please enter correct input");
            }
            
            System.out.println("\nEnter 1 for addition \nEnter 2 for subtraction \nEnter 3 for multiplication \nEnter 4 to quit");

        }
    }
    
}
