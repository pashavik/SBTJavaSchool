package classWork;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 6 on 07.03.2019.
 */
public class Main {
    public static void main(String[] args) {
        List<String> strings= new ArrayList<>();
        strings.add("str1");

 //      strings.add(new Integer(1));

       // String s= strings.get(1);


        //////////////////////////

        Test<Integer> test1=new Test(new Integer(0));
        Test <Double> test2=new Test(new Double(1));

        Integer field1= test1.getField();
        Double field2= test2.getField();


        Pair <Integer, Double> pair1=new Pair<>(new Integer(0), new Double(0));

        Integer t1=pair1.getT1();
        Double t2= pair1.getT2();


    }
}
