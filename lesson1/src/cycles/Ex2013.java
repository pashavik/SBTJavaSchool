package cycles;//Задана последовательность n целых чисел a1, a2,..., an. Выведите количество ее элементов, равных минимальному.
//
//
//        Входные данные
//        В первой строке записано целое число n (1 ≤ n ≤ 10000). Вторая строка содержит последовательность n целых чисел a1, a2,..., an (-10000 ≤ ai ≤ 10000).
//
//
//        Выходные данные
//        Выведите искомое количество минимумов.


import java.util.Scanner;

public class Ex2013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int min = 10001;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int item = sc.nextInt();
            if (item < min) {
                min = item;
                count = 0;
            }
            if (item == min) {
                count++;
            }
        }

        System.out.println(count);
    }
}
