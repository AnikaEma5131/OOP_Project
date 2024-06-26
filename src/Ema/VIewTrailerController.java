/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Ema;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author EMA
 */
public class VIewTrailerController implements Initializable {

    @FXML
    private ComboBox<String> titleComboBox;
    @FXML
    private MediaView mediaview;
    @FXML
    private Button goBackButton;
   
    private List<VideoInfo> videoInfoList;
    private MediaPlayer mediaPlayer;
    private static final String VIDEOS_FOLDER = "videos";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadVideoTitles();
    }    
    
    private void loadVideoTitles() {
        videoInfoList = new ArrayList<>();
        File folder = new File(VIDEOS_FOLDER);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".bin"));
        if (files != null) {
            for (File file : files) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                    VideoInfo videoInfo = (VideoInfo) ois.readObject();
                    videoInfoList.add(videoInfo);
                    titleComboBox.getItems().add(videoInfo.getTitle());
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    
    
    @FXML
    private void selectVideoTitle(ActionEvent event) {
        String selectedTitle = titleComboBox.getValue();
        if (selectedTitle != null) {
            for (VideoInfo videoInfo : videoInfoList) {
                if (videoInfo.getTitle().equals(selectedTitle)) {
                    playVideo(videoInfo);
                    break;
                }
            }
        }
    }

    @FXML
    private void playButtonOnClick(ActionEvent event) {
        if (mediaPlayer != null) {
        mediaPlayer.play();
    }
    }

    @FXML
    private void stopButtonOnClick(ActionEvent event) {
        if (mediaPlayer != null) {
        mediaPlayer.stop();
    }
    }

    @FXML
    private void ResumeButtonClick(ActionEvent event) {
        if (mediaPlayer != null) {
        if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
            mediaPlayer.pause();
        } else {
            mediaPlayer.play();
        }
    }
    }
    

    @FXML
    private void goBackButtonOnClicked(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SubscriberDashboard.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) goBackButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    private void playVideo(VideoInfo videoInfo) {
        try {
            File tempFile = File.createTempFile("temp", ".bin");
            tempFile.deleteOnExit();
            FileOutputStream fos = new FileOutputStream(tempFile);
            fos.write(videoInfo.getVideoData());
            fos.close();
            Media media = new Media(tempFile.toURI().toString());
            if (mediaPlayer != null) {
                mediaPlayer.dispose();
            }
            mediaPlayer = new MediaPlayer(media);
            mediaview.setMediaPlayer(mediaPlayer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


