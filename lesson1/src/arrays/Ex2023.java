package arrays;

import java.util.Scanner;

public class Ex2023 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] a = new int[n1];

        for (int i = 0; i < n1; i++) {
            a[i] = sc.nextInt();
        }

        int n2 = sc.nextInt();
        int[] b = new int[n2];

        for (int i = 0; i < n2; i++) {
            b[i] = sc.nextInt();
        }
        int[] c = new int[n1];
        int el = 0;
        for (int i = 0; i < a.length; i++) {
            if (search(b, c[i])) {
                c[el] = c[i];
            }
        }
        System.out.println(c[el]);
        for (int i = 0; i < el; i++) {
            System.out.print(c[i] + " ");
        }
    }

    public static boolean search(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return true;
            }

        }
        return false;
    }
}
