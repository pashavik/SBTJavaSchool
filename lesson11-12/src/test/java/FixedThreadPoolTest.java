import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class FixedThreadPoolTest {

    @Test
    public void start() throws InterruptedException {
        FixedThreadPool fixedThreadPool=new FixedThreadPool(5);
        fixedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
            }
        });
        fixedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
            }
        });
        fixedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
            }
        });
        fixedThreadPool.execute(() -> {
        });
        fixedThreadPool.start();
        Thread.sleep(1000);
        assertEquals(0, fixedThreadPool.getQueueSize());
    }


    @Test
    public void execute() {
        FixedThreadPool pool = new FixedThreadPool(5);
        pool.execute(()->{});
        pool.execute(()->{});
        pool.execute(()->{});
        assertEquals(3,pool.getQueueSize());
    }
}
