/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import Entities.Department;
import java.util.List;
import Entities.User;

/**
 *
 * @author NGOMI
 */
public class DataValidation {

    // 1. Kiểm tra mã nhân viên không trùng
    public static boolean isUserIdUnique(String id, List<User> list) {
        if (id == null) {
            return false;
        }
        for (User e : list) {
            if (id.equalsIgnoreCase(e.getUserId())) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDepartmentIdExists(String id, List<Department> list) {
        if (id == null) {
            return false;
        }
        for (Department e : list) {
            if (id.equalsIgnoreCase(e.getDepartmentId())) {
                return true;
            }
        }
        return false;
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
