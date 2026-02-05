/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author NGOMI
 */
public class DataInput {

    private static final Scanner sc = new Scanner(System.in);

    public static String getString(String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.err.println("Dữ liệu không được để trống! Vui lòng nhập lại.");
        }
    }

    public static double getDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                double result = Double.parseDouble(sc.nextLine());
                if (result > 0) {
                    return result;
                }
                System.err.println("Giá trị phải lớn hơn 0!");
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số thực hợp lệ!");
            }
        }
    }

    public static LocalDate getLocalDate(String message) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            try {
                System.out.print(message + " (dd/MM/yyyy): ");
                String input = sc.nextLine().trim();
                return LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.err.println("Định dạng ngày không đúng (Ví dụ: 25/12/2023). Vui lòng nhập lại!");
            }
        }
    }

    public static int getInt(String message, int min, int max) {
        while (true) {
            try {
                System.out.print(message);
                int result = Integer.parseInt(sc.nextLine());
                if (result >= min && result <= max) {
                    return result;
                }
                System.err.println("Vui lòng chọn trong khoảng từ " + min + " đến " + max);
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số nguyên!");
            }
        }
    }
}
