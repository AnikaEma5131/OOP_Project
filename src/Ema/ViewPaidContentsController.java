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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class ViewPaidContentsController implements Initializable {

    @FXML
    private ComboBox<String> titleComboBox;
    @FXML
    private MediaView mediaview;
    private List<VideoInfo> videoInfoList;
    private MediaPlayer mediaPlayer;
    private static final String VIDEOS_FOLDER = "videos";
    @FXML
    private Button goBackButton;
    @FXML
    private Button loadReivewInterfaceButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadVideoTitles();
    }
    private void downloadVideo(VideoInfo videoInfo) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Video");
            fileChooser.setInitialFileName(videoInfo.getTitle() + ".mp4");
            
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("MP4 files (*.mp4)", "*.mp4");
            fileChooser.getExtensionFilters().add(extFilter);

            File outputFile = fileChooser.showSaveDialog(null);
            
            if (outputFile != null) {
                FileOutputStream fos = new FileOutputStream(outputFile);
                fos.write(videoInfo.getVideoData());
                fos.close();
                System.out.println("Downloaded: " + outputFile.getAbsolutePath());
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    @FXML
    private void downloadButtonOnClick(ActionEvent event) {
        String selectedTitle = titleComboBox.getValue();
        if (selectedTitle != null) {
            for (VideoInfo videoInfo : videoInfoList) {
                if (videoInfo.getTitle().equals(selectedTitle)) {
                    downloadVideo(videoInfo);
                    break;
                }
            }
        }
    }

    @FXML
    private void LoadRatingInterfaceOnClick(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ContentFeedbackScene.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) loadReivewInterfaceButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
