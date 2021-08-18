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

public class Customer  {
    public String username;
    public double balance;
    public static Tier tier;
    
    public Customer (String u){
        username = u;
    }
    
    public Customer (String u, double bal){
        username = u;
        balance = bal;
        if (balance >= 10000 && balance <20000)
            tier = new Gold();
        else if (balance > 20000)
            tier = new Platinum();
        else 
            tier = new Silver();
    }
    
    public Customer getCustomer(){
        return this;
    }
    /**
     * 
     * @param balance 
     */
    public void setBalance(double b){
        balance = b;
    }

    /**
     * 
     * @param t 
     */
    public void setTier(Tier t) {
        tier = t;
    }
    
    /**
     * 
     * @param amount 
     */
    public void deposit(double amount){
        balance += amount;
    }
    
    /**
     * 
     * @param amount 
     */
    public void withdraw(double amount){
        balance -= amount;
    }
    
    /**
     * 
     * @param cost 
     */
    public void purchase(double cost) {
        balance -= cost;
    } 
    
    @Override
    public String toString(){
        return username;
    }
    
}
