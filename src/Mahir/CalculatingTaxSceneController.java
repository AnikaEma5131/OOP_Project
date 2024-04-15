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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class CalculatingTaxSceneController implements Initializable {

    @FXML
    private TextField revenueTextField;
    @FXML
    private Label taxAmountLabel;
    @FXML
    private Label beforeTaxLabel;
    @FXML
    private Label afterTaxLabel;
    @FXML
    private TextField taxRateTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void calculateTaxButtonOnClick(ActionEvent event) {
                beforeTaxLabel.setText(
                Integer.toString(
                Integer.parseInt(revenueTextField.getText())
                        
                          )
                          
                );
                        taxAmountLabel.setText(
                Integer.toString(
                (Integer.parseInt(revenueTextField.getText())
                        *
                  Integer.parseInt(taxRateTextField.getText()))
                        /100
                  
                          )
                          
                );
                afterTaxLabel.setText(
                Integer.toString(
                Integer.parseInt(revenueTextField.getText())
                        -
                (Integer.parseInt(revenueTextField.getText())
                        *
                  Integer.parseInt(taxRateTextField.getText()))
                        /100
                  
                          )
                          
                );        
               
    }
    
}
