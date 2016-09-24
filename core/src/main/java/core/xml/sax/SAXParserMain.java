package core.xml.sax;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import core.xml.dom.Employee;

/*
 * 1. Create SAXParserFactory
 * 2. Create SAXParserHandler
 * 3. Pass File and handler to saxParser
 * 4. SAX Parser will run and update the list in the handler.
 * 5. 
 */
public class SAXParserMain {

    public static void main(String...args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SAXParserHandler handler = new SAXParserHandler();
            saxParser.parse(new File("employee.xml"), handler);
            // Get Employees list
            List<Employee> empList = handler.getEmpList();
            // print employee information
            for (Employee emp : empList)
                System.out.println(emp);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

}