/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package polynomials;
import java.io.*;
import java.util.*;
/**
 *
 * @author Acer
 */
public class polyDriver {
    ArrayList<polynomial> poly;
    
    public polyDriver()
    {
        poly = new ArrayList<polynomial>();
    }
    
    public void readFile()
    {
        FileReader fr = null;
        BufferedReader br = null;
        
        try
        {
            fr = new FileReader("C:\\Users\\Acer\\Documents\\NetBeansProjects\\Polynomials\\src\\polynomials\\polynomialInput.txt");
            br = new BufferedReader(fr);
            
            String input;
            
            while((input = br.readLine())!=null)
            {
                String[] input1 = input.split(",");
                polynomial p = new polynomial(Integer.parseInt(input1[0]));
                int j = 1;
                for(int i=0;i<p.degree+1;i++)
                {
                    p.poly[i] = Integer.parseInt(input1[j]);
                    j++;
                }
                poly.add(p);
            }
            br.close();
            fr.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
    
    public void display()
    {
        for(int i=0;i<poly.size();i++)
        {
            polynomial p = (polynomial)poly.get(i);
            System.out.println("Degree = "+p.degree);
            for(int j=0;j<p.degree+1;j++)
            {
                System.out.println("Array element at "+j+"th index = "+p.poly[j]);
            }
        }
    }
    
    public void polyAddition()
    {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter Index of Polynomial 1 = ");
        String poly1 = obj.nextLine();
        System.out.println("Enter index of Polynomial 2 = ");
        String poly2 = obj.nextLine();
        
        polynomial result;
        
        int index1 = Integer.parseInt(poly1);
        int index2 = Integer.parseInt(poly2);
        
        polynomial p1 = (polynomial)poly.get(index1);
        polynomial p2 = (polynomial)poly.get(index2);
        
        if(p1.degree > p2.degree)
        {
            result = new polynomial(p1.degree);
            for(int i=0; i<p1.degree+1;i++)
            {
                if(i>p2.degree)
                {
                    result.poly[i] = p1.poly[i];
                }
                else
                {
                result.poly[i] = p1.poly[i] + p2.poly[i];
                }
            }
        }
        else if(p1.degree < p2.degree)
        {
            result = new polynomial(p2.degree);
            for(int i=0;i<p2.degree+1;i++)
            {
                if(i>p1.degree)
                {
                    result.poly[i] = p2.poly[i];
                }
                else
                {
                result.poly[i] = p1.poly[i] + p2.poly[i];
                }
            }
        }
        else
        {
            result = new polynomial(p1.degree);
            for(int i=0;i<p2.degree+1;i++)
            {
                result.poly[i] = p1.poly[i] + p2.poly[i];
            }   
        }
        
        System.out.println("Polynomial 1 = ");
        for(int i = p1.degree;i>=0;i--)
        {
            if(i==0)
            {
                System.out.printf(p1.poly[i]+"x^"+i);
                break;
            }
            
            if(p1.poly[i]!=0)
            {
                System.out.printf(p1.poly[i]+"x^"+i+" + ");
            }
            else{
                continue;
            }
        }
        System.out.println(" \n+ ");
        System.out.println("Polynomial 2 = ");
        for(int i = p2.degree;i>=0;i--)
        {
            if(i==0)
            {
                System.out.printf(p2.poly[i]+"x^"+i);
                break;
            }
            
            if(p2.poly[i]!=0)
            {
                System.out.printf(p2.poly[i]+"x^"+i+" + ");
            }
            else
            {
                continue;
            }
        }
        System.out.println(" \n= ");
        System.out.println("Resultant Polynomial after addition "+" = ");
        for(int i = result.degree;i>=0;i--)
        {
            if(i==0)
            {
                System.out.printf(result.poly[i]+"x^"+i);
                break;
            }
            if(result.poly[i]!=0)
            {
                System.out.printf(result.poly[i]+"x^"+i+" + ");
            }
            else
            {
                continue;
            }
        }   
    }
    
    public void polySubtraction()
    {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter Index of Polynomial 1 = ");
        String poly1 = obj.nextLine();
        System.out.println("Enter index of Polynomial 2 = ");
        String poly2 = obj.nextLine();
        
        polynomial result;
        
        int index1 = Integer.parseInt(poly1);
        int index2 = Integer.parseInt(poly2);
        int zero = 0;
        
        polynomial p1 = (polynomial)poly.get(index1);
        polynomial p2 = (polynomial)poly.get(index2);
        
        if(p1.degree > p2.degree)
        {
            result = new polynomial(p1.degree);
            for(int i=0; i<p1.degree+1;i++)
            {
                if(i>p2.degree)
                {
                    result.poly[i] = p1.poly[i];
                }
                else
                {
                result.poly[i] = p1.poly[i] - p2.poly[i];
                }
            }
        }
        else if(p1.degree < p2.degree)
        {
            result = new polynomial(p2.degree);
            for(int i=0;i<p2.degree+1;i++)
            {
                if(i>p1.degree)
                {
                    result.poly[i] = zero - p2.poly[i];
                }
                else
                {
                result.poly[i] = p1.poly[i] - p2.poly[i];
                }
            }
        }
        else
        {
            result = new polynomial(p1.degree);
            for(int i=0;i<p2.degree+1;i++)
            {
                result.poly[i] = p1.poly[i] - p2.poly[i];
            }   
        }
        
        System.out.println("Polynomial 1 = ");
        for(int i = p1.degree;i>=0;i--)
        {
            if(i==0)
            {
                System.out.printf(p1.poly[i]+"x^"+i);
                break;
            }
            if(p1.poly[i]!=0)
            {
                System.out.printf(p1.poly[i]+"x^"+i+" + ");
            }
            else
            {
                continue;
            }
        }
        System.out.println(" \n+ ");
        System.out.println("Polynomial 2 = ");
        for(int i = p2.degree;i>=0;i--)
        {
            if(i==0)
            {
                System.out.printf(p2.poly[i]+"x^"+i);
                break;
            }
            if(p2.poly[i]!=0)
            {
                System.out.printf(p2.poly[i]+"x^"+i+" + ");
            }
            else
            {
                continue;
            }
        }
        System.out.println(" \n= ");
        System.out.println("Resultant Polynomial after subtraction"+" = ");
        for(int i = result.degree;i>=0;i--)
        {
            if(i==0)
            {
                System.out.printf(result.poly[i]+"x^"+i);
                break;
            }
            if(result.poly[i]!=0)
            {
                System.out.printf(result.poly[i]+"x^"+i+" + ");
            }
            else
            {
                continue;
            }
        }
    }
    
    public void polyMultiplication()
    {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter Index of Polynomial 1 = ");
        String poly1 = obj.nextLine();
        System.out.println("Enter index of Polynomial 2 = ");
        String poly2 = obj.nextLine();
        
        polynomial result;
        polynomial resultant;
        int index1 = Integer.parseInt(poly1);
        int index2 = Integer.parseInt(poly2);
        int zero = 0;
        
        polynomial p1 = (polynomial)poly.get(index1);
        polynomial p2 = (polynomial)poly.get(index2);
        
        
        int size = (p1.poly.length+p2.poly.length)-1;
        result = new polynomial(size);
        
        System.out.println("Polynomial 1 = ");
        for(int i = p1.degree;i>=0;i--)
        {
            if(i==0)
            {
                System.out.printf(p1.poly[i]+"x^"+i);
                break;
            }
            if(p1.poly[i]!=0)
            {
                System.out.printf(p1.poly[i]+"x^"+i+" + ");
            }
            else
            {
                continue;
            }
        }
        System.out.println(" \n* ");
        System.out.println("Polynomial 2 = ");
        for(int i = p2.degree;i>=0;i--)
        {
            if(i==0)
            {
                System.out.printf(p2.poly[i]+"x^"+i);
                break;
            }
            if(p2.poly[i]!=0)
            {
                System.out.printf(p2.poly[i]+"x^"+i+" + ");
            }
            else
            {
                continue;
            }
        }
        
        System.out.println("\nResultant Polynomial after multiplication = ");
        for(int i=0;i<p1.poly.length;i++)
        {
            for(int j=0;j<p2.poly.length;j++)
            {
                result.poly[i+j] += p1.poly[i]*p2.poly[j];
                
            }
        }
        for(int i=0;i<size;i++)
        {
            //if(result.poly[i]==0)
            //{
                //continue;
            //}
            if(i==size-1)
            {
                System.out.printf(result.poly[i]+"x^"+i);
                break;
            }
            System.out.printf(result.poly[i]+"x^"+i+" + ");
            
            /*System.out.print(result.poly[i]);
            
            
            if(i!=0)
            {
                System.out.print("x^"+i);
                
            }
            if(i!=size-1)
            {
                System.out.print(" + ");
            }*/
        }
        
    }
}
