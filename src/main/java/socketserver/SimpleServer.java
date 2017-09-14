package socketserver;

import socketserver.handlers.ExceptionHandler;
import socketserver.handlers.Handler;
import socketserver.handlers.PrintingHandler;
import socketserver.handlers.TransmogrifyHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        Handler<Socket, IOException> handler =
            new ExceptionHandler<>(
                new PrintingHandler<>(
                    new TransmogrifyHandler()
                )
            );
        while (true) {
            Socket s = ss.accept();
            handler.handle(s);
        }

    }
}
