package core.scratch;

/**
 * Created by ehimnay on 12/10/2016.
 */
public class TypeCasting {
    public static void main(String[] args) {
        Object obj = "3";
        String str = (String)obj;
        int a = Integer.parseInt(str);
        System.out.println(a);
    }
}
