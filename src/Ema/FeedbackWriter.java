/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ema;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class FeedbackWriter implements Serializable{
    private int subscriberId;
    private String subscriberName;
    private String feedback;
    private int rating;
    
    public FeedbackWriter(int subscriberId, String subscriberName, String feedback, int rating) {
        this.subscriberId = subscriberId;
        this.subscriberName = subscriberName;
        this.feedback = feedback;
        this.rating = rating;
    }
    
    public boolean writeFeedback() {
        File f1 = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        try {
            f1 = new File("ContentFeedback.bin");
            if (f1.exists()) {
                fos = new FileOutputStream(f1, true);
                oos = new AppendObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(f1);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(this);
            oos.close();
            return true;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            try {
                if(oos != null) oos.close();
            } 
            catch (IOException e) {
            }
        }
    }
}

