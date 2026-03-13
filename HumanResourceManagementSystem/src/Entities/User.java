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
public abstract class User {

    String userId;
    String fullName;
    String department;
    String jobTitle;
    String departmentId;
    LocalDate dateOfJoining;
    double basicSalary;
    String employmentType;
    String status;

    public User() {
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public User(String id, String name, String dept, double salary) {
        this.userId = id;
        this.fullName = name;
        this.departmentId = dept;
        this.basicSalary = salary;
        this.status = "Active";
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
    public String getUserId() {
        return userId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDepartment() {
        return department;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    // - Setter
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public void updateInfo(String newName, double newSalary) {
        this.fullName = newName;
        this.basicSalary = newSalary;
        System.out.println("Đã cập nhật xong cho nhân viên: " + this.userId);
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Nhân viên: " + fullName + " - Phòng: " + department + " - Lương: " + calculateSalary();
    }


}
