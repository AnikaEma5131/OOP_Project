/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Mahir;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ManagingInvoiceSceneController implements Initializable {

    @FXML
    private Label writeTemplateInvoiceLabel;
    @FXML
    private TextField writeTemplateInvoiceTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void saveInvoiceButtonOnClicked(ActionEvent event) {
        writeTemplateInvoiceLabel.setText(writeTemplateInvoiceTF.getText());
    }
    
}
