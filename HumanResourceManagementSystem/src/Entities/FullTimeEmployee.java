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
    public class FullTimeEmployee extends Employee {
    private double baseSalary;
    private double bonus;

    public FullTimeEmployee() {}

    public FullTimeEmployee(String id, String name, String departmentId,
                            double baseSalary, double bonus) {
        super(id, name, departmentId);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    public double getBaseSalary() { return baseSalary; }
    public double getBonus() { return bonus; }

    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }
    public void setBonus(double bonus) { this.bonus = bonus; }

    public double calculateSalary() {
        return baseSalary + bonus;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", FullTime{base=%.2f, bonus=%.2f}", baseSalary, bonus);
    }
}
