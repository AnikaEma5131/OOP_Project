/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Ema;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.media.MediaView;

/**
 * FXML Controller class
 *
 * @author EMA
 */
public class VIewTrailerController implements Initializable {

    @FXML
    private ComboBox<?> titleComboBox;
    @FXML
    private MediaView mediaview;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void selectVideoTitle(ActionEvent event) {
    }

    @FXML
    private void playButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void stopButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void ResumeButtonClick(ActionEvent event) {
    }
    
}
