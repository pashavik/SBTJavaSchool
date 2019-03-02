package cycles;//Задана последовательность n целых чисел a1, a2,..., an. Выведите сумму всех ее элементов, стоящих на позициях,
//        которые являются степенями двойки: 1, 2, 4, 8, 16 и т.д.
//
//        Входные данные
//        В первой строке задано целое число n (1 ≤ n ≤ 10000). Вторая строка содержит последовательность целых чисел a1, a2,..., an.
//
//        Выходные данные
//        Выведите искомую сумму.

import java.util.Scanner;

public class Ex2009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int index = 1;
        for (int i = 1; i < n + 1; i++) {
            int item = sc.nextInt();
            if (i == index) {
                sum += item;
                index *= 2;
            }
        }
        System.out.println(sum);
    }
}
