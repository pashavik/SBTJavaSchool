package cycles;//
//Верно ли, что два заданных прямоугольника a1 x b1 и a2 x b2 были получены разрезанием некоторого квадрата одним прямолинейным разрезом?
//        Напишите программу, которая выведет YES или NO.
//
//
//        Входные данные
//        В первой строке заданы числа целые a1, b1 (1 ≤ a1,b1 ≤ 1000), во второй — числа целые a2, b2 (1 ≤ a2,b2 ≤ 1000). Числа в строках заданы через пробел.
//
//
//        Выходные данные
//        Выведите YES или NO.

import java.util.Scanner;

public class Ex2012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a1 = sc.nextInt();
        int b1 = sc.nextInt();
        int a2 = sc.nextInt();
        int b2 = sc.nextInt();

        if (a1 + a2 == b1 && b1 == b2) {
            System.out.println("YES");
        } else if (b1 + b2 == a1 && a1 == a2) {
            System.out.println("YES");
        } else if (a1 + b2 == b1 && a2 == b1) {
            System.out.println("YES");
        } else if (a2 + b1 == a1 && a1 == b2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

