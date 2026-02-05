/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.util.List;
import Entities.Employee;

/**
 *
 * @author NGOMI
 */
public class DataValidation {
    // 1. Kiểm tra mã nhân viên không trùng
 public static boolean isEmployeeIdUnique(String id, List<Employee> list) {
    if (id == null) return false;
    for (Employee e : list) {
        if (id.equalsIgnoreCase(e.getEmployeeId())) {
            return false;
        }
    }
    return true;
}


    // 2. Kiểm tra lương không âm
    public static boolean isValidSalary(double salary) {
        return salary >= 0;
    }

    // 3. Kiểm tra tên không trống
    public static boolean isValidName(String name) {
        if (name == null) {
            return false;
        }
        return !name.trim().isEmpty();
    }
}
