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
public class AccountantDashboardSceneController implements Initializable {

    @FXML
    private Button seeBillingHistoryButton;
    @FXML
    private Button makeRevenueReportButton;
    @FXML
    private Button calculateTaxButton;
    @FXML
    private Button paySalaryButton;
    @FXML
    private Button manageInvoiceButton;
    @FXML
    private Button analyzeTrialButton;
    @FXML
    private Button handleRefundButton;
    @FXML
    private Button seeSubsCountButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void seeBillingHistoryButtonOnClicked(ActionEvent event) {
                try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("viewBillingHistoryScene.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) seeBillingHistoryButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void makeRevenueReportButtonOnClicked(ActionEvent event) {
                try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("revenueReportScene.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) makeRevenueReportButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void calculateTaxButtonOnClicked(ActionEvent event) {
                        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("calculatingTaxScene.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) calculateTaxButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void paySalaryButtonOnClicked(ActionEvent event) {
                        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("paySalaryScene.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) paySalaryButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void manageInvoiceButtonOnClicked(ActionEvent event) {
                        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("managingInvoiceScene.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) manageInvoiceButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void analyzeTrialButtonOnClicked(ActionEvent event) {
                        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("analyzeTrial.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) analyzeTrialButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void seeSubsCountButtonOnClicked(ActionEvent event) {
                        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("subscriberCountScene.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) seeSubsCountButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleRefundButtonOnClicked(ActionEvent event) {
                        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("handlingRefundsScene.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) handleRefundButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}