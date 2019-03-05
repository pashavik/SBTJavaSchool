import java.io.File;
import java.io.IOException;
import java.util.*;

public class Ex2056 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\pashp\\IdeaProjects\\SBTJavaSchool\\lesson3\\src\\test1.txt");
        Scanner sc = new Scanner(file);

        List<String> input=new ArrayList<>();
        while (sc.hasNext()){
            input.add(sc.next().toLowerCase());
        }
        Map<String, Integer> map=new HashMap<>();
        List<String> popularWord=new ArrayList<>();

        for(String word: input){
            Integer count=map.get(word);
            if(count==null){
                count=0;
            }
            map.put(word, ++count);
        }

        Integer max=Collections.max(map.values());   //находим max value элемент

        for(Map.Entry<String, Integer> item:map.entrySet()){
            if(max.equals(item.getValue())){
              popularWord.add(item.getKey());
            }
        }
        Collections.sort(popularWord);
        for(String word:popularWord){
            System.out.println(word);
        }
    }
}

