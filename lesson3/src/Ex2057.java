import java.util.*;

public class Ex2057 { //27 из 30
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int elem;
        int v;
        int min;

        List<Integer> numbers = new ArrayList<>();

        for (Integer i = 0; i < n; i++) {
            elem = sc.nextInt();
            if (elem == 1) {
                v = sc.nextInt();
                numbers.add(v);

            } else {
                min = Collections.min(numbers);
                numbers.remove(min);
                System.out.println(min);
            }
        }
    }
}