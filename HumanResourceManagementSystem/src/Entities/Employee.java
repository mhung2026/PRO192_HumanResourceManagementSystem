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
    private String employeeId;      
    private String fullName;        
    private String department;      
    private String jobTitle;       
    private LocalDate dateOfJoining;
    private double basicSalary;     
    private String employmentType;  
    private String status;

    public Employee() {
    }
    
        public Employee(String id, String name, String dept, double salary) {
        this.employeeId = id;
        this.fullName = name;
        this.department = dept;
        this.basicSalary = salary;
        this.status = "Đang làm việc"; 
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
