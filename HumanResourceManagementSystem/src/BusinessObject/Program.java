/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessObject;

import DataObjects.EmployeeDAO;
import Utilities.DataInput;
import Utilities.Menu;

/**
 *
 * @author NGOMI
 */
public class Program {

    public static void main(String[] args) {
        Menu mainMenu = new Menu("QUẢN LÝ NHÂN SỰ");
        mainMenu.addOption("Thêm nhân viên mới");
        mainMenu.addOption("Hiển thị danh sách nhân viên");
        mainMenu.addOption("Tìm kiếm nhân viên theo ID");
        mainMenu.addOption("Cập nhật thông tin nhân viên");
        mainMenu.addOption("Xóa nhân viên");
        mainMenu.addOption("Lưu dữ liệu vào file");

        EmployeeManagement manager = new EmployeeManagement();
        int choice;
        do {
            mainMenu.display();
            choice = mainMenu.getUserChoice();

            switch (choice) {
                case 1:
                    manager.addEmployee();
                    break;
                case 2:
                    manager.displayAllEmployees();
                    break;
                case 3:
                    System.out.println(manager.searchById(DataInput.getString("Nhập Id nhân viên ")));
                    break;
                case 4:
                    manager.updateEmployee(DataInput.getString("Nhập Id nhân viên "));
                    break;
                case 5:
                    manager.deleteEmployee(DataInput.getString("Nhập Id nhân viên "));
                    break;
                case 6:
                    manager.saveToFile();
                    break;
                case 0:
                    System.out.println("Tạm biệt!");
                    break;
            }
        } while (choice != 0);
    }
}
