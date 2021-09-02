/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package polynomials;

/**
 *
 * @author Acer
 */
public class polynomial {
    public int[] poly;
    public int degree;
    
    public polynomial(int d)
    {
        degree = d;
        poly = new int[degree+1];
    }
}
