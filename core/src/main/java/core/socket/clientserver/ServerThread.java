package core.socket.clientserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/*
 * 1. Create ServerSocket instance with server port;
 * 2. Set timeout value.
 * 3. Create socket using serversocket.accept()
 * 4. use socket.getInputstream for reading the request.
 * 5. use socket.getOutputStream for writing the request.
 */
public class ServerThread implements Runnable {
    private ServerSocket serverSocket = null;

    public ServerThread(int serverPort, int socketTimeout) {
        try {
            serverSocket = new ServerSocket(serverPort);
            serverSocket.setSoTimeout(socketTimeout);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
                Socket socket = serverSocket.accept();
                System.out.println("Just connected to himansu system : " + socket.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(socket.getInputStream());
                System.out.println(in.readUTF());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                outputStream.writeUTF(
                        "Thank you for connecting to himansu system" + socket.getLocalSocketAddress() + "\nGoodbye!");
                socket.close();
            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

}
