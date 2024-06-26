/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Ema;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author EMA
 */
public class ContentManagerDashController implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private Label userName;
    @FXML
    private Button UploadContentsOnCLickButton;
    @FXML
    private Button RemoveConButton;
    @FXML
    private Button AdcertisementsButton;
    @FXML
    private Button perReecButton;
    @FXML
    private Button logoutt;
    @FXML
    private Label contentsCount;
    @FXML
    private Label subscriberCount;
    @FXML
    private TableView<?> uploadeedContentsTableview;
    @FXML
    private TableColumn<?, ?> uploadedContentsCol;
    @FXML
    private TableColumn<?, ?> dateUploadCil;
    @FXML
    private Button refreshCustomerfeedbacktableviewandPiChartOnClick;
    @FXML
    private TableView<?> deedbackTableView;
    @FXML
    private TableColumn<?, ?> userIDCOl;
    @FXML
    private TableColumn<?, ?> feedbackCol;
    @FXML
    private TableColumn<?, ?> ratingCol;
    @FXML
    private PieChart customerExpRatingPieChart;
    @FXML
    private TextField searchByUserID;
    @FXML
    private Button tablevireOnClick;
    @FXML
    private Button loadAllDataOnTAbleView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void bilingandsubmanagementOnClick(ActionEvent event) {
    }

    @FXML
    private void UpdatetermsAndPolicyMenuBarButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void viewcontentAvailibility(ActionEvent event) {
    }

    @FXML
    private void navigateToDashboard(ActionEvent event) {
    }

    @FXML
    private void UploadContentsOnCLick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Upload Contents.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) UploadContentsOnCLickButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void RemoveConOnClick(ActionEvent event) {
    }

    @FXML
    private void advButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void PerRecButtonOnClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Personalized Recomendation.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) UploadContentsOnCLickButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void LoadTableViewOnClick(ActionEvent event) {
    }

    @FXML
    private void saveUploadedContentRecordsAsPDF(ActionEvent event) {
    }

    @FXML
    private void logoutOnClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainPkg/LoginSc.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) logoutt.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
