package socketserver.handlers;

public interface Handler<S, X extends Throwable> {
    void handle(S s) throws X;
}
