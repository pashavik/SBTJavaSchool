package cycles;

//Альтернированной суммой заданной последовательности n чисел a1, a2,..., an называется
//        число s=a1-a2+a3-a4+.... В альтернированной сумме знаки слагаемых чередуются, альтернация начинается со знака " + ".
//
//        По заданной последовательности целых чисел выведите ее альтернированную сумму.
//
//        Входные данные
//        В первой строке задано целое число n (1 ≤ n ≤ 10000). Вторая строка содержит n целых чисел, каждое от 1 до 10000 включительно.
//
//        Выходные данные
//        Выведите искомую альтернированную сумму.

import java.util.Scanner;

public class Ex2003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (flag) {
                sum -= sc.nextInt();
            } else {
                sum += sc.nextInt();
            }
            flag = !flag;
        }
        System.out.println(sum);
    }
}
