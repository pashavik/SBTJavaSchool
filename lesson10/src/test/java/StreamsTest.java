import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class StreamsTest {
    public List<Integer> list = new ArrayList<>();
    @Before

    public void setUp() throws Exception {

        list.add(0);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(5);

    }

    @Test
    public void testFilter() {

        int size=Streams.of(list)
                .filter(i ->i>0 )
                .filter(i->i<3)
                .toMap(key->key, value->value)
                .size();
        assertEquals(2, size);

    }

    @Test
    public void testTransform() {
        Streams streams = Streams.of(list);
        Map map = streams.transform(item -> (Integer) item).toMap(key -> key, value -> value);
        map.forEach((key, value)-> assertTrue(key instanceof Integer));
    }

    @Test
    public void testToMap() {
        Map<Integer, Integer> map = Streams.of(list).toMap(key -> key, value -> value = value * 10);
        map.forEach((key, value) -> assertEquals((long) key * 10, (long) value));
    }
}
