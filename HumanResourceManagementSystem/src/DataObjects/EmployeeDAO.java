/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataObjects;

import Entities.Employee;
import java.util.List;
import Entities.User;
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

    public void saveToFile(List<User> list) {
        try ( PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (User e : list) {
                pw.println(e.getUserId() + DELIMITER
                        + e.getFullName() + DELIMITER
                        + e.getDepartmentId() + DELIMITER
                        + e.getJobTitle() + DELIMITER
                        + e.getDateOfJoining() + DELIMITER
                        + e.getBasicSalary() + DELIMITER
                        + e.getEmploymentType() + DELIMITER
                        + e.getStatus());
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file Employee: " + e.getMessage());
        }
    }

    public List<User> loadFromFile() {
        List<User> list = new ArrayList<>();
        File f = new File(FILE_NAME);
        if (!f.exists()) {
            return list;
        }

        try ( BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(DELIMITER);
                if (p.length == 8) {
                    User e = new Employee() {

                    };
                    e.setUserId(p[0]);
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
            System.out.println("Lỗi khi đọc file Employee: " + e.getMessage());
        }
        return list;
    }

}
