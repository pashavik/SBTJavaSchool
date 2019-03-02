package cycles;//Задано n целых чисел. Выведите их сумму.
//
//        Входные данные
//        В первой строке задано целое число n (1 ≤ n ≤ 10000). Вторая строка содержит n целых чисел, каждое от 1 до 10000, включительно.
//
//        Выходные данные
//        Выведите искомую сумму.

import java.util.Scanner;

public class Ex2002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += sc.nextInt();
        }
        System.out.println(sum);
    }
}
