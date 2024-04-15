/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Mahir;

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

/**
 * FXML Controller class
 *
 * @author User
 */
public class TechnicalAdministratorDashboardController implements Initializable {

    @FXML
    private Button userFeedbackButton;
    @FXML
    private Button userAnalyticsButton;
    @FXML
    private Button developmentProgressButton;
    @FXML
    private Button bugTrackingButton;
    @FXML
    private Button checkSecurityButton;
    @FXML
    private Button customerSupportButton;
    @FXML
    private Button checkInfastructureButton;
    @FXML
    private Button makeCrashReportButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void userFeedbackButtonOnClicked(ActionEvent event) {
                        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("userFeedbackScene.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) userFeedbackButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void userAnalyticsButtonOnClicked(ActionEvent event) {
        
    }

    @FXML
    private void developmentProgressButtonOnClicked(ActionEvent event) {
                                try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("developmentProgressScene.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) developmentProgressButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void bugTrackingButtonOnClicked(ActionEvent event) {
                                try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("bugTrackingScene.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) bugTrackingButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void checkSecurityButtonOnClicked(ActionEvent event) {
                                try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("checkingSecurityScene.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) checkSecurityButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void customerSupportButtonOnClicked(ActionEvent event) {
                                try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("customerSupportForTechnicalScene.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) customerSupportButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void checkInfastructureButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void makeCrashReportButtonOnClicked(ActionEvent event) {
    }
    }


