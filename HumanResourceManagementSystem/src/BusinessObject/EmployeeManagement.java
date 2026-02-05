/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessObject;

import Entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author NGOMI
 */
public class EmployeeManagement {

    ArrayList<Employee> empList;

    // Method searchById() + Pseudocode
    /*
    * FUNCTION searchById(id)
    *   FOR EACH emp IN empList
    *       IF emp.employeeId = id
    *           RETURN emp
    *               RETURN null
    * END FUNCTION
    * */
    public Employee searchById(String id) {
        for (Employee emp : empList) {
            if (emp.getEmployeeId().equalsIgnoreCase(id)) {
                return emp;
            }
        }
        return null;
    }

    // Method updateEmployee() + Pseudocode
    /*
    * FUNCTION updateEmployee(id)
    *   emp <- searchById(id)
    *   IF emp = null
    *       PRINT "Employee not found"
    *       RETURN
    *   INPUT fullName
    *   INPUT basicSalary
    *   emp.fullName <- fullName
    *   emp.basicSalary <- basicSalary
    * END FUNCTION
    * */
    public void updateEmployee(String id) {
        Employee emp = searchById(id);

        if (emp == null) {
            System.out.println("Employee with id " + id + " not found");
            return;
        }
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter new full name: ");
        String fullName = sc.nextLine();

        System.out.print("Enter new basic salary: ");
        double salary = sc.nextDouble();

        emp.setFullName(fullName);
        emp.setBasicSalary(salary);

        System.out.println("Employee with id " + emp.getEmployeeId() + " updated successfully");
    }

    // Method deleteEmployee() + Pseudocode
    /*
    * FUNCTION deleteEmployee(id)
    *   emp <- searchById(id)
    *   IF emp = null
    *       PRINT "Employee not found"
    *       RETURN
    *   REMOVE emp FROM employeeList
    * END FUNCTION
    * */
    public void deleteEmployee(String id) {
        Employee emp = searchById(id);

        if (emp == null) {
            System.out.println("Employee with id " + id + " not found");
            return;
        }

        empList.remove(emp);
        System.out.println("Employee with id " + emp.getEmployeeId() + " deleted successfully");
    }

    /*
    * FUNCTION addEmployee()
    *   INPUT employeeId
    *
    *   emp <- searchById(employeeId)
    *   IF emp != null THEN
    *       PRINT "Employee with id already exists"
    *       RETURN
    *   END IF
    *
    *   INPUT fullName
    *   INPUT basicSalary
    *   INPUT department
    *
    *   newEmp <- new Employee(employeeId, fullName, department, basicSalary)
    *   ADD newEmp to empList
    *
    *   PRINT "Employee added successfully"
    * END FUNCTION
    * */
    public void addEmployee() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter employee ID: ");
        String employeeId = sc.nextLine();

        // Check if employee ID already exists
        Employee emp = searchById(employeeId);
        if (emp != null) {
            System.out.println("Employee with id " + employeeId + " already exists");
            return;
        }

        System.out.print("Enter full name: ");
        String fullName = sc.nextLine();

        System.out.print("Enter basic salary: ");
        double basicSalary = sc.nextDouble();

        System.out.print("Enter department: ");
        String department = sc.nextLine();

        Employee newEmp = new Employee(employeeId, fullName, department, basicSalary);
        empList.add(newEmp);

        System.out.println("Employee with id " + employeeId + " added successfully");
    }

    /*
    * FUNCTION displayAllEmployee()
    *   IF empList is empty THEN
    *       PRINT "No employees to display"
    *       RETURN
    *   END IF
    *
    *   PRINT "List of all employees"
    *
    *   FOR EACH emp IN empList
    *       PRINT emp
    *   END FOR
    * END FUNCTION
    * */
    public void displayAllEmployees() {
        if (empList.isEmpty()) {
            System.out.println("No employees to display");
            return;
        }

        System.out.println("===== List of all employees =====");
        for (Employee emp : empList) {
            System.out.println(emp);
        }
        System.out.println("================================");
    }
}
