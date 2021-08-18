/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Jia Fei Lin
 */
public class LoginController implements Initializable {
    
    BufferedReader br = null;
    ObservableList<String> userList = FXCollections.observableArrayList("Customer", "Manager");
    public final String USERNAME = "admin";
    public final String PASSWORD = "admin";
    
    static Manager manager = new Manager();
    static Customer customer; 
    
    @FXML
    public ChoiceBox Menu; 
    @FXML
    public Label prompt;
    @FXML
    public TextField Username;
    @FXML
    public PasswordField Password;
    
    @FXML
    public void initialize() {
        Menu.setValue("Customer");
        Menu.setItems(userList);
    }
    
    /**
     * User enters username and password, which then links to either the manager scene,
     * the customer scene or an error message depending on the input
     * @param event
     * @throws Exception 
     */
    
    @FXML
    public void loginButton(ActionEvent event) throws Exception {

        if (Menu.getValue()== "Manager"){
            if (Username.getText().equals(USERNAME) && Password.getText().equals(PASSWORD)){
                Parent root = FXMLLoader.load(getClass().getResource("Manager.fxml"));
                Scene scene = new Scene(root);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
            }
            else 
                prompt.setText("Incorrect Username or Password, Please try again");
        }
        if (Menu.getValue() == "Customer"){
            for (Customer c: manager.customers){
                if (Username.getText().equals(c.username)){
                    try {
                        br = new BufferedReader(new FileReader(c.username + ".txt"));
                        String input;
                        while ((input = br.readLine()) != null){
                            if (Password.getText().equals(input)){
                                customer = c;
                                Parent customerUIParent = FXMLLoader.load(getClass().getResource("Customer.fxml"));          
                                Scene customerUIScene = new Scene(customerUIParent);
                                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                                window.setScene(customerUIScene);
                                window.show();
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Please enter a valid password");}
                } 
            }
            prompt.setText("Incorrect Username or Password, please try again");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initialize();
    }    
    
}
