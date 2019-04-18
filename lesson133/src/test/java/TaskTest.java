import org.junit.Test;

import java.util.concurrent.Callable;
import static org.junit.Assert.*;
public class TaskTest {
    @Test
    public void getTest() {
        Task<String> task=new Task<String>(() -> "testtext");
        assertEquals("testtext", task.get());
    }

    @Test(expected = NewException.class)
    public void getException() {
        Task<String> task=new Task<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                throw new Exception();
            }
        });
        task.get();
    }
}
