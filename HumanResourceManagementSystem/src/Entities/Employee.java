/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.time.LocalDate;

/**
 *
 * @author NGOMI
 */
public class Employee {
    String employeeId;      
    String fullName;        
    String department;      
    String jobTitle;       
    LocalDate dateOfJoining;
    double basicSalary;     
    String employmentType;  
    String status;

    public Employee(String id, String name, String dept, double salary) {
        this.employeeId = id;
        this.fullName = name;
        this.department = dept;
        this.basicSalary = salary;
        this.status = "Đang làm việc"; 
    }

 
    public void updateInfo(String newName, double newSalary) {
        this.fullName = newName;
        this.basicSalary = newSalary;
        System.out.println("Đã cập nhật xong cho nhân viên: " + this.employeeId);
    }

    @Override
    public String toString() {
        return "Nhân viên: " + fullName + " - Phòng: " + department + " - Lương: " + basicSalary;
    }
}
