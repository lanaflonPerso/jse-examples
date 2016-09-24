package core.jsch;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;

import com.jcraft.jsch.*;
import com.jcraft.jsch.ChannelSftp.LsEntry;

public class SFTPClient {
    private final String sftpServer;
    private final static int SFTP_PORT = Integer.getInteger("sftp_port", 22);
    private final static String USER_NAME = System.getProperty("node_username", "root");
    private final static String PASSWORD = System.getProperty("node_password", "12shroot");

    public boolean copyTestFileToSftpServer(final String testFilesSourceDir, final String remoteFilesPath) {
        boolean filesCopied = false;
        File testFilesDir = new File(testFilesSourceDir);
        File[] testFiles = testFilesDir.listFiles();
        Session session = null;
        ChannelSftp channel = null;
        try {
            JSch jsch = new JSch();
            session = jsch.getSession(USER_NAME, sftpServer, SFTP_PORT);
            session.setPassword(PASSWORD);

            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            channel = (ChannelSftp) session.openChannel("sftp");
            channel.connect();
            channel.mkdir(remoteFilesPath);
            channel.cd(remoteFilesPath);
            for (File file : testFiles) {
                channel.put(new FileInputStream(file), file.getName());
            }
            filesCopied = true;
        } catch (Exception e) {
            Logger.getLogger(e.getMessage());
        } finally {
            if (channel != null)
                channel.exit();
            if (session != null)
                session.disconnect();
        }
        return filesCopied;
    }

    public void renameFile(final String directory, final String oldName, final String newName) {
        Session session = null;
        ChannelSftp channel = null;
        try {
            JSch jsch = new JSch();
            session = jsch.getSession(USER_NAME, sftpServer, SFTP_PORT);
            session.setPassword(PASSWORD);

            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            channel = (ChannelSftp) session.openChannel("sftp");
            channel.connect();
            channel.cd(directory);
            channel.rename(oldName, newName);
        } catch (Exception e) {
            Logger.getLogger("Failed to copy test files : " + e.getMessage());
        } finally {
            if (channel != null)
                channel.exit();
            if (session != null)
                session.disconnect();
        }
    }

    public void cleanRemoteTestFiles(final String testFilesSourceDir, final String remoteFilesPath) {
        File testFilesDir = new File(testFilesSourceDir);
        File[] testFiles = testFilesDir.listFiles();
        Session session = null;
        ChannelSftp channel = null;
        try {
            JSch jsch = new JSch();
            session = jsch.getSession(USER_NAME, sftpServer, SFTP_PORT);
            session.setPassword(PASSWORD);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            channel = (ChannelSftp) session.openChannel("sftp");
            channel.connect();
            final Vector<LsEntry> files = channel.ls(remoteFilesPath);
            for (LsEntry lsEntry : files) {
                channel.rm(remoteFilesPath + lsEntry.getFilename());
            }
            for (File file : testFiles) {
                channel.rm(remoteFilesPath + file.getName());
            }
            channel.rmdir(remoteFilesPath);
        } catch (Exception e) {
            Logger.getLogger("Failed to clean test files : " + e.getMessage());
        } finally {
            if (channel != null)
                channel.exit();
            if (session != null)
                session.disconnect();
        }
    }

    public void listFiles(final String dir) {
        Session session = null;
        ChannelSftp channel = null;
        try {
            JSch jsch = new JSch();
            session = jsch.getSession(USER_NAME, sftpServer, SFTP_PORT);
            session.setPassword(PASSWORD);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            channel = (ChannelSftp) session.openChannel("sftp");
            channel.connect();
            List<LsEntry> listFiles = channel.ls(dir);
            for (LsEntry lsEntry : listFiles) {
                System.out.println(lsEntry.getFilename());
            }
        } catch (Exception e) {
            Logger.getLogger("Failed to clean test files : " + e.getMessage());
        } finally {
            if (channel != null)
                channel.exit();
            if (session != null)
                session.disconnect();
        }
    }

    public SFTPClient(final String ipAddress) {
        this.sftpServer = ipAddress;
    }

    public static void main(String...args) {
        SFTPClient s = new SFTPClient("10.32.227.104");
        s.listFiles("/var/tmp/RemoteFileDir");
    }
}
