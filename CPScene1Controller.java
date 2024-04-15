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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class CPScene1Controller implements Initializable {

    @FXML
    private TextField contentnameTF;
    @FXML
    private TextField contenturlTF;
    @FXML
    private TextField contentidTF;
    @FXML
    private TableView<Content> contentinfoTV;
    @FXML
    private TableColumn<Content, String> contentnameTC;
    @FXML
    private TableColumn<Content, String> contenturlTC;
    @FXML
    private TableColumn<Content, Integer> contentidTC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void uploadbuttonOnAction(ActionEvent event) {
        String name = contentnameTF.getText();
    String url = contenturlTF.getText();
    
    // Assuming content ID is entered as an integer, parse it from text to int
    int id = Integer.parseInt(contentidTF.getText());
    
    // Populate the text fields with the retrieved information
    contentnameTF.setText(name);
    contenturlTF.setText(url);
    contentidTF.setText(String.valueOf(id));
       
    }
   



    @FXML
    private void returnbuttonOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ContentProviderDashboard.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
}
        }
    }

