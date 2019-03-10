package linked;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyList<Number> list = new MyList<>();

        list.add(1);
        list.add(1.0);
        list.add(1, 2.0);

        list.remove(2);
        for (Number n : list) {
            System.out.println(n);
        }
        System.out.println("-----------------------");

        List<Integer> list2=new ArrayList<>();
        list2.add(5);
        list2.add(6);
        list2.add(7);

        list.addAll(list2);

        for (Number n : list) {
            System.out.println(n);
        }
        System.out.println("---------------------");

        List<Number> list3=new LinkedList<>();
        list.copy(list3);

        for (Number n : list3) {
            System.out.println(n);
        }
    }


}
