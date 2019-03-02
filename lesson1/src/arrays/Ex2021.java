package arrays;

import java.util.Scanner;

public class Ex2021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int max = max(arr);
        exec(arr, max);
        max = max(arr);
        exec(arr, max);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int max(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static void exec(int[] arr, int max) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                arr[i] /= 2;
            }
        }
    }

}
