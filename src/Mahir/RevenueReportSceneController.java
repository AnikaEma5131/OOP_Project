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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class RevenueReportSceneController implements Initializable {

    @FXML
    private TextField incomeTextField;
    @FXML
    private TextField costTextField;
    @FXML
    private Label profitLossLabel;
    @FXML
    private Label profitOutputLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void generateRevenueReportButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void calculateProfitButtonOnClicked(ActionEvent event) {
                        profitOutputLabel.setText(
                                  Integer.toString(
        Integer.parseInt(incomeTextField.getText())
                -
                Integer.parseInt(costTextField.getText())
                        )
                        );
    }
    
}
