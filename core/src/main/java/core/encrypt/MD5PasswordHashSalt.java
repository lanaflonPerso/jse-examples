package core.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;

public class MD5PasswordHashSalt {
    private String name;

    private Date dob;

    public static void main(String...args) {
        String passwordToHash = "himansu";
        String generatedPassword = null;
        byte[] bytes = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("SHA1PRNG");
            // Add password bytes to digest
            md.update(passwordToHash.getBytes());
            // Get the hash's bytes
            bytes = md.digest();
            // This bytes[] has bytes in decimal format;
            // Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            // Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println("Messge : " + passwordToHash);
        System.out.println("Digest : " + generatedPassword);
        // System.out.println("Decyrpt Message : " + decyrptMD5(bytes));

    }

    public static String getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("Himansu");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt.toString();
    }
    /*
     * public static String decyrptMD5(byte[] data) { StringBuffer buf = new StringBuffer(); for (int i = 0; i <
     * data.length; i++) { int halfbyte = (data[i] >>> 4) & 0x0F; int two_halfs = 0; do { if ((0 <= halfbyte) &&
     * (halfbyte <= 9)) buf.append((char) ('0' + halfbyte)); else buf.append((char) ('HashMapCustom' + (halfbyte -
     * 10))); halfbyte = data[i] & 0x0F; } while (two_halfs++ < 1); } return buf.toString(); }
     */

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dob == null) ? 0 : dob.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MD5PasswordHashSalt other = (MD5PasswordHashSalt) obj;
        if (dob == null) {
            if (other.dob != null)
                return false;
        } else if (!dob.equals(other.dob))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}