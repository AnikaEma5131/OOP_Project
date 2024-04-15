/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mahir;

/**
 *
 * @author User
 */
public class Salary {
    private Integer salaryAmount;
    private Integer salaryDue;
    private String salaryMonth;

    public Integer getSalaryAmount() {
        return salaryAmount;
    }

    public void setSalaryAmount(Integer salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    public Integer getSalaryDue() {
        return salaryDue;
    }

    public void setSalaryDue(Integer salaryDue) {
        this.salaryDue = salaryDue;
    }

    public String getSalaryMonth() {
        return salaryMonth;
    }

    public void setSalaryMonth(String salaryMonth) {
        this.salaryMonth = salaryMonth;
    }

    public Salary(Integer salaryAmount, Integer salaryDue, String salaryMonth) {
        this.salaryAmount = salaryAmount;
        this.salaryDue = salaryDue;
        this.salaryMonth = salaryMonth;
    }
    
}
