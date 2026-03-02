/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.util.ArrayList;

/**
 *
 * @author NGOMI
 */
public class Menu {
    private final String title;
    private final ArrayList<String> options = new ArrayList<>();
    public Menu(String title) {
        this.title = title;
    }
    public void addOption(String option) {
        options.add(option);
    }
    public void display() {
        System.out.println("\n--- " + title + " ---");
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
        System.out.println("0. Thoát");
    }
    public int getUserChoice() {
        return DataInput.getInt("Mời bạn chọn chức năng (0-" + options.size() + "): ", 0, options.size());
    }
}
