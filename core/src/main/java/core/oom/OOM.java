package core.oom;

/**
  VM Argument :
  -Xmx256m
  -XX:-UseGCOverheadLimit
  -XX:+HeapDumpOnOutOfMemoryError -verbose:gc
  -XX:+PrintGCDetails
  -XX:+PrintGCTimeStamps
  -Xloggc:gc.log
  -XX:HeapDumpPath=c:\temp
 */
public class OOM {
    public static void main(String[] args) {
        do {
            long[] oom = new long[999999999];
            System.out.println("args = [" + args + "]");
        } while (true);
    }
}
