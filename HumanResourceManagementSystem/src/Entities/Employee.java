/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import BusinessObject.EmployeeManagement;
import DataObjects.DepartmentDAO;
import java.time.LocalDate;

/**
 *
 * @author NGOMI
 */
public abstract class Employee {
    String employeeId;      
    String fullName;        
    String department;      
    String jobTitle;       
    LocalDate dateOfJoining;
    double basicSalary;
    String employmentType;
    String status;

    public Employee() {};

    public Employee(String id, String name, String dept, double salary) {
        this.employeeId = id;
        this.fullName = name;
        this.departmentId = dept;
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

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
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

    // - Getter
    public String getEmployeeId() {return employeeId;}
    public String getFullName() {return fullName;}
    public String getDepartment() {return department;}
    public double getBasicSalary() {return basicSalary;}

    // - Setter
    public void setFullName(String fullName) {this.fullName = fullName;}
    public void setBasicSalary(double basicSalary) {this.basicSalary = basicSalary;}

    public void updateInfo(String newName, double newSalary) {
        this.fullName = newName;
        this.basicSalary = newSalary;
        System.out.println("Đã cập nhật xong cho nhân viên: " + this.employeeId);
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Nhân viên: " + fullName + " - Phòng: " + department + " - Lương: " + calculateSalary();
    }


}
