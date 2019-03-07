import java.util.ArrayList;
import java.util.List;

/**
 * Created by 6 on 07.03.2019.
 */
public class MethodParams {
    public static <T> void fill(List<T> list, T val){
        for(int i=0; i<list.size(); i++){
            list.set(i, val);
        }
    }

    public static void main(String[] args) {
        List<Integer> integers=new ArrayList<>();
        integers.add(new Integer(0));
        integers.add(new Integer(1));
        System.out.println(integers);
        fill(integers, new Integer(2));
        System.out.println(integers);
    }
}
