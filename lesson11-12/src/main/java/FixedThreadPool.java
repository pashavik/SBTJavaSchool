import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FixedThreadPool {

    private List<Workers> workers = new ArrayList<>();
    private final Queue<Runnable> queue = new LinkedList<>();

    public Queue<Runnable> getQueue() {
        return queue;
    }
    public int getQueueSize() {
        return queue.size();
    }

    public FixedThreadPool(int size) {
        for (int i = 0; i < size; i++) {
            workers.add(new Workers("Thread " + i));
        }
    }

    public void start() {
        for (Workers worker : workers) {
            worker.start();
        }
    }

    public void execute(Runnable runnable) {
        synchronized (queue) {
            queue.add(runnable);
            queue.notify();
        }
    }


    class Workers extends Thread {
        @Override
        public void run() {
            while (true) {
                Runnable task;
                synchronized (queue) {
                    try {
                        if (queue.isEmpty()) {
                            queue.wait();
                        }
                        task = queue.poll();
                    } catch (InterruptedException e) {
                        return;
                    }
                }
                task.run();
            }
        }

        Workers(String name) {
            super(name);
        }
    }

}
