package cycles;//Задана последовательность n чисел a1, a2,..., an. Для нее вычисляется "хитрая" сумма: s=+a1-a2-a3+a4+a5+a6-a7-a8-a9-a10+...,
//        т.е. знаки плюс и минус чередуются блоками, длина i-го блока равна i.
//
//        Выведите "хитрую" сумму заданной последовательности.
//
//
//        Входные данные
//        В первой строке задано целое число n (1 ≤ n ≤ 10000). Далее во второй строке задана последовательность a1, a2,..., an (1 ≤ ai ≤ 10000).
//
//
//        Выходные данные
//        Выведите "хитрую" сумму заданной последовательности.

import java.util.Scanner;

public class Ex2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int length = 1;
        int blockNum = 1;
        int sign = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (length == 0) {
                sign *= -1;
                blockNum++;
                length = blockNum;
            }
            sum += sign * num;
            length--;
        }
        System.out.println(sum);
    }
}
