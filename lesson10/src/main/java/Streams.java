import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Streams<T> {
    private Collection<T> collection;

    public Streams(Collection<T> collection) {
        this.collection = collection;
    }

    public static <T>Streams<T> of(Collection<T> collection){
        return new Streams<T>(collection);
    }
    public Streams<T> filter(Predicate<T> predicate){
        collection.removeIf(predicate.negate());   //отриц
        return this;
    }

    public<R> Streams<R> transform(Function<? super T, ? extends R> function){
        ArrayList<R> result=new ArrayList<>();
        collection.forEach(p->result.add(function.apply(p)));
        return Streams.of(result);
    }

    public <K, V> Map toMap (Function<? super T, ? extends K> key, Function<? super T, ? extends V> value ){
        Map<K, V> result=new HashMap<>();
        collection.forEach(item->result.put(key.apply(item), value.apply(item)));

        return result;
    }
}
