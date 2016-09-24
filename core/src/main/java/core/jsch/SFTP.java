package core.jsch;

        import java.io.File;
        import java.io.FileInputStream;
        import com.jcraft.jsch.*;

public class SFTP {

    public SFTP() {
    }

    public static void main(String...args) {
        final String SFTPHOST = "159.107.165.174";
        final String SFTPUSER = "himansu";
        final String SFTPPASS = "himansu";
        final String SFTPWORKINGDIR = "\\yFTPServer\\path\\";
        final String FILEPATH = "C:/Mercury/";
        final String FILE = FILEPATH + "TOR_pmd_ruleset-1.0.xml";
        int SFTPPORT = 22;

        Session session = null;
        Channel channel = null;
        ChannelSftp channelSftp = null;

        try {
            JSch jsch = new JSch();
            session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
            session.setPassword(SFTPPASS);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            channel = session.openChannel("sftp");
            channel.connect();
            channelSftp = (ChannelSftp) channel;
            channelSftp.cd(SFTPWORKINGDIR);
            File f = new File(FILE);
            channelSftp.put(new FileInputStream(f), f.getName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
