package core;

import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * This class consists of static method that can be used across application. Any method which is not specific to a
 * module is part of this com.org.ds.common utility class.
 * 
 */
public final class CommonUtil {

    /**
     * pre-compiled pattern for latitude.
     */
    private static final Pattern PATTERN_LATITUDE = Pattern.compile("^[-+]?([1-8]?\\d(\\.\\d+)?|90(\\.0+)?)$");
    /**
     * pre-compiled pattern for longitude.
     */
    private static final Pattern PATTERN_LONGITUDE = Pattern
            .compile("^[-+]?(180(\\.0+)?|((1[0-7]\\d)|([1-9]?\\d))(\\.\\d+)?)$");
    /**
     * pre-compiled pattern for IPV4 address.
     */
    private static final Pattern PATTERN_IPV4 = Pattern.compile(
            "\\b(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b");

    /**
     * pre-compiled pattern for IPV6 address. here are some valid ipv6 examples a:b:c:d:e:f:1:2, 1:: 1:2:3::,
     * 1:2:3:f:4:d::, 1d:f1:f::12, 1:3:4:5::5 1:2::54:2:2, 1::d, a::a:a, a:a::a
     */
    private static final Pattern PATTERN_IPV6 = Pattern.compile("([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}|"
            + "([0-9a-fA-F]{1,4}:){1,7}:|" + "([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|"
            + "([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|" + "([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|"
            + "([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|" + "([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|"
            + "[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|" + ":((:[0-9a-fA-F]{1,4}){1,7}|:)");

    /**
     * pre-compiled pattern for white spaces (tab,space, newline etc).
     */
    private static final Pattern PATTERN_WHITESPACE = Pattern.compile("\\s+");

    private static final char[] hexArray = "0123456789ABCDEF".toCharArray();

    private static final byte[] KEY = "3nmSecre8Key1453".getBytes();

    /**
     * private constructor to stop creating instance of this class.
     */
    private CommonUtil() {
    }

    /**
     * Returns true if passed input string is null or has only spaces.
     * 
     * @param str
     *            , input string to check. @return, boolean
     */
    public static boolean isStringNullOrEmpty(final String str) {

        if (null != str && !str.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * Returns true if passed input latitude is valid, return false if passed input is null or empty. valid range is -90
     * to +90.
     * 
     * @param latitude
     *            @return, boolean
     */
    public static boolean isValidLatitude(final String latitude) {
        return isValid(PATTERN_LATITUDE, latitude);
    }

    /**
     * Returns true if passed input longitude is valid, return false if passed input is null or empty. valid range is
     * -180 to +180.
     * 
     * @param longitude
     *            @return, boolean
     */
    public static boolean isValidLongitude(final String longitude) {
        return isValid(PATTERN_LONGITUDE, longitude);
    }

    /**
     * Returns true if passed input ipv4 address is valid, return false if passed input is null or empty. valid format
     * is ddd.ddd.ddd.ddd, where ddd is number between 1 to 255.
     * 
     * @param ipv4
     *            @return, boolean
     */
    public static boolean isValidIpv4(final String ipv4) {
        return isValid(PATTERN_IPV4, ipv4);
    }

    /**
     * Returns true if passed input ipv4 address is valid, return false if passed input is null or empty. valid format
     * is XXXX:XXXX:XXXX:XXXX:XXXX:XXXX:XXXX:XXXX where X is hexadecimal number.
     * 
     * @param ipv6
     *            @return, boolean
     */
    public static boolean isValidIpv6(final String ipv6) {
        return isValid(PATTERN_IPV6, ipv6);
    }

    /**
     * @param ip
     *            the ip
     * @return check if the ip is valid ipv4 or ipv6
     */
    public static boolean isValidIpAddress(final String ip) {
        return CommonUtil.isValidIpv4(ip) || CommonUtil.isValidIpv6(ip);
    }

    /**
     * Returns true if passed input port number is valid, return false if passed input is null or empty or not a number.
     * valid port number is any number between 1 to 65535.
     * 
     * @param ipv4
     *            @return, boolean
     */
    public static boolean isValidPort(final String port) {
        boolean valid = false;
        try {
            final int portNo = Integer.parseInt(port);
            if (portNo >= 1 && portNo <= 65535) {
                valid = true;
            }
        } catch (final NumberFormatException ignoreAndReturnFalse) {
            // if exception then keep valid flag as false only.
        }
        return valid;
    }

    /**
     * Returns true if passed input has space(s) or tab(s), return false if passed input is null or empty.
     * 
     * @param ipv4
     *            @return, boolean
     */
    public static boolean hasWhiteSpace(final String input) {
        return !isStringNullOrEmpty(input) && PATTERN_WHITESPACE.matcher(input).find();
    }

    /**
     * Checks input against passed pattern.
     * 
     * @param pat
     * @param input
     * @return
     */
    private static boolean isValid(final Pattern pat, final String input) {
        return !isStringNullOrEmpty(input) && pat.matcher(input).matches();
    }

    /**
     * Method to read message from Exception.
     * 
     * @param t
     * @return
     */
    public static String getExceptionMessage(final Throwable t) {
        String message = null;
        if (t != null) {
            if (t.getCause() == null) {
                message = t.getMessage();
            } else {
                message = t.getCause().getMessage();
            }
        }
        if (message == null) {
            message = "No message available.";
        }
        return message;
    }

    public static byte[] encrypt(final String value) {
        if (!isStringNullOrEmpty(value)) {
            try {
                final SecretKeySpec skeySpec = new SecretKeySpec(KEY, "AES");
                final Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(Cipher.ENCRYPT_MODE, skeySpec, new IvParameterSpec(new byte[16]));
                return cipher.doFinal(value.getBytes());
            } catch (final Exception e) {
            }
        }
        return null;
    }

    public static String decrypt(final byte[] encrypted) {
        if (encrypted != null) {
            try {
                final SecretKeySpec skeySpec = new SecretKeySpec(KEY, "AES");
                final Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(Cipher.DECRYPT_MODE, skeySpec, new IvParameterSpec(new byte[16]));
                final byte[] original = cipher.doFinal(encrypted);
                return new String(original);
            } catch (final Exception e) {
            }
        }
        return null;
    }

    public static String byteToHex(final byte[] bytes) {
        if (bytes != null) {
            final char[] hexChars = new char[bytes.length * 2];
            for (int j = 0; j < bytes.length; j++) {
                final int v = bytes[j] & 0xFF;
                hexChars[j * 2] = hexArray[v >>> 4];
                hexChars[j * 2 + 1] = hexArray[v & 0x0F];
            }
            return new String(hexChars);
        }
        return null;
    }

    public static byte[] hexToByte(final String s) {
        if (!isStringNullOrEmpty(s)) {
            final int len = s.length();
            final byte[] data = new byte[len / 2];
            for (int i = 0; i < len; i += 2) {
                data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
            }
            return data;
        }
        return null;
    }

    public static String encryptAndHex(final String input) {
        return byteToHex(encrypt(input));
    }

    public static String decryptHex(final String input) {
        return decrypt(hexToByte(input));
    }
}
