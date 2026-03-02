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
public class PartTimeEmployee extends Employee{
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee() {}

    public PartTimeEmployee(String id, String name, String departmentId,
                            double hourlyRate, int hoursWorked) {
        super(id, name, departmentId, 0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", PartTime{rate=%.2f, hours=%d}", hourlyRate, hoursWorked);
    }
}
