/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessObject;

import DataObjects.DepartmentDAO;
import Entities.User;
import Entities.Department;
import DataObjects.EmployeeDAO;
import Entities.Employee;
import Utilities.DataInput;
import Utilities.DataValidation;

import java.util.ArrayList;

/**
 *
 * @author NGOMI
 */
public class EmployeeManagement {

    ArrayList<User> empList = new ArrayList<>();
    ArrayList<Department> depList = new ArrayList<>();
    private final EmployeeDAO dao = new EmployeeDAO();
    private final DepartmentDAO daoDepartment = new DepartmentDAO();

    public EmployeeManagement() {
        if (this.empList.isEmpty() || this.empList == null) {
            this.empList = (ArrayList<User>) dao.loadFromFile();
        }
        if (this.empList == null) {
            this.empList = new ArrayList<>();
        }
        if (this.depList.isEmpty() || this.depList == null) {
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
    public User searchById(String id) {
        for (User emp : empList) {
            if (emp.getUserId().equalsIgnoreCase(id)) {
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
    *       PRINT "User not found"
    *       RETURN
    *   INPUT fullName
    *   INPUT basicSalary
    *   emp.fullName <- fullName
    *   emp.basicSalary <- basicSalary
    * END FUNCTION
    * */
    public void updateEmployee(String id) {
        User emp = searchById(id);

        if (emp == null) {
            System.out.println("Employee with id " + id + " not found");
            return;
        }
        String fullName = DataInput.getString("Enter new full name: ");
        double salary = 0; 
        while (true) {
            salary = DataInput.getDouble("Enter new basic salary: ");
            if (DataValidation.isValidSalary(salary)) {
                break;
            }
            System.out.println("Salary is a positive number");
        }
        emp.setFullName(fullName);
        emp.setBasicSalary(salary);
        System.out.println("Employee with id " + emp.getUserId() + " updated successfully");
    }

    // Method deleteEmployee() + Pseudocode
    /*
    * FUNCTION deleteEmployee(id)
    *   emp <- searchById(id)
    *   IF emp = null
    *       PRINT "User not found"
    *       RETURN
    *   REMOVE emp FROM employeeList
    * END FUNCTION
    * */
    public void deleteEmployee(String id) {
        User emp = searchById(id);

        if (emp == null) {
            System.out.println("Employee with id " + id + " not found");
            return;
        }

        empList.remove(emp);
        System.out.println("Employee with id " + emp.getUserId() + " deleted successfully");
    }

    /*
    * FUNCTION addEmployee()
    *   INPUT userId
    *
    *   emp <- searchById(userId)
    *   IF emp != null THEN
    *       PRINT "User with id already exists"
    *       RETURN
    *   END IF
    *
    *   INPUT fullName
    *   INPUT basicSalary
    *   INPUT department
    *
    *   newEmp <- new User(userId, fullName, department, basicSalary)
    *   ADD newEmp to empList
    *
    *   PRINT "User added successfully"
    * END FUNCTION
    * */
    public void addEmployee() {

        String userId = DataInput.getString("Enter employee ID: ");
        if (!DataValidation.isUserIdUnique(userId, empList)) {
            System.out.println("Employee with id " + userId + " already exists");
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
        User newEmp = new Employee(userId, fullName, departmentId, basicSalary) {
            
        };
        empList.add(newEmp);

        System.out.println("Employee with id " + userId + " added successfully");

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
        for (User emp : empList) {
            Department dept = getDepartmentById(emp.getDepartmentId());
            String deptName = (dept != null) ? dept.getDepartmentName() : "Unknown";
            System.out.printf("ID: %s | Tên: %s | Phòng: %s | Lương: %.2f\n",
                    emp.getUserId(),
                    emp.getFullName(),
                    deptName,
                    emp.getBasicSalary());
        }
        System.out.println("================================");
    }
}
