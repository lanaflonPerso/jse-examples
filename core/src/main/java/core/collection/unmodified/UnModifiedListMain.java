package core.collection.unmodified;

import java.util.ArrayList;
import java.util.List;

public class UnModifiedListMain {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String...args) {
        List<String> listOfName = new ArrayList<String>();
        listOfName.add("Pulak");
        listOfName.add("CGI");

        listOfName.add("Himansu");

        System.out.println(listOfName);

        // this is HashMapCustom unmodified list refence
        List list = new UnmodifiedList(listOfName);
        list.add("MBRDI");

    }
}
