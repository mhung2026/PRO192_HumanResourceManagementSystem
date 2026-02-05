/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataObjects;

import Entities.Department;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NGOMI
 */
public class DepartmentDAO {
    private final String FILE_NAME = "departments.txt";
    private final String DELIMITER = ",";
    public void saveToFile(List<Department> list) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Department d : list) {
                pw.println(d.getDepartmentId() + DELIMITER + d.getDepartmentName());
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file Department: " + e.getMessage());
        }
    }
    public List<Department> loadFromFile() {
        List<Department> list = new ArrayList<>();
        File f = new File(FILE_NAME);
        
        if (!f.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(DELIMITER);
                if (p.length == 2) {
                    Department d = new Department();
                    d.setDepartmentId(p[0].trim());
                    d.setDepartmentName(p[1].trim());
                    list.add(d);
                }
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file Department: " + e.getMessage());
        }
        return list;
    }
}
