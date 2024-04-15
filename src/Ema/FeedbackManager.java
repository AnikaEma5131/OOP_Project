/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ema;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EMA
 */
public class FeedbackManager implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Feedback> feedbackList;

    public FeedbackManager() {
        feedbackList = new ArrayList<>();
        loadFeedbackHistory("feedback_history.bin");
    }

    public void sendFeedback(String customerID, String customerName, String typeOfComplain, String writtenCom) {
        feedbackList.add(new Feedback(customerID, customerName, typeOfComplain, writtenCom));
        saveFeedbackHistory("feedback_history.bin");
    }

    public List<Feedback> getFeedbackHistory() {
        return feedbackList;
    }

    private void saveFeedbackHistory(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(feedbackList);
            System.out.println("Feedback history saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void loadFeedbackHistory(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            feedbackList = (List<Feedback>) ois.readObject();
            System.out.println("Feedback history loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static class Feedback implements Serializable {
        private static final long serialVersionUID = 1L;

        private String customerID;
        private String customerName;
        private String typeOfComplain;
        private String writtenComplain;

        public Feedback(String customerID, String customerName, String typeOfComplain, String writtenComplain) {
            this.customerID = customerID;
            this.customerName = customerName;
            this.typeOfComplain = typeOfComplain;
            this.writtenComplain = writtenComplain;
        }

        public String getCustomerID() {
            return customerID;
        }

        public String getCustomerName() {
            return customerName;
        }

        public String getTypeOfComplain() {
            return typeOfComplain;
        }

        public String getWrittenComplain() {
            return writtenComplain;
        }
    }
}
    

