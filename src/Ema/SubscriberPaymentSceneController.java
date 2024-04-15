/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Ema;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author EMA
 */
public class SubscriberPaymentSceneController implements Initializable {

    @FXML
    private ComboBox<String> monthCombobox;
    @FXML
    private TableView<SubscriptionPayment> PaymentHistoryTableView;
    @FXML
    private TableColumn<SubscriptionPayment, String> MonthTableCol;
    @FXML
    private TableColumn<SubscriptionPayment, String> AmountTableCol;
    @FXML
    private TableColumn<SubscriptionPayment, String> PStatusTableCol;
    @FXML
    private TextField AmountTextField;
    
    private ObservableList<SubscriptionPayment> paymentHistory = FXCollections.observableArrayList();
    @FXML
    private Button goBackButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        monthCombobox.getItems().addAll("January", "February", "March", "April", "May", "June","July", "August", "September", "October", "November", "December");
        MonthTableCol.setCellValueFactory(new PropertyValueFactory<>("month"));
        AmountTableCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        PStatusTableCol.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @FXML
    private void MakePaymentOnClick(ActionEvent event) {
        
        String month = monthCombobox.getValue();
        double amount = Double.parseDouble(AmountTextField.getText());
        SubscriptionPayment payment = new SubscriptionPayment(month, amount, "Paid");
        paymentHistory.add(payment);
        
        showAlert(AlertType.INFORMATION, "Payment Successful", "Payment of $" + amount + " for " + month + " has been successfully made.");
        //PaymentHistoryTableView.setItems(paymentHistory);
    }


    @FXML
    private void GoBackButtonOnClick(ActionEvent event) {
        
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
    private void showPaymentHistoryOnClick(ActionEvent event) {
        
        //SubscriptionPayment.loadPaymentHistory("payment_history.bin");
        //paymentHistory = FXCollections.observableArrayList(SubscriptionPayment.getPaymentHistory());
        PaymentHistoryTableView.setItems(paymentHistory);
    }

    private ObservableList<SubscriptionPayment> getPaymentHistory() {
        return paymentHistory;
    }
    
    private void showAlert(AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void downloadpdfOnClick(ActionEvent event) {
        
    }
}
