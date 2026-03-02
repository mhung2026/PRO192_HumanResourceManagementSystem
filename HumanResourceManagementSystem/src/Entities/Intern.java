/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author DELL
 */
public class Intern extends Employee{
     private double allowance;

    public Intern() {}

    public Intern(String id, String name, String departmentId, double allowance) {
        super(id, name, departmentId,0 );
        this.allowance = allowance;
    }

    public double calculateSalary() {
        return allowance;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Intern{allowance=%.2f}", allowance);
    }
}
