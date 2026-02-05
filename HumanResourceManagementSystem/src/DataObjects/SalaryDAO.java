/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataObjects;

import Entities.SalaryRecord;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NGOMI
 */
public class SalaryDAO {
    private final String FILE_NAME = "salary_records.txt";
    private final String DELIMITER = ",";

    public List<SalaryRecord> loadFromFile() {
        List<SalaryRecord> list = new ArrayList<>();
        File f = new File(FILE_NAME);
        if (!f.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(DELIMITER);
                if (p.length == 7) {
                    SalaryRecord s = new SalaryRecord();
                    s.setEmployeeId(p[0].trim());
                    s.setMonth(Integer.parseInt(p[1].trim()));
                    s.setYear(Integer.parseInt(p[2].trim()));
                    s.setWorkingDays(Integer.parseInt(p[3].trim()));
                    s.setAbsenceDays(Integer.parseInt(p[4].trim()));
                    s.setOvertimeHours(Integer.parseInt(p[5].trim()));
                    s.setTotalSalary(Double.parseDouble(p[6].trim()));
                    list.add(s);
                }
            }
        } catch (Exception e) {
            System.err.println("Lỗi đọc file lương: " + e.getMessage());
        }
        return list;
    }
}
