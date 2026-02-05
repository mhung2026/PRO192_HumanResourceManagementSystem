/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessObject;

import DataObjects.DepartmentDAO;
import Entities.Employee;
import Entities.Department;
import DataObjects.EmployeeDAO;
import Utilities.DataInput;
import Utilities.DataValidation;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author NGOMI
 */
public class EmployeeManagement {

    ArrayList<Employee> empList = new ArrayList<Employee>();
    ArrayList<Department> depList = new ArrayList<Department>();
    private EmployeeDAO dao = new EmployeeDAO();
    private DepartmentDAO daoDepartment = new DepartmentDAO();

    public EmployeeManagement() {
        if (this.empList.isEmpty()) {
            this.empList = (ArrayList<Employee>) dao.loadFromFile();
        }
        if (this.empList == null) {
            this.empList = new ArrayList<>();
        }
        if (this.depList.isEmpty()) {
            this.depList = (ArrayList< Department>) daoDepartment.loadFromFile();
        }
        if (this.depList == null) {
            this.depList = new ArrayList<>();
        }
    }

    public void saveToFile() {
        dao.saveToFile(empList);
        daoDepartment.saveToFile(depList);
    }

    public Department getDepartmentById(String id) {
        for (Department dep : depList) {
            if (dep.getDepartmentId().equalsIgnoreCase(id)) {
                return dep;
            }
        }
        return null;
    }

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
        String fullName = DataInput.getString("Enter new full name: ");
        double salary = DataInput.getDouble("Enter new basic salary: ");
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

        String employeeId = DataInput.getString("Enter employee ID: ");
        if (!DataValidation.isEmployeeIdUnique(employeeId, empList)) {
            System.out.println("Employee with id " + employeeId + " already exists");
            return;
        }
        String fullName = DataInput.getString("Enter full name: ");
        double basicSalary = 0;
        while (true) {
            basicSalary = DataInput.getDouble("Enter salary: ");
            if (DataValidation.isValidSalary(basicSalary)) {
                break;
            }
            System.out.println("Salary is a positive number");
        }
        String departmentId = "";
        while (true) {
            departmentId = DataInput.getString("Enter department id: ");
            if (DataValidation.isDepartmentIdExists(departmentId, depList)) {
                break;
            }
            System.out.println("Department with id " + departmentId + " does not exists");
        }
        Employee newEmp = new Employee(employeeId, fullName, departmentId, basicSalary);
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
            Department dept = getDepartmentById(emp.getDepartmentId());
            String deptName = (dept != null) ? dept.getDepartmentName() : "Unknown";
            System.out.printf("ID: %s | Tên: %s | Phòng: %s | Lương: %.2f\n",
                    emp.getEmployeeId(),
                    emp.getFullName(),
                    deptName,
                    emp.getBasicSalary());
        }
        System.out.println("================================");
    }
}
