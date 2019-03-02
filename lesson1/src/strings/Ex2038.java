package strings;

import java.util.Scanner;

public class Ex2038 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = 0;

        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) >= 65 && str.charAt(i) <= 90) || (str.charAt(i) >= 97 && str.charAt(i) <= 122)) {    //диапазон заглавных и строчных букв
                if (!flag) {
                    count++;
                    flag = true;
                }
            } else {
                flag = false;

            }
        }
        System.out.println(count);
    }
}
