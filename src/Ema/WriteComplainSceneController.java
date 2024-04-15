/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Ema;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author EMA
 */
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
    private TableColumn<FeedbackManager.Feedback , String> customerIDCol;
    @FXML
    private TableColumn<FeedbackManager.Feedback , String> customerNameCol;
    @FXML
    private TableColumn<FeedbackManager.Feedback , String> typeOfComCol;
    @FXML
    private TableColumn<FeedbackManager.Feedback , String> writtenComCol;
    
    private FeedbackManager feedbackManager;
    private ObservableList<FeedbackManager.Feedback> feedbackHistory;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        feedbackManager = new FeedbackManager();
        
        typeOfComplainComboBox.getItems().addAll("Technical Issues", "Payment Issues", "Copyright Issues" ,"Others");
        customerIDCol.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        customerNameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        typeOfComCol.setCellValueFactory(new PropertyValueFactory<>("typeOfComplain"));
        writtenComCol.setCellValueFactory(new PropertyValueFactory<>("writtenComplain"));
    }    

    @FXML
    private void goBackButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void sendFeedBackOnCliked(ActionEvent event) {
        String customerID = customerIDTextField.getText();
        String customerName = customerNameTextField.getText();
        String typeOfComplain = typeOfComplainComboBox.getValue();
        String writtenComplain = writeComTextField.getText();

        feedbackManager.sendFeedback(customerID, customerName, typeOfComplain, writtenComplain);

        // Update TableView
        feedbackHistory.setAll(feedbackManager.getFeedbackHistory());
        
        showAlert(Alert.AlertType.INFORMATION, "Feedback Sent", "Your feedback has been successfully sent.");
    }

    @FXML
    private void showFeedbackOnClicked(ActionEvent event) {
        // Load feedback history from binary file
        feedbackManager.loadFeedbackHistory("feedback_history.bin");
        // Update feedback history TableView
        feedbackHistory = FXCollections.observableArrayList(feedbackManager.getFeedbackHistory());
        feedbackTableView.setItems(feedbackHistory);
    }

    @FXML
    private void loadCompChartOnClick(ActionEvent event) {
    }
    
    
    private void showAlert(Alert.AlertType type, String title, String message) {
    Alert alert = new Alert(type);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
}
    
}
