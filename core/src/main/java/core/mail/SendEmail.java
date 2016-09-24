package core.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
    public static void main(String...args) {
        final String RECIPIENT = "shruthi.sujyothi@daimler.com";
        final String SENDER = "robin.thomas@daimler.com";
        final String SMTP_HOSTNAME = "53.71.105.25";

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", SMTP_HOSTNAME);

        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(SENDER));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(RECIPIENT));
            message.setSubject("Shruthi is Best");
            message.setText("This is actual message");

            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}