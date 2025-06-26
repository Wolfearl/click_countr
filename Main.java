package com.click_countr;

public class Main {
    public static void main(String[] args) {
        System.out.println(Main.class.getResource("/"));
        AppForm app = new AppForm();
        app.setVisible(true);
    }
}
