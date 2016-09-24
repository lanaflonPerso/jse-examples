package core.socket.clientserver;

/*
 * 1. Create ServerSocket instance with server port and timeout
 */
public class GreetServer extends Thread {

    public static void main(String...args) {
        final int port = 6066;
        final int timeout = 100000;
        Thread serverThread = new Thread(new ServerThread(port, timeout));
        serverThread.start();
    }
}