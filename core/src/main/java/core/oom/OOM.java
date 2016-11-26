package core.oom;

/**
  * VM Argument :
  * -XX:+HeapDumpOnOutOfMemoryError
  * -XX:HeapDumpPath=c:/temp
 */
public class OOM {
        public static void main(String[] args) {
                char[] oom = new char[999999999];
        }
}
