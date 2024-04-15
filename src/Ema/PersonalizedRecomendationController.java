
package Ema;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class PersonalizedRecomendationController implements Initializable {


    @FXML
    private TextField manufActurerNAmeTextFEild;
    @FXML
    private TableView<Recommendation> productScTableview;
    @FXML
    private TableColumn<Recommendation, String> ManufacturerNameCOl;
    @FXML
    private TableColumn<Recommendation, LocalDate> dateOFManuFacture;
    @FXML
    private TableColumn<Recommendation, LocalDate> dateofexpiry;

    /**
     * Initializes the controller class.
     */
    private ObservableList<Recommendation> productData = FXCollections.observableArrayList();
    @FXML
    private DatePicker dateOfManufactureDatepicker;
    @FXML
    private DatePicker DateofExpiryDatePicker;
    @FXML
    private TextField ConNoTextFeild;
    @FXML
    private TextField ConnameTextFeild;
    @FXML
    private TextField ConPriceTExtFeild;
    @FXML
    private TableColumn<Recommendation, Integer>ConNoCol;
    @FXML
     private TableColumn<Recommendation, String> ConNAmeCol;
    @FXML
       private TableColumn<Recommendation, Float>  ConPriceCol;
    @FXML
    private Button goBackButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ConNoCol.setCellValueFactory(new PropertyValueFactory<>("conNo"));
        ConNAmeCol.setCellValueFactory(new PropertyValueFactory<>("conName"));
        ConPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        ManufacturerNameCOl.setCellValueFactory(new PropertyValueFactory<>("manuFacturerName"));
        dateOFManuFacture.setCellValueFactory(new PropertyValueFactory<>("DateOfManufacture"));
        dateofexpiry.setCellValueFactory(new PropertyValueFactory<>("DateOfExpiry"));
        // TODO
    }    

    @FXML
    private void loadDataToTableviewOnCDlick(ActionEvent event) {

        List<Object> objectList = Recommendation.readObjectsFromFile("Recommendation.bin");
        List<Recommendation> productList = new ArrayList<>();

        for (Object obj : objectList) {
            if (obj instanceof Recommendation) {
                Recommendation product = (Recommendation) obj;
                if (product.getPrice() < 500) {
                    productList.add(product);
                }
            }
        }
     productData.clear();
         // Add loaded data to the ObservableList
     productData.addAll(productList);
         // Set the items of the TableView
    productScTableview.setItems(productData);
    
}


    

    @FXML
    private void ConToBinFIle(ActionEvent event) {
        int conno;
        String name = ConnameTextFeild.getText();
        Float productPrice;
        String manufActurerNAme = manufActurerNAmeTextFEild.getText();
        LocalDate dateOFManuF;
        LocalDate dateofexpiryd;
            try {
                conno = Integer.parseInt(ConNoTextFeild.getText());
                if (!isconNumberUnique(conno)) {
                    showAlert(Alert.AlertType.ERROR, "Invalid Input", "Product number must be unique.");
                    return;
                }
            } catch (NumberFormatException e) {
                showAlert(Alert.AlertType.ERROR, "Invalid Input", "Product number must be a valid integer.");
                return;
            }
            
        try {
            productPrice = Float.valueOf(ConPriceTExtFeild.getText());
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "productPrice must be a valid floating-point number.");
            return;
        }
            dateOFManuF = dateOfManufactureDatepicker.getValue();
        if (dateOFManuF == null || dateOFManuF.isAfter(LocalDate.now())) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please select a valid Date of Manufacture.");
            return;
        }
        dateofexpiryd = DateofExpiryDatePicker.getValue();
        if (dateofexpiryd == null || dateofexpiryd.isBefore(dateOFManuF)) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please select a valid Date of Expiry.");
            return;
        }
        
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirmation");
        confirmationAlert.setHeaderText("Add New personalized content");
        confirmationAlert.setContentText("Are you sure you want to add this content?");
        confirmationAlert.showAndWait().filter(response -> response == ButtonType.OK).ifPresent(response -> {
                Recommendation newProduct = new Recommendation(conno,name,productPrice,manufActurerNAme,dateOFManuF,dateofexpiryd);
                boolean addStatus = Recommendation.addNewcon(newProduct, "Recommendation.bin");

                if (addStatus) {
                    showAlert(Alert.AlertType.INFORMATION, "Success", "New Recommendation Added Successfully!");
                    // Clear input fields after success
                    clearInputFields();
                } else {
                    showAlert(Alert.AlertType.ERROR, "Error", "Oops, something went wrong.");
                }
            });
    }
    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
    private void clearInputFields() {
        ConNoTextFeild.clear();
        ConnameTextFeild.clear();
        ConPriceTExtFeild.clear();
        manufActurerNAmeTextFEild.clear();
        dateOfManufactureDatepicker.setValue(null);
        DateofExpiryDatePicker.setValue(null);  
    }   
    
    //verification method
    private boolean isconNumberUnique(int productNumber) {
    for (Recommendation product : productData) {
        if (product.getProductNo() == productNumber) {
            return false; // Recommendation number is not unique
        }
    }
    return true; // Recommendation number is unique
    }

    @FXML
    private void goBackButtonOnClicked(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Content Manager Dashboard.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) goBackButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
