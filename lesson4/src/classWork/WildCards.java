package classWork;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 6 on 07.03.2019.
 */
public class WildCards {
    public static void main(String[] args) {
       List<? extends  Number> numbers=new ArrayList<>();
       //numbers.add(new Integer(0));
    }
}
