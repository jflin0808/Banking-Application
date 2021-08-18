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
public abstract class Tier {
    /**
     * 
     * @param c
     */
    public abstract void changeTier(Customer c);
    
    /**
     * 
     * @return
     */
    public abstract double getFee();
}
