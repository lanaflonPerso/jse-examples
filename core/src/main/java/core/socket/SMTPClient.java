package core.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SMTPClient {
    public static void main(String...args) {
        Socket smtpSocket = null;
        DataOutputStream os = null;
        DataInputStream is = null;
        try {
            smtpSocket = new Socket("53.71.105.25", 25);
            os = new DataOutputStream(smtpSocket.getOutputStream());
            is = new DataInputStream(smtpSocket.getInputStream());
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: hostname");
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: hostname");
        }
        if (smtpSocket != null && os != null && is != null) {
            try {
                os.writeBytes("HELO\n");
                os.writeBytes("MAIL From: harish.majji@daimler.com\n");
                os.writeBytes("RCPT To: harish.majji@daimler.com\n");
                os.writeBytes("DATA\n");
                os.writeBytes("From: harish.majji@daimler.com\n");
                os.writeBytes("Subject: testing\n");
                os.writeBytes("Hi there\n"); // message body
                os.writeBytes("\n.\n");
                os.writeBytes("QUIT");
                String responseLine;
                while ((responseLine = is.readLine()) != null) {
                    System.out.println("Server: " + responseLine);
                    if (responseLine.indexOf("Ok") != -1) {
                        break;
                    }
                }
                os.close();
                is.close();
                smtpSocket.close();
            } catch (UnknownHostException e) {
                System.err.println("Trying to connect to unknown host: " + e);
            } catch (IOException e) {
                System.err.println("IOException:  " + e);
            }
        }
    }
}