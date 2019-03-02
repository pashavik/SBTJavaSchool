package cycles;//При записи в двоичной системе счисления число будет заканчиваться на 0, если оно является четным.
//        Аналогично, число будет заканчиваться на два нуля, если оно делится на 4.
//
//        В этой задаче вам надо определить "круглость" числа при записи в двоичной системе счисления,
//        т.е. вам необходимо найти максимальную степень двойки, на которую эту число делится.
//
//        Напишите программу, которая определяет на сколько нулей заканчивается двоичная запись заданного целого числа n.
//
//        Входные данные
//        В единственной строке записано целое число n (1 ≤ n ≤ 109).
//
//        Выходные данные
//        Выведите искомое количество нулей.

import java.util.Scanner;

public class Ex2007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;

        while (n % 2 == 0) {
            n /= 2;
            count++;

        }
        System.out.println(count);
    }
}
