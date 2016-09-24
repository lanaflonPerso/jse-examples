package core.assignment;

import static java.util.Arrays.asList;

import java.util.*;

public abstract class TrickyMain {

    /**
     * @param args
     */
    public static void main(String...args) {
        template();
    }

    public static void template() {
        /*
         * forEach(); date(); stringPattern(); stringFormat(); hashMapToArrayList(); safeVarargs();
         * CelltraceNodePmJobPriority celltraceNodePmJobPriority = new CelltraceNodePmJobPriority();
         * methodVariableCheck(celltraceNodePmJobPriority);
         * System.out.println(celltraceNodePmJobPriority.highPriorityPmJobExists);
         */
        substring();
    }

    public static void substring() {
        String fdn = "LTE07dg2ERBS00021";
        System.out.println(fdn.substring(fdn.indexOf("=") + 1));
    }

    public static void hashMapToArrayList() {
        Map<String, String> map = new HashMap<String, String>() {
            {
                put("Himansu", "Nayak");
                put("Sidero", "Mercury");
            }
        };
        List<Map<String, String>> list = asList(map);
        System.out.println();
    }

    public static void stringFormat() {
        String ctumFunctionFdn = String.format("MeContext=%s,ManagedElement=%s,SgsnMme=1,NodeFunction=%s", "test1",
                "test1", "test1");
        System.out.println(ctumFunctionFdn);
    }

    @SafeVarargs
    public static final void safeVarargs(List<String>... stringLists) {
        Object[] array = stringLists;
        List<Integer> tmpList = Arrays.asList(42);
        array[0] = tmpList;
        String s = stringLists[0].get(0);
    }

    public static void forEach() {
        List<String> names = asList("Himansu", "Chaminda", "Sergi", "Dinesh", "Wagner");
        /*
         * names.stream().forEach(System.out::println);
         */}

    public static void date() {
        String test = "Himansu";
        System.out.println(Objects.requireNonNull(test));

        System.out.println(TimeZone.getDefault().getID());
        System.out.println(TimeZone.getTimeZone(TimeZone.getDefault().getID()));

        /*
         * transient String test = "test"; static String test = "test"; String test; System.out.println(test);
         */
    }

    public static void stringPattern() {
        String emailRegularExpression = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        String email = "himansuxnayak@gmail.co.in";
        String invalidEmail = "himansuxnayak@gmail";
        System.out.println("Enter email ID is valid : " + email.matches(emailRegularExpression));
        System.out.println("Enter email ID is valid : " + invalidEmail.matches(emailRegularExpression));
    }

    public static void methodVariableCheck(CelltraceNodePmJobPriority celltraceNodePmJobPriority) {
        celltraceNodePmJobPriority.highPriorityPmJobExists = true;
        return;
    }

    public String getNodeNameFromFdn(final String nodeFdn) {
        return nodeFdn.substring(nodeFdn.indexOf("=") + 1);
    }

    private static class CelltraceNodePmJobPriority {
        private boolean highPriorityPmJobExists = false;
        private boolean normalPriorityPmJobExists = false;
    }

}
