import org.junit.Assert;
import org.junit.Test;


public class ScalableThreadPoolTest {

        @Test
        public void start() throws Exception {
            ScalableThreadPool pool = new ScalableThreadPool(1,12);
            pool.execute(()->{});
            pool.execute(()->{});
            pool.execute(()->{});
            pool.start();
            Thread.sleep(1000);
            Assert.assertEquals(0,pool.getQueueSize());
        }

        @Test
        public void execute() throws Exception {
            ScalableThreadPool pool = new ScalableThreadPool(1,12);
            pool.execute(()->{});
            pool.execute(()->{});
            pool.execute(()->{});
            Assert.assertEquals(3,pool.getQueueSize());
        }
}
