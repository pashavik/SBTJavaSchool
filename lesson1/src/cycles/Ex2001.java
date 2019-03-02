package cycles;//Заданы a и b. Выведите a+b.
//
//
//        Входные данные
//        В единственной строке входных данных заданы целочисленные a и b (1 ≤ a,b ≤ 1000).
//

import java.util.Scanner;

public class Ex2001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if ((a >= 1 && a <= 1000) && (b >= 1 && b <= 1000)) {
            System.out.println(a+b);
        } else System.out.println("Некорректные значения");
    }
}
