package socketserver;

import java.io.IOException;
import java.net.Socket;

public class NastyChump {
    public static void main(String[] args) {
        Socket[] sockets = new Socket[30000];
        for (int i = 0; i < sockets.length; i++) {
            try {
                sockets[i] = new Socket("localhost", 8080);
                System.out.println(i);
            } catch (IOException e) {
                System.err.println("Error connecting " + e);
            }

        }


    }
}
