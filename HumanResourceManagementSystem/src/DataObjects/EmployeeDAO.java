/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataObjects;

import java.util.List;
import Entities.Employee;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author NGOMI
 */
public class EmployeeDAO {

    public EmployeeDAO() {
    }

    private final String FILE_NAME = "employees.txt";
    private final String DELIMITER = ",";

    public void saveToFile(List<Employee> list) {
        try ( PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Employee e : list) {
                pw.println(e.getEmployeeId() + DELIMITER
                        + e.getFullName() + DELIMITER
                        + e.getDepartmentId()+ DELIMITER
                        + e.getJobTitle() + DELIMITER
                        + e.getDateOfJoining() + DELIMITER
                        + e.getBasicSalary() + DELIMITER
                        + e.getEmploymentType()+ DELIMITER
                        + e.getStatus());
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public List<Employee> loadFromFile() {
        List<Employee> list = new ArrayList<>();
        File f = new File(FILE_NAME);
        if (!f.exists()) {
            return list;
        }

        try ( BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(DELIMITER);
                if (p.length == 8) {
                    Employee e = new Employee();
                    e.setEmployeeId(p[0]);
                    e.setFullName(p[1]);
                    e.setDepartmentId(p[2]);
                    e.setJobTitle(p[3]);
                    e.setDateOfJoining(LocalDate.parse(p[4]));
                    e.setBasicSalary(Double.parseDouble(p[5]));
                    e.setEmploymentType(p[6]);
                    e.setStatus(p[7]);

                    list.add(e);
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
        return list;
    }
    
}
