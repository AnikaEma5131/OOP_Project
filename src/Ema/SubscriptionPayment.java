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
public class SubscriptionPayment implements Serializable{
    private String month;
    private double amount;
    private String status;

    public SubscriptionPayment(String month, double amount, String status) {
        this.month = month;
        this.amount = amount;
        this.status = status;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    private List<SubscriptionPayment> paymentHistory = new ArrayList<>();

    public void updatePaymentStatus(String month, double amount) {
        // Find the payment for the given month and update its status
        for (SubscriptionPayment payment : paymentHistory) {
            if (payment.getMonth().equals(month)) {
                payment.setStatus("Paid");
                // Update any other relevant fields (e.g., amount)
                payment.setAmount(amount);
                return; // No need to continue searching
            }
        }
        // If the payment for the given month doesn't exist, add it
        paymentHistory.add(new SubscriptionPayment(month, amount, "Paid"));
        savePaymentHistory("payment_history.bin"); 
    }
    

    public List<SubscriptionPayment> getPaymentHistory() {
        // Return the payment history
        return paymentHistory;
    }
    
    public void savePaymentHistory(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(paymentHistory);
            System.out.println("Payment history saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadPaymentHistory(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            paymentHistory = (List<SubscriptionPayment>) ois.readObject();
            System.out.println("Payment history loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
