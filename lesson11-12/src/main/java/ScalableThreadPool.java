import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ScalableThreadPool {
    private int max;
    private int min;

    private Queue<Runnable> queue=new LinkedList<>();
    private static Set<Workers> workers=new HashSet<>();


    public int getQueueSize() {
        return queue.size();
    }

    public ScalableThreadPool(int max, int min) {
        this.max = max;
        this.min = min;
        for(int i=0; i<min; i++){
            workers.add(new Workers());
        }
    }

    public void start(){
        for (Workers worker : workers) {
            worker.start();
        }
    }

    public void execute(Runnable runnable) {
        synchronized (queue) {
            queue.add(runnable);
            queue.notify();
        }
        checkSize();

    }
    private void checkSize() {
        while (!queue.isEmpty() && workers.size() < max) {
            workers.add(new Workers());
        }
    }



    private class Workers extends Thread {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                Runnable task;
                synchronized (queue) {
                    if (queue.isEmpty() && workers.size() > min) {
                        return;
                    }
                    if (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                    task = queue.poll();
                }
                task.run();
            }
        }
    }

}
