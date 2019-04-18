import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by 6 on 18.04.2019.
 */
public class ComplexClient {
    public static void main(String[] args) throws IOException {

        Socket socket=new Socket("localhost", 1234);
        DataInputStream in=new DataInputStream(socket.getInputStream());
        DataOutputStream out=new DataOutputStream(socket.getOutputStream());
        DataInputStream console=new DataInputStream(System.in);
        System.out.println(in.readUTF());

        while(true){
              int readInt=console.readInt();
              out.writeInt(readInt);
              out.flush();
            System.out.println(in.readUTF());
        }

    }
}
