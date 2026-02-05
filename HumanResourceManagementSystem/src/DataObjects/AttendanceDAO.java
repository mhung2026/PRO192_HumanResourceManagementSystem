/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataObjects;

import Entities.Attendance;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NGOMI
 */
public class AttendanceDAO {
    private final String FILE_NAME = "attendance.txt";

    public List<Attendance> loadFromFile() {
        List<Attendance> list = new ArrayList<>();
        File f = new File(FILE_NAME);
        if (!f.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                if (p.length == 4) {
                    Attendance att = new Attendance();
                    att.setEmployeeId(p[0].trim());
                    att.setDate(LocalDate.parse(p[1].trim()));
                    att.setStatus(p[2].trim());
                    att.setOvertimeHours(Integer.parseInt(p[3].trim()));
                    list.add(att);
                }
            }
        } catch (Exception e) {
            System.err.println("Lỗi đọc file điểm danh: " + e.getMessage());
        }
        return list;
    }
}
