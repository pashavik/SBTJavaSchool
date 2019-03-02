package cycles;//Задана грузоподъемность грузовика w (в тоннах). На него последовательно грузятся предметы массами a1, a2,..., an,
//        где ai — масса i-го груза в тоннах. Если при погрузке очередного предмета рабочие замечают,
//        что в случае завершения процесса суммарный вес погруженных предметов превысит грузоподъемность,
//        то погрузка этого предмета не осуществляется (он пропускается).
//
//        Выведите количество предметов, которые будут погружены в соответствии с алгоритмом выше и их суммарную массу.
//
//
//        Входные данные
//        В первой строке записана пара целых чисел n, w (1 ≤ n ≤ 10000, 1 ≤ w ≤ 10000). Вторая строка содержит последовательность целых чисел
//        a1, a2,..., an (1 ≤ ai ≤ 10000).
//
//        Выходные данные
//        Выведите количество погруженных предметов и их суммарную массу.


import java.util.Scanner;

public class Ex2008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int item = sc.nextInt();
            if (sum + item <= w) {
                sum += item;
                count++;
            }
        }
        System.out.println(count + " " + sum);
    }
}
