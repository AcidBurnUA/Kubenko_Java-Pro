package Homework6;

import Homework4.Animal;

public class HomeWorkApp {
    public void main() {
    }
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    public static void checkSumSign() {
        int a = 5;
        int b = -10;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сума позитивна");
        } else {
            System.out.println("Сума негативна");
        }

    }
    public static void printColor() {
    int value = 5;
    if (value <= 0) {
        System.out.println("Червоний");
    } if (value >= 0 && value <= 100){
        System.out.println("Жовтий");
    } if (value >= 0 && value <= 100){
        System.out.println("Зелений");
    } else {
    System.out.println("Помилка");
    }
}
    public static void compareNumbers() {
    int a = 5;
    int b = -10;
    if (a >= b) {
    System.out.println("a >= b");
    } if (a < b){
    System.out.println("a < b");
    } else {
    System.out.println("Помилка");
    }
}
    public static boolean SUM(int a, int b){
    int c = a + b;
    return (c >= 10 && c <= 20);
}
    public static void D(int a){
    if (a >= 0) {
        System.out.println("Передане число є додатнім");
    } else {
        System.out.println("Передане число є від'ємним");
    }
}
    public static boolean SU(int a){
    if (a < 0) {
       return true;
    } else {
       return false;
    }
}
    public static void SUf(int a,String b) {
        for (int i = 0; i < a; i++) {
            System.out.println(b);
        }
    }
    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
        }

}

