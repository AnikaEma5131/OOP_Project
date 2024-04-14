/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ema;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cis101
 */
public class Recommendation implements Serializable{
    private Integer conNo;
    private String conName;
    private float price;
    private String manuFacturerName;
    private LocalDate DateOfManufacture;
    private LocalDate DateOfExpiry;

    public Recommendation(Integer conNo, String conName, float price, String manuFacturerName, LocalDate DateOfManufacture, LocalDate DateOfExpiry) {
        this.conNo = conNo;
        this.conName = conName;
        this.price = price;
        this.manuFacturerName = manuFacturerName;
        this.DateOfManufacture = DateOfManufacture;
        this.DateOfExpiry = DateOfExpiry;
    }

    public Integer getProductNo() {
        return conNo;
    }

    public void setProductNo(Integer productNo) {
        this.conNo = productNo;
    }

    public String getProductName() {
        return conName;
    }

    public void setProductName(String productName) {
        this.conName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getManuFacturerName() {
        return manuFacturerName;
    }

    public void setManuFacturerName(String manuFacturerName) {
        this.manuFacturerName = manuFacturerName;
    }

    public LocalDate getDateOfManufacture() {
        return DateOfManufacture;
    }

    public void setDateOfManufacture(LocalDate DateOfManufacture) {
        this.DateOfManufacture = DateOfManufacture;
    }

    public LocalDate getDateOfExpiry() {
        return DateOfExpiry;
    }

    public void setDateOfExpiry(LocalDate DateOfExpiry) {
        this.DateOfExpiry = DateOfExpiry;
    }

    @Override
    public String toString() {
        return "Product{" + "productNo=" + conNo + ", productName=" + conName + ", price=" + price + ", manuFacturerName=" + manuFacturerName + ", DateOfManufacture=" + DateOfManufacture + ", DateOfExpiry=" + DateOfExpiry + '}';
    }
    public static boolean writeObjectsToFile(List<Object> objects, String fileName) {
           try (FileOutputStream fos = new FileOutputStream(fileName);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
               for (Object obj : objects) {
                   oos.writeObject(obj);
               }
               return true;
           } catch (IOException ex) {
               ex.printStackTrace();
               return false;
           }
       }
 
    public static List<Object> readObjectsFromFile(String fileName) {
        List<Object> objects = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj != null) {
                        objects.add(obj);
                    } else {
                        break; // End of file reached
                    }
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return objects;
    }
       public static boolean addNewcon(Recommendation product, String fileName) {
           List<Object> products = readObjectsFromFile(fileName);
           products.add(product);
           return writeObjectsToFile(products, fileName);
       }
    

            
}
