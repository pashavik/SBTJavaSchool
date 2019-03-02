package arrays;

import java.util.Scanner;

public class Ex2022 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && (arr[i] % arr[j] == 0)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
