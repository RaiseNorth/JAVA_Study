package io.github.raisenorth.autosale;

public class Main {
    public static void main(String[] args) {
        Sale std = new Sale();
        Thread t1 = new Thread(std, "淘  宝");
        Thread t2 = new Thread(std, "京  东");
        Thread t3 = new Thread(std, "拼夕夕");
        t1.start();
        t2.start();
        t3.start();
    }
}