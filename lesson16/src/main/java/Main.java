import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> map=new HashMap<Integer, String>();

        for (int i = 0; i <10000000; i++) {
            map.put(i, "value"+i);

        }
    }
}
