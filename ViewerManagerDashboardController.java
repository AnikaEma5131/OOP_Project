/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Tasdid;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author EMA
 */
public class ViewerManagerDashboardController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   @FXML
    private void manageviewerOnAction(ActionEvent event) {
        switchScene("VMScene1.fxml", event);
    }

    @FXML
    private void cotentOnAction(ActionEvent event) {
        switchScene("VMScene3.fxml",event);
         
    }

    @FXML
    private void subscriptionOnAction(ActionEvent event) {
    }

    @FXML
    private void securityOnAction(ActionEvent event) {
    }

    @FXML
    private void dataanalysisOnAction(ActionEvent event) {
    }

    @FXML
    private void communicationOnAction(ActionEvent event) {
    }

    @FXML
    private void thirdpartyOnAction(ActionEvent event) {
    }

    @FXML
    private void configerationOnAction(ActionEvent event) {
    }

    @FXML
    private void logoutOnAction(ActionEvent event) {
        
       switchScene("/mainPkg/LoginSc.fxml",event);
    }    
    
    private void switchScene(String sceneFXML, ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(sceneFXML));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
