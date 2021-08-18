/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jia Fei Lin
 */
public class CustomerController implements Initializable {
    public double amount = 0;
    @FXML
    public TextField Amount;
    @FXML
    public Label Balance;
    @FXML
    public Label Tier;
    
    /**
     * Returns to the starting Login GUI
     */
    @FXML
    public void logoutButton(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
    /**
     * Deposits amount entered in TextField into customer's account
     */
    @FXML
    public void depositButton() {
        try {
            amount = Double.parseDouble(Amount.getText());
            LoginController.customer.setBalance(amount + LoginController.customer.balance);
            LoginController.customer.tier.changeTier(LoginController.customer);
            Balance.setText(Double.toString(LoginController.customer.balance));
            Tier.setText(LoginController.customer.tier.toString());
        } catch (Exception e) {
            Balance.setText("Not a valid amount");
        }
    }   
    
    /**
     * Withdraws amount entered in TextField from customer's account
     */
    @FXML
    public void withdrawButton() {
        try{
            amount = Double.parseDouble(Amount.getText());
            if (LoginController.customer.balance < amount)
                Balance.setText("Not enough money");
            else{
                Balance.setText(Double.toString(LoginController.customer.balance -= amount));
                LoginController.customer.tier.changeTier(LoginController.customer);
                Tier.setText(LoginController.customer.tier.toString());
            }
        } catch (Exception e){
            Balance.setText("Not a valid amount");
            }
        
    }
    
    /**
     * Checks current balance of customer
     */
    @FXML
    public void balanceButton() {
         Balance.setText(Double.toString(LoginController.customer.balance));
         Tier.setText(LoginController.customer.tier.toString());
    }
    
    /**
     * Deducts amount entered in TextField from customer's account
     */
    @FXML 
    public void purchaseButton() {
        try{
            amount = Double.parseDouble(Amount.getText());
            if (amount >= 50){
                if (LoginController.customer.balance < amount + LoginController.customer.tier.getFee())
                    Balance.setText("Not enough money");
                else{
                    Balance.setText(Double.toString(LoginController.customer.balance -= (amount + LoginController.customer.tier.getFee())));
                    LoginController.customer.tier.changeTier(LoginController.customer);
                    Tier.setText(LoginController.customer.tier.toString());
                }
            }
            else 
                Balance.setText("Minimum $50");
        } catch (Exception e){
            Balance.setText("Not a valid amount");
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}