/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**
 * 
 * @author Jia Fei Lin
 */
public class Platinum extends Tier{
    
    // Overview: A user creates a bank account and is given a tier
    // ranging from silver to platinum. If user's balance is less than 10000, they will be
    // demoted to silver, if it is between 10000 and 20000 they will be demoted to gold
    // Platinum class is immutable.
    
    // AF(c) = A bank account B
    //         where balance = c.balance
    //               balance = sum of all withdraws, deposits and purchases
    //
    
    // RI(c) = true if ((c.balance >0 AND c.balance = (double)c.balance
    //         = false otherwise
    
    
    public final double FEE = 0;
    static double balance;
    
    /**
     * 
     * @param c 
     */
    @Override
    public void changeTier(Customer c){
        balance = c.balance;
        if(c.balance < 10000)
            c.setTier(new Silver());
        if(c.balance >= 10000 && c.balance < 20000)
            c.setTier(new Gold());
    }
    
    /**
     * 
     * @return FEE
     */
    @Override
    public double getFee(){
        return FEE;
    }
    
    /**
     * 
     * @return Platinum
     */
    @Override
    public String toString() {
        return "Platinum";
    }
    /**
     * Return true if balance is greater than 0 and balance is a double
     * Return false otherwise
     * @return 
     */
    public boolean repOK() {
        if (balance > 0 && balance == (double)balance)
            return true;
        return false;
    }
}
