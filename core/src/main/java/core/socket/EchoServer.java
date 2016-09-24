package core.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 1. Create Server Socket
 * 2. Crea
 */
public class EchoServer {
    public static void main(String...args) {
        ServerSocket echoServer = null;
        try {
            echoServer = new ServerSocket(9999);
        } catch (IOException e) {
            System.out.println(e);
        }
        try {
            Socket clientSocket = echoServer.accept();
            DataInputStream is = new DataInputStream(clientSocket.getInputStream());
            PrintStream os = new PrintStream(clientSocket.getOutputStream());
            String line;
            while (true) {
                line = is.readLine();
                os.println(line);
            }
        } catch (IOException exception) {
            System.out.println(exception);
        }
    }
}