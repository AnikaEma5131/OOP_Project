/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mahir;

/**
 *
 * @author User
 */
public class Bill {
    private String date;
    private Integer amount;
    private Boolean ifPaid;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Boolean getIfPaid() {
        return ifPaid;
    }

    public void setIfPaid(Boolean ifPaid) {
        this.ifPaid = ifPaid;
    }

    public Bill(String date, Integer amount, Boolean ifPaid) {
        this.date = date;
        this.amount = amount;
        this.ifPaid = ifPaid;
    }
    
    
}
