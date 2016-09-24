package core.collection.unmodified;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

/**
 * Created by ehimnay on 12/05/2016.
 */
public class BiDirectionalMap {

    final static Map<String, String> gshCommands = new LinkedHashMap<>();
    final static List<String> rollBackGshCommands = new ArrayList<>();

    public static void main(String...args) {

        gshCommands.put("MODIFY_NODE_FUNCTION", "cmd 1");
        gshCommands.put("CREATE_IP_SERVICE", "cmd 2");
        gshCommands.put("CHECK_CONFIG", "");
        gshCommands.put("ACTIVATE_CONFIG", "");

        boolean sshResult = executeCommands(gshCommands);
        if (!sshResult) {
            executeRollBackCommands(rollBackGshCommands);
        }
        System.out.println("SSH cmd execution result : " + sshResult);
    }

    public static boolean executeCommands(final Map<String, String> gshCommands) {
        for (final Entry<String, String> commandEntry : gshCommands.entrySet()) {
            final String gshCommand = commandEntry.getKey();
            final String rollBackGshCommand = commandEntry.getValue();
            if (executeCommandOverSSH(gshCommand)) {
                if (StringUtils.isNotEmpty(rollBackGshCommand)) {
                    rollBackGshCommands.add(rollBackGshCommand);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean executeRollBackCommands(final List<String> rollBackCommands) {
        boolean successFailure = true;
        if (!rollBackCommands.isEmpty()) {
            for (final String rollBackCommand : rollBackCommands) {
                successFailure = executeCommandOverSSH(rollBackCommand);
            }
        }
        return successFailure;
    }

    public static boolean executeCommandOverSSH(final String command) {
        boolean successFailure = true;
        System.out.println("execute the command over ssh : " + command);
        return successFailure;
    }
}