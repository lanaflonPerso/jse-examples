package core.socket.clientserver;

import java.io.*;
import java.net.Socket;

public class GreetClient {
    public static void main(String...args) {
        final String HIMANSU_SERVER_IP = "53.88.93.43";
        final int HIMANSU_SERVER_PORT = 6066;
        try {
            System.out.println("Connecting to " + HIMANSU_SERVER_IP + " on port " + HIMANSU_SERVER_PORT);
            Socket client = new Socket(HIMANSU_SERVER_IP, HIMANSU_SERVER_PORT);
            System.out.println("Just connected to " + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("Hello from " + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("Server says " + in.readUTF());
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
