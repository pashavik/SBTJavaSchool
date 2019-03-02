package cycles;//Задан номер года y. Ваша задача вывести 1, если год високосный. Выведите 0 в противном случае.
//        Год является високосным, если он кратен 4 и при этом не кратен 100, либо кратен 400.
//        Так, годы 1700, 1800 и 1900 не были високосными, так как они кратны 100 и не кратны 400.
//        Год 2000 — високосный, так как он кратен 400. 2100, 2200 и 2300 — не високосные.

import java.util.Scanner;

public class Ex2004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println(1);
        } else System.out.println(0);
    }
}
