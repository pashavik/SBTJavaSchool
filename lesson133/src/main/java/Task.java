import java.util.concurrent.Callable;

public class Task<T> {
    private Callable<? extends T> callable;
    private NewException exception;
    private T result;

    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }


    public T get() {
        if (result == null) {
        if (exception != null) {

                throw exception;
            }
            synchronized (this) {
                if (result == null) {

                    try {
                        result = callable.call();
                    } catch (Exception e) {
                        exception = new NewException(e);
                        throw exception;
                    }
                }
            }
        }

        return result;
    }
}
