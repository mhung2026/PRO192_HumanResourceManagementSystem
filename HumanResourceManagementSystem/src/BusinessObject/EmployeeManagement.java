/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessObject;

import Entities.Department;
import Entities.Employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author NGOMI
 */
public class EmployeeManagement {
    private ArrayList<Employee> employees;
    private Scanner scanner;
    private DateTimeFormatter dateFormatter;
    
    // Constructor
    public EmployeeManagement() {
        employees = new ArrayList<>();
        scanner = new Scanner(System.in);
        dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }
    
    // Hàm 1: Thêm nhân viên
    public void addEmployee() {
        System.out.println("\n=== THÊM NHÂN VIÊN MỚI ===");
        
        try {
            // Nhập Employee ID
            System.out.print("Nhập Employee ID: ");
            String employeeId = scanner.nextLine().trim();
            
            // Kiểm tra ID đã tồn tại chưa
            for (Employee emp : employees) {
                if (emp.getEmployeeId().equalsIgnoreCase(employeeId)) {
                    System.out.println("Lỗi: Employee ID đã tồn tại!");
                    return;
                }
            }
            
            // Nhập họ tên
            System.out.print("Nhập họ tên: ");
            String fullName = scanner.nextLine().trim();
            
            // Nhập thông tin phòng ban
            System.out.print("Nhập mã phòng ban: ");
            String deptId = scanner.nextLine().trim();
            System.out.print("Nhập tên phòng ban: ");
            String deptName = scanner.nextLine().trim();
            Department department = new Department(deptId, deptName);
            
            // Nhập chức vụ
            System.out.print("Nhập chức vụ: ");
            String jobTitle = scanner.nextLine().trim();
            
            // Nhập ngày vào làm
            System.out.print("Nhập ngày vào làm (dd/MM/yyyy): ");
            String dateInput = scanner.nextLine().trim();
            LocalDate dateOfJoining = LocalDate.parse(dateInput, dateFormatter);
            
            // Nhập lương cơ bản
            System.out.print("Nhập lương cơ bản: ");
            double basicSalary = Double.parseDouble(scanner.nextLine().trim());
            
            // Nhập loại hợp đồng
            System.out.print("Nhập loại hợp đồng (Full-time/Part-time/Contract): ");
            String employmentType = scanner.nextLine().trim();
            
            // Nhập trạng thái
            System.out.print("Nhập trạng thái (Đang làm việc/Nghỉ việc): ");
            String status = scanner.nextLine().trim();
            
            // Tạo đối tượng Employee mới
            Employee newEmployee = new Employee();
            newEmployee.setEmployeeId(employeeId);
            newEmployee.setFullName(fullName);
            newEmployee.setDepartment(department);
            newEmployee.setJobTitle(jobTitle);
            newEmployee.setDateOfJoining(dateOfJoining);
            newEmployee.setBasicSalary(basicSalary);
            newEmployee.setEmploymentType(employmentType);
            newEmployee.setStatus(status);
            
            // Thêm vào danh sách
            employees.add(newEmployee);
            
            System.out.println("✓ Đã thêm nhân viên thành công!");
            
        } catch (DateTimeParseException e) {
            System.out.println("Lỗi: Định dạng ngày không hợp lệ! Vui lòng nhập theo dd/MM/yyyy");
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Lương phải là số hợp lệ!");
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
    
    // Hàm 2: Hiển thị tất cả nhân viên
    public void displayAll() {
        System.out.println("\n=== DANH SÁCH TẤT CẢ NHÂN VIÊN ===");
        
        // Kiểm tra danh sách trống
        if (employees.isEmpty()) {
            System.out.println("Danh sách nhân viên trống!");
            return;
        }
        
        System.out.println("Tổng số nhân viên: " + employees.size());
        System.out.println("=".repeat(140));
        
        // In tiêu đề bảng
        System.out.printf("%-10s %-25s %-20s %-18s %-15s %-15s %-15s %-15s%n",
                         "ID", 
                         "Họ tên", 
                         "Phòng ban", 
                         "Chức vụ", 
                         "Ngày vào làm", 
                         "Lương cơ bản", 
                         "Loại hợp đồng", 
                         "Trạng thái");
        System.out.println("=".repeat(140));
        
        // In thông tin từng nhân viên
        for (Employee emp : employees) {
            String deptName = emp.getDepartment() != null 
                            ? emp.getDepartment().getDepartmentName() 
                            : "N/A";
            
            String dateStr = emp.getDateOfJoining() != null 
                           ? emp.getDateOfJoining().format(dateFormatter) 
                           : "N/A";
            
            String jobTitle = emp.getJobTitle() != null 
                            ? emp.getJobTitle() 
                            : "N/A";
            
            String empType = emp.getEmploymentType() != null 
                           ? emp.getEmploymentType() 
                           : "N/A";
            
            System.out.printf("%-10s %-25s %-20s %-18s %-15s %-15,.0f %-15s %-15s%n",
                             emp.getEmployeeId(),
                             emp.getFullName(),
                             deptName,
                             jobTitle,
                             dateStr,
                             emp.getBasicSalary(),
                             empType,
                             emp.getStatus());
        }
        
        System.out.println("=".repeat(140));
    }
    
    // Getter cho danh sách nhân viên
    public ArrayList<Employee> getEmployees() {
        return employees;
    }
}
