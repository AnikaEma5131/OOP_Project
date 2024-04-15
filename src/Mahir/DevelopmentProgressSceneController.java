/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class DevelopmentProgressSceneController implements Initializable {

    @FXML
    private TableView<?> taskTableView;
    @FXML
    private TableColumn<?, ?> upcomingTaskTC;
    @FXML
    private TableColumn<?, ?> ongoingTaskTC;
    @FXML
    private TableColumn<?, ?> completedTaskTC;
    @FXML
    private TextField taskDescriptionTextField;
    @FXML
    private Button addTaskButton;
    @FXML
    private Button editTaskButton;
    @FXML
    private Button updateTaskButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
