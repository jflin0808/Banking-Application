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
public class Silver extends Tier {
    public final double FEE = 20;
    
    /**
     * 
     * @param c 
     */
    @Override
    public void changeTier(Customer c){
        if(c.balance >= 10000 && c.balance <= 20000){
             c.setTier(new Gold());
        }
        if(c.balance >= 20000){
             c.setTier(new Platinum());
        }
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public double getFee(){
        return FEE;
    }
    
    /**
     * 
     * @return Silver
     */
    @Override
    public String toString() {
        return "Silver";
    }
    
}
