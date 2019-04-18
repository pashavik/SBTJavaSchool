import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by 6 on 18.04.2019.
 */
public class SimpleClient {
    public static void main(String[] args) throws IOException {
        try (Socket client = new Socket("localhost", 1234);
             DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
             DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());

        ) {
            dataInputStream.readLine();
        }


    }
}
