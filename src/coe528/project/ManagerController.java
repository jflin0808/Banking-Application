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
public class ManagerController implements Initializable {
    protected Manager m = new Manager(); 
    static double amount = 0;
    double balance = 0;
    
    @FXML
    private TextField Password;
    
    @FXML
    private TextField Username;
    
    @FXML
    private TextField Amount;
    
    @FXML 
    private Label prompt;
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
     * adds customer username and password to a text file
     */
    @FXML
    public void addCustomerButton(){
        try {
            balance = Double.parseDouble(Amount.getText());
            if (balance < 100)
                prompt.setText("Please enter at least $100");
            else{
                if (m.createCustomer(Username.getText(), Password.getText(), balance)){
                    prompt.setText("Customer added with $" + Amount.getText());
                }
            else {
                prompt.setText("Username already taken, please try again");
            }
            }
        } catch (Exception e) {
                    prompt.setText("Please enter a valid amount");
        }
    }
    /**
     * delete customer text file containing their username and password
     */
    @FXML
    public void deleteCustomerButton(){
        if (m.deleteCustomer(Username.getText()))
            prompt.setText(Username.getText() + " has been successfully deleted");
        else
            prompt.setText(Username.getText() + " does not exist");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
