import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Test implements Iterable<String> {
    private String[] arr;
    private String[] arr2;
    private String text;
    //public static String FILE_NAME = "C:\\Users\\pashp\\IdeaProjects\\SBTJavaSchool\\lesson3\\src\\test2.txt";

    public Test(String text) {
        this.text = text.toLowerCase();
        arr = this.text.split("\\s+");   //делим по пробелам
        arr2 = this.text.split("\\n");   //по строкам
    }


    public int wordsCount() {
        return arr.length;
    }

    public int uniqueWordsCount() {
        Set<String> hashSet = new HashSet<>(Arrays.asList(arr));
        return hashSet.size();

    }

    public void sortedWords() {
        Set<String> hashSet = new HashSet<>(Arrays.asList(arr)); //берем различные слова

        List<String> uniqueWords = new ArrayList<>(hashSet);
        Collections.sort(uniqueWords);   //по умолчанию лексикографический порядок

        Collections.sort(uniqueWords, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() < s2.length()) {
                    return -1;
                } else if (s1.length() > s2.length()) {
                    return 1;
                } else return 0;
            }
        });
        for (String word : uniqueWords) {
            System.out.println(word);
        }

    }

    //3
    public void frequencyUniqueWords1() {
        Map<String, Integer> map = new HashMap<>();
        for (String word : arr) {
            if (!map.containsKey(word)) {
                map.put(word, 0);
            }
            map.put(word, map.get(word) + 1);
        }
        for (String word : map.keySet()) {
            System.out.println(word + " " + map.get(word));
        }
    }
//    public void frequencyUniqueWords2(){
//        Set<String> hashSet=new HashSet<>(Arrays.asList(arr));
//        List<String> list=new ArrayList<>(Arrays.asList(arr));
//
//        for(String word: hashSet){
//            System.out.println(word+" "+Collections.frequency(list, word));
//        }
//    }

    //4
    public void reverseLines() throws IOException {
//        BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));

//        String line;
//        while((line=reader.readLine())!=null){
//            list.add(line);
//        }
        List<String> list = new ArrayList<>(Arrays.asList(arr2));
        Collections.reverse(list);
        for (String s : list) {
            System.out.println(s);
        }
    }

    //5
    @Override
    public Iterator<String> iterator() {
        //Итератор перебирает слова в обратном порядке
        return new Iterator<String>() {

            int current = arr.length;

            @Override
            public boolean hasNext() {
                if (current > 0)
                    return true;
                else
                    return false;
            }

            @Override
            public String next() {
                current--;
                return arr[current];
            }
        };
    }

    public void reversedList() {
        Iterator<String> wordsIter = this.iterator();
        for (String s : this) {
            System.out.println(s + " ");
        }
    }

    //6
    public void usersLines(int[] nums) {
        List<String> list = new ArrayList<>(Arrays.asList(arr2));
//        Integer number=new Integer(1);
//        for(String s: arr2){
//            number++;
//        }
        for (int num : nums) {
            System.out.println(num + " " + list.get(num - 1));
        }

    }
}


