import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;

/**
 * Created by 6 on 18.04.2019.
 */
public class Process extends Thread {
    private final Socket socket;
    private final DataInputStream in;
    private final DataOutputStream out;
    private final int num;

    public Process(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        num = new Random().nextInt(10);


    }

    @Override
    public void run() {
        System.out.println("загадали" + num);
        try {
            while (true) {
                out.writeUTF("число загадано");
                int i = in.readInt();
                if (i == num) {
                    out.writeUTF("win");
                    out.flush();
                    break;
                } else out.writeUTF("fail");
                out.flush();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
