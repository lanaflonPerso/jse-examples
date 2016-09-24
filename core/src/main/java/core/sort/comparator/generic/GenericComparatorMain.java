package core.sort.comparator.generic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class GenericComparatorMain {

    public static void main(String...args) throws ParseException {
        // test1();
        test2();
    }

    public static void test1() throws ParseException {
        PersonVO person1 = new PersonVO();
        person1.setId(142);
        person1.setName("Himansu");
        person1.setHeight(5.7F);
        person1.setEmailId("himansu.h.nayak@ericsson.com");
        person1.setSalary(4200L);
        person1.setDob(new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse("Jan 10, 1983"));

        PersonVO person2 = new PersonVO();
        person2.setId(321);
        person2.setName("Jeetu");
        person2.setHeight(5.8F);
        person2.setEmailId("jeetu.alex@ericsson.com");
        person2.setSalary(4500L);
        person2.setDob(new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse("Jan 10, 1985"));

        List<PersonVO> persons = new ArrayList<PersonVO>();
        persons.add(person2);
        persons.add(person1);
        // Test com.org.ds.sorting with different data type
        sortPerson(persons, "id");
        sortPerson(persons, "name");
        sortPerson(persons, "height");
        sortPerson(persons, "emailId");
        sortPerson(persons, "dob");
        sortPerson(persons, "salary");
    }

    public static void test2() {
        List<String> alphaNumericList = new ArrayList<String>() {
            {
                add("Himansu12");
                add("Himansu12");
                add("Himansu1");
                add("Himansu22");
                add("Himansu33");
                add("Himansu11");
                add("Himansu23");
                add("Himansu3");
                add("Himansu2");
                add("Himansu0");
                add("Himansu10");

            }
        };
        Collections.sort(alphaNumericList, new GenericComparator(true));
        System.out.println(alphaNumericList);
        List<String> alphaNumericList2 = new ArrayList<String>() {
            {
                add("aaa");
                add("ccc");
                add("zzz");
                add("ddd");
                add("ooo");
                add("nnn");
                add("q");

            }
        };
        Collections.sort(alphaNumericList2, new GenericComparator(true));
        System.out.println(alphaNumericList2);
    }

    @SuppressWarnings("unchecked")
    private static void sortPerson(List<PersonVO> persons, String attribute) {
        List<PersonVO> abc = new ArrayList<>();
        Collections.sort(abc, new GenericComparator(attribute, Boolean.FALSE));
        System.out.println("Sort by " + attribute);
        for (PersonVO person : persons) {
            System.out.println(person);
        }
    }

}