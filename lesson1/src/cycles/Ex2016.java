package cycles;//Задано уравнение вида Ax2+Bx+C=0. В этом уравнении каждый коэффициент может принимать любое значение от -100 до 100, включительно.
//        Такое уравнение может иметь 0, 1, 2 или даже бесконечное количество различных корней.
//
//        Напишите программу, которая выведет количество корней этого уравнения.
//
//        Входные данные
//        Единственная строка входных данных содержит целые числа A, B, C (-100 ≤ A,B,C ≤ 100).
//
//
//        Выходные данные
//        Выведите количество корней или число -1, если уравнение имеет бесконечное количество корней.

import java.util.Scanner;

public class Ex2016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if (a == 0 && b == 0 && c == 0) {
            System.out.println(-1);
            return;
        }

        if (a == 0 && b == 0) {
            System.out.println(-1);
            return;
        }

        if (a == 0 || b == 0 || c == 0) {

            if (a == 0 || (b == 0 && c == 0)) {
                System.out.println(1);
                return;
            }
            if (b == 0 && c != 0) {
                double cdiva = -(double) c / (double) a;
                if (cdiva > 0) {
                    System.out.println(2);
                    return;
                } else if (cdiva < 0) {
                    System.out.println(0);
                    return;
                }
                System.out.println(1);
                return;
            }
            if (b != 0 && c == 0) {
                System.out.println(2);
                return;
            }
        }

        int d = b * b - 4 * a * c;
        if (d > 0) {
            System.out.println(2);
        } else if (d == 0) {
            System.out.println(1);
        } else System.out.println(0);
    }
}
