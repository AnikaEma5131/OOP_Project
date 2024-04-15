/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Ema;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javafx.fxml.Initializable;

import javafx.scene.control.TextField;

import javafx.fxml.FXML;

import javafx.fxml.FXML;

public class WriteComplainSceneController implements Initializable {

    @FXML
    private TextField customerIDTextField;
    @FXML
    private TextField customerNameTextField;
    @FXML
    private TextField writeComTextField;
    @FXML
    private Button goBackButton;
    @FXML
    private ComboBox<String> typeOfComplainComboBox;
    @FXML
    private TableView<FeedbackManager.Feedback> feedbackTableView;
    @FXML
    private TableColumn<FeedbackManager.Feedback, String> customerIDCol;
    @FXML
    private TableColumn<FeedbackManager.Feedback, String> customerNameCol;
    @FXML
    private TableColumn<FeedbackManager.Feedback, String> typeOfComCol;
    @FXML
    private TableColumn<FeedbackManager.Feedback, String> writtenComCol;
    private PieChart complaintPieChart; // Initialize the PieChart here


    private FeedbackManager feedbackManager;
    private ObservableList<FeedbackManager.Feedback> feedbackHistory;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        feedbackManager = new FeedbackManager();
        typeOfComplainComboBox.getItems().addAll("Technical Issues", "Copy Write Content", "Others");

        customerIDCol.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        customerNameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        typeOfComCol.setCellValueFactory(new PropertyValueFactory<>("typeOfComplain"));
        writtenComCol.setCellValueFactory(new PropertyValueFactory<>("writtenComplain"));
        
        // Initialize the pie chart
        initializePieChart();
    }

    @FXML
    private void goBackButtonOnClicked(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SubscriberDashboard.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) goBackButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    @FXML
    private void sendFeedBackOnCliked(ActionEvent event) {
        String customerID = customerIDTextField.getText();
        String customerName = customerNameTextField.getText();
        String typeOfComplain = typeOfComplainComboBox.getValue();
        String writtenComplain = writeComTextField.getText();

        feedbackManager.sendFeedback(customerID, customerName, typeOfComplain, writtenComplain);

        // Update TableView
        //feedbackHistory.setAll(feedbackManager.getFeedbackHistory());
        showAlert(Alert.AlertType.INFORMATION,"Feedback sent","Your Feedback Has Been Successfully Sent , wait for our customer care survice to reach you out");
        
        // Update the pie chart
        initializePieChart();
    }
    
    private void showAlert(Alert.AlertType type , String title , String message){
        
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    
    }
    
    private void initializePieChart() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        // Count occurrences of each type of complaint
        Map<String, Integer> complaintCounts = new HashMap<>();
        for (FeedbackManager.Feedback feedback : feedbackManager.getFeedbackHistory()) {
            String typeOfComplaint = feedback.getTypeOfComplain();
            complaintCounts.put(typeOfComplaint, complaintCounts.getOrDefault(typeOfComplaint, 0) + 1);
        }

        // Add data to pie chart
        for (Map.Entry<String, Integer> entry : complaintCounts.entrySet()) {
            pieChartData.add(new PieChart.Data(entry.getKey(), entry.getValue()));
        }

        complaintPieChart.setData(pieChartData);
    }

    @FXML
    private void loadCompChartOnClick(ActionEvent event) {
        // Reload the pie chart
        initializePieChart();
    }



    @FXML
    private void showFeedbackOnClicked(ActionEvent event) {
        feedbackHistory.setAll(feedbackManager.getFeedbackHistory());
    }

    
}
