import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static String FILE_NAME = "C:\\Users\\pashp\\IdeaProjects\\SBTJavaSchool\\lesson3\\src\\test2.txt";
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get(FILE_NAME);
        //Проверяем существует ли файл
        if ( ! Files.exists(filePath)) {
            System.err.println("file not found.");
            return;
        }
        //Читаем файл в строку
        String content = new String(Files.readAllBytes(filePath));

        Test test=new Test(content);

        System.out.println("Кол-во слов= "+test.wordsCount());

        //1) Количество уникальных слов
        System.out.println("Кол-во уникальных слов "+test.uniqueWordsCount());
        System.out.println("===============================");
        //2) отсортированные уникальные слова
        test.sortedWords();
        System.out.println("===============================");
        System.out.println();

        //3) уникальные слова+количество
        test.frequencyUniqueWords1();
        System.out.println("===============================");
        System.out.println();

        //4)строки в обратном порядке
        test.reverseLines();
        System.out.println("===============================");
        System.out.println();

        //5)обход списка в обратном порядке(свой итератор)
        test.reversedList();
        System.out.println("===============================");
        System.out.println();

//        6) вывод определенных строк
        int[] nums={1, 2, 4};
        test.usersLines(nums);


    }


}
