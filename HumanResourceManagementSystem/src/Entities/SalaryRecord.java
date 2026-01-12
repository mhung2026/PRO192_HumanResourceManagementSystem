/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author NGOMI
 */
public class SalaryRecord {

    private String employeeId;
    private int month;
    private int year;
    private int workingDays;
    private int absenceDays;
    private int overtimeHours;
    private double totalSalary;

    public SalaryRecord() {
    }

    public SalaryRecord(String employeeId, int month, int year, int workingDays, int absenceDays, int overtimeHours, double totalSalary) {
        this.employeeId = employeeId;
        this.month = month;
        this.year = year;
        this.workingDays = workingDays;
        this.absenceDays = absenceDays;
        this.overtimeHours = overtimeHours;
        this.totalSalary = totalSalary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(int workingDays) {
        this.workingDays = workingDays;
    }

    public int getAbsenceDays() {
        return absenceDays;
    }

    public void setAbsenceDays(int absenceDays) {
        this.absenceDays = absenceDays;
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }
    public double caculatorSalary()
    {
        return 0;
    }
}
