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
public class Attendance {

    private String employeeId;
    private LocalDate date;
    private String status; // Present / Absent
    private int overtimeHours;

    public Attendance() {
    }

    public Attendance(String employeeId, LocalDate date, String status, int overtimeHours) {
        this.employeeId = employeeId;
        this.date = date;
        this.status = status;
        this.overtimeHours = overtimeHours;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public boolean isPresent() {
        return "Present".equalsIgnoreCase(status);
    }

    public boolean isAbsent() {
        return "Absent".equalsIgnoreCase(status);
    }

    @Override
    public String toString() {
        return "Attendance{"
                + "employeeId='" + employeeId + '\''
                + ", date=" + date
                + ", status='" + status + '\''
                + ", overtimeHours=" + overtimeHours
                + '}';
    }

}
