/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Ema;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author EMA
 */

//abcd i am pok ema
public class ContentManagerDashboardController implements Initializable {

    @FXML
    private Label premiumcustomercountLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                try {
   
            File file = new File("Premium SubscriberLoginInfo.bin");

     
            if (!file.exists()) {
                premiumcustomercountLabel.setText("0");
                return;
            }

  
            int count = countLines(file);


            premiumcustomercountLabel.setText(Integer.toString(count));
        } catch (IOException ex) {
            ex.printStackTrace();
         
        }
    }

    private int countLines(File file) throws IOException {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.readLine() != null) {
                count++;
            }
        }
        return count;
    
    }
    
}
