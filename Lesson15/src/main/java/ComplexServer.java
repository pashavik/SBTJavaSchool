import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 6 on 18.04.2019.
 */
public class ComplexServer {
    public static void main(String[] args) throws IOException {
        try (
                ServerSocket serverSocket = new ServerSocket(1234);

        ) {
            Socket socket = serverSocket.accept();
            new Process(socket).start();
        }


    }
}
