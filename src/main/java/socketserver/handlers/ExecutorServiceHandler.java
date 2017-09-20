package socketserver.handlers;

import java.util.concurrent.ExecutorService;
import java.util.function.BiConsumer;

public class ExecutorServiceHandler<S, X extends Throwable> extends ExceptionHandler<S, X> {
    private final ExecutorService pool;

    public ExecutorServiceHandler(ExecutorService pool, Handler<S, X> other) {
        super(other);
        this.pool = pool;
    }

    public ExecutorServiceHandler(ExecutorService pool, Handler<S, X> other, BiConsumer<S, Throwable> exceptionConsumer) {
        super(other, exceptionConsumer);
        this.pool = pool;
    }

    public void handle(S s) {
        pool.submit(() -> super.handle(s));
    }
}
