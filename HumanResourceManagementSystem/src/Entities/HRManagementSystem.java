/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.util.List;

/**
 *
 * @author NGOMI
 */
public class HRManagementSystem {

    private List<Employee> employees;
    private List<Attendance> attendances;
    private List<SalaryRecord> salaryRecords;

    public HRManagementSystem() {
    }

    public HRManagementSystem(List<Employee> employees, List<Attendance> attendances, List<SalaryRecord> salaryRecords) {
        this.employees = employees;
        this.attendances = attendances;
        this.salaryRecords = salaryRecords;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }

    public List<SalaryRecord> getSalaryRecords() {
        return salaryRecords;
    }

    public void setSalaryRecords(List<SalaryRecord> salaryRecords) {
        this.salaryRecords = salaryRecords;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void updateEmployee(String employeeId, Employee updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeId().equals(employeeId)) {
                employees.set(i, updatedEmployee);
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public void recordAttendance(Attendance attendance) {
        attendances.add(attendance);
    }

    public void caculatorSalary(SalaryRecord salaryRecord) {
        salaryRecord.caculatorSalary();
        salaryRecords.add(salaryRecord);
    }

}
