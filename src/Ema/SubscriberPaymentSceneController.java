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

        // Assuming you have a method to update payment status in your model
        // For example:
        // updatePaymentStatus(month, amount);

        // Add the payment to payment history
        SubscriptionPayment payment = new SubscriptionPayment(month, amount, "Paid");
        paymentHistory.add(payment);
        PaymentHistoryTableView.setItems(paymentHistory);
    }


    @FXML
    private void GoBackButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void showPaymentHistoryOnClick(ActionEvent event) {
        PaymentHistoryTableView.setItems(getPaymentHistory());
    }

    private ObservableList<SubscriptionPayment> getPaymentHistory() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
