/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Ema;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SubscriberPaymentDashboardController implements Initializable {

    @FXML
    private Button backButton; 
    @FXML
    private Button paymentHistoryButton;
    @FXML
    private Button offersButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: Initialize your payment dashboard UI
    }    

    @FXML
    public void backButtonOnClicked(ActionEvent event) {
        try {
            // Load the home screen FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeScreen.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            
            // Get the current stage and set the scene to home screen
            Stage currentStage = (Stage) backButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Add more methods and event handlers as needed for your payment dashboard functionality

    @FXML
    private void showPaymentHistoryButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void showOffersButtonOnClicked(ActionEvent event) {
    }
}