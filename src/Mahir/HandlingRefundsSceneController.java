/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author User
 */
public class HandlingRefundsSceneController implements Initializable {

    @FXML
    private TableView<?> customerIDRefundTableView;
    @FXML
    private TableColumn<?, ?> customerIDRefundTC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showLastInvoiceButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void grantRefundButtonOnClicked(ActionEvent event) {
    }
    
}