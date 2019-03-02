package strings;

import java.util.Scanner;

public class Ex2037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        String[] words = str.split(",");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= n) {
                if (sb.length() != 0) {
                    sb.append(",");
                    sb.append(words[i]);
                }
            }

        }
        System.out.println(sb);
    }
}
