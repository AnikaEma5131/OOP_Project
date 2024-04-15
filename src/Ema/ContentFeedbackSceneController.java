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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Jasper
 */
public class ContentFeedbackSceneController implements Initializable {

    @FXML
    private TextField customerIDTextField;
    @FXML
    private TextField customerNameTextField;
    @FXML
    private Button goBackButton;
    @FXML
    private ComboBox<Integer> ratingComboBox;
    @FXML
    private TextArea feedbackTextArea;
    
    Alert anInfAlert = new Alert(Alert.AlertType.CONFIRMATION);
    Alert anError = new Alert(Alert.AlertType.ERROR);

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ratingComboBox.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10);
        ratingComboBox.setValue(0);
    }    

    @FXML
    private void goBackButtonOnClicked(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("View paid contents.fxml"));
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
        if(customerIDTextField.getText().isEmpty()||feedbackTextArea.getText().isEmpty()) {
            anError.setContentText("Please input all feilds before submitting");
            anError.show();
        }
        else{
            if(Content.giveFeedback(Integer.parseInt(customerIDTextField.getText()), customerNameTextField.getText(), feedbackTextArea.getText(), ratingComboBox.getValue())) {
                anInfAlert.setContentText("Feedback successfully submitted");
                anInfAlert.show();
                Stage newStage = new Stage();
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("ContentFeedbackScene.fxml"));
                    Scene thisScene = new Scene(root);
                    Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
                    stg.setScene(thisScene);
                    stg.close();
                }
                catch(Exception e) {
                    System.out.println(e);
                }
            }
            else {
                anError.setContentText("Something went wrong. Try again.");
                anError.show();
            }
        }
    }
    
}
