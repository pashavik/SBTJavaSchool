//Дан набор из n слов, состоящих из маленьких латинских букв.
//
//        Будем называть слово странным, если в нем встречаются 3 или более гласные буквы подряд.
//
//        Ваша задача — удалить из данного набора все странные слова.
//
//        Гласными буквами в латинском алфавите считаются e,y,u,i,o,a.
//
//        Входные данные
//        В первой строке содержится число n — количество слов в наборе, n не превосходит 100.
//        Далее в n строках по одному на строке содержатся слова из набора. Слова состоят только из маленьких латинских букв.
//        Длина каждого слова не менее 1 и не более 20 символов.
//
//
//        Выходные данные
//        Выведите все слова из набора, не являющиеся странными. Каждое слово выводите на отдельной строке в том порядке, в котором они заданы во входных данных.

package strings;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex2036 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] str = new String[n];
        String reg = "[yeuioa]{3,}";
        Pattern pattern = Pattern.compile(reg);

        for (int i = 0; i < n; i++) {
            String word = sc.nextLine();
            str[i] = word;

        }
        for (int i = 0; i < str.length; i++) {
            Matcher matcher = pattern.matcher(str[i]);
            if (!matcher.find()) {
                System.out.println(str[i]);

            }
        }
    }
}
