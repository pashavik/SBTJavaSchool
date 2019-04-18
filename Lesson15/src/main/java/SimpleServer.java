import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 6 on 18.04.2019.
 */
public class SimpleServer {
    public static void main(String[] args) throws IOException {


        try (ServerSocket serverSocket = new ServerSocket(1234);
             Socket socket = serverSocket.accept();
             DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
             DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        ) {
            String s = dataInputStream.readLine();
          //  dataOutputStream.writeChars(String.valueOf(Instant.now()+'\n'));
            System.out.println(s);
        }
    }
}


