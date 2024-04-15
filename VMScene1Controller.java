/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Tasdid;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class VMScene1Controller implements Initializable {

    @FXML
    private TextField usernameTF;
    @FXML
    private TextField useridTF;
    @FXML
    private TextField useremailTF;
    @FXML
    private ComboBox<?> subscriptiontierCB;
    @FXML
    private TableView<?> userinfoTV;
    @FXML
    private TableColumn<?, ?> usernameTC;
    @FXML
    private TableColumn<?, ?> useridTC;
    @FXML
    private TableColumn<?, ?> emailTC;
    @FXML
    private TableColumn<?, ?> subscriptionTC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void adduserOnAction(ActionEvent event) {
    }

    @FXML
    private void removeuserOnAction(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VMScene2.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @FXML
    private void ShowviewerreportOnAction(ActionEvent event) {
    }

    @FXML
    private void returnbuttonOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Viewer Manager Dashboard.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
}
        }
    
}