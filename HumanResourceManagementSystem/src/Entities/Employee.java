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
public class Employee extends User {


    public Employee() {
    }

    public Employee(String id, String name, String departmentId, double allowance) {
        super(id, name, departmentId, 0);
    }

    @Override
    public double calculateSalary() {
        return 0;
    }

    @Override
    public String toString() {
        return "Nhân viên: " + fullName + " - Phòng: " + department + " - Lương: " + calculateSalary();
    }
}
