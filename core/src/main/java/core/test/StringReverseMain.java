package core.test;

public class StringReverseMain {

    /**
     * @param args
     */
    private static StringBuffer recursive = new StringBuffer();

    public static void main(String... args) {
        final String NAME = "Himnansu Nayak";
        reverseString(NAME);
        revereStringRecursive(NAME);
        System.out.println(recursive);
    }

    public static void reverseString(String string) {
        StringBuffer reverseName = new StringBuffer(string.length());
        for (int index = string.length() - 1; index >= 0; index--) {
            reverseName.append(string.charAt(index));
        }
        System.out.println(reverseName.toString());
    }

    public static void revereStringRecursive(String string) {
        recursive.append(string.charAt(string.length() - 1));
        if (string.length() == 1) {
            return;
        } else {
            revereStringRecursive(string.substring(0, string.length() - 1));
        }
    }

}
