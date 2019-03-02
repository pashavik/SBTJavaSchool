package arrays;

import java.util.Scanner;

public class Ex2026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = i; j < n; j++) {
                if (arr[j] > arr[i]) {
                    arr[i] = arr[j];
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                arr[i] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
