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
 * @author User
 */
public class ContentProviderDashboardController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void uploadcontentOnAction(ActionEvent event) {
        switchScene("CPScene1.fxml", event);
    }

    @FXML
    private void paymentOnAction(ActionEvent event) {
        switchScene("CPScene3.fxml", event);
    }

    @FXML
    private void contentdeliveryOnAction(ActionEvent event) {
        switchScene("CPScene2.fxml", event);
    }

    @FXML
    private void contractmanagementOnAction(ActionEvent event) {
        switchScene("CPScene4.fxml", event);
    }

    @FXML
    private void marketingOnAction(ActionEvent event) {
        switchScene("CPScene5.fxml", event);
    }

    @FXML
    private void AudienceOnAction(ActionEvent event) {
        switchScene("CPScene6.fxml", event);
    }

    @FXML
    private void rightsOnAction(ActionEvent event) {
        switchScene("CPScene7.fxml", event);
    }

    @FXML
    private void feedbackOnAction(ActionEvent event) {
        switchScene("CPScene8.fxml", event);
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
