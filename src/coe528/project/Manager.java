/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Jia Fei Lin
 */
public class Manager {
    static Manager m;
    static ArrayList<Customer> customers = new ArrayList<Customer>();
    
    public Manager(){
        
    }
    
    public boolean createCustomer(String user, String pass, double bal) {
        boolean test = false;
        for (Customer c : customers){
            if (c.username.equals(user)){
                System.out.println("Username has been taken");
                return false;
            }
            else
                test = true;
        }

    try{
        if (test = true){
            customers.add(new Customer(user, bal));
            File f = new File (user + ".txt");
            f.createNewFile();
            PrintWriter pw = new PrintWriter(f);
            pw.println(pass);
            pw.close();
        }
        }catch (IOException e){
            System.out.println("Error has occured"); }
    return test;
    }
    
    public boolean deleteCustomer(String user) {
        for (Customer c : customers){
            if (c.username.equals(user)){
                customers.remove(new Customer(user));
                return true;
            }

        }
        return false;
    }
}
