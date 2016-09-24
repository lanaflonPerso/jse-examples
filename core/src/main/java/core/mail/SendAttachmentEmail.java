package core.mail;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendAttachmentEmail {
    public static void main(String...args) {

        final String RECIPIENT = "himansu.nayak@daimler.com";
        final String SENDER = "Bill.Gates@microsoft.com";
        final String SMTP_HOSTNAME = "53.71.105.25";

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", SMTP_HOSTNAME);
        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(SENDER));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(RECIPIENT));
            message.setSubject("This is the Subject Line!");

            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("This is message body");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            String filename = "C:/firmware/Temp.txt";
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);

            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
