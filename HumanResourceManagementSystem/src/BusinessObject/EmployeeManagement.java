/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessObject;

import Entities.Employee;

import java.util.ArrayList;
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
    *   FOR EACH emp IN employeeList
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
}
