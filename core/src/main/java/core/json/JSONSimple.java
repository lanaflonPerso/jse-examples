package core.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONSimple {
    private static final String filePath = "C:/Mercury/TestWorkspace/Core/";
    private static final String fileName = "Temp.txt";

    public static void main(String...args) {
        readJSON();
        toJSON();
    }

    private static List<JSONObject> readJSON() {
        JSONObject response = null;
        ArrayList<JSONObject> list = new ArrayList<>();
        try {
            // read the json file
            FileReader reader = new FileReader(filePath + fileName);

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

            // get a String from the JSON object
            String firstName = (String) jsonObject.get("name");
            System.out.println("The first name is: " + firstName);

            // get a number from the JSON object
            long id = (long) jsonObject.get("poID");
            System.out.println("The id is: " + id);

            // get an array from the JSON object
            JSONArray cells = (JSONArray) jsonObject.get("cells");

            // take the elements of the json array
            for (int i = 0; i < cells.size(); i++) {
                System.out.println("The " + i + " element of the array: " + cells.get(i));
            }
            Iterator i = cells.iterator();

            // take each value from the json array separately
            while (i.hasNext()) {
                JSONObject innerObj = (JSONObject) i.next();
                System.out.println("language " + innerObj.get("name") + " with level " + innerObj.get("fdn"));
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    private static void toJSON() {
        Employee user = new Employee();
        ObjectMapper mapper = new ObjectMapper();

        try {
            // convert user object to json string, and save to a file
            mapper.writeValue(new File(filePath + "/user.json"), user);

            // display to console
            System.out.println(mapper.writeValueAsString(user));

        } catch (JsonGenerationException e) {

            e.printStackTrace();

        } catch (JsonMappingException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
