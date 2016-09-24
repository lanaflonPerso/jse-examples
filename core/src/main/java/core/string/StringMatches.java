package core.string;

/**
 * Created by ehimnay on 19/05/2016.
 */
public class StringMatches {
    public static void main(String...args) {
        String match1 = "(?s)(?i:.*error.*)";
        String match2 = "(?s)(?i:.*command not found.*)";
        String responseMessage = new StringBuffer().append("ss7_tcap -tcn 1")
                .append("Warning: -tbind 10; Improper Value; TcapTimerBind; Ss7Tcap.TcapTimerBind should be more than TimerSSNBind of an associated Ss7LocalSignalingPoint (Possible DP SS7 board restart!)")
                .append("trace_collection_ipv6server -tcsn TraceCollectionServerName")
                .append("\n Error: -ip 0:0:0:0:0:ffff:7f00:1; Illegal Value; -ip TraceCollectionServerIpv6Address; The IPv6 address is not within allowed range. The IPv6 address must be within prefix 2000::/3 (Global Unicast) or within prefix FC00::/7 (Unique-Local Unicast).")
                .append("\nError: ; Incomplete Configuration; ; Service IPv6 address for IP service CTUM is missing.")
                .toString();
        System.out.println(!responseMessage.matches(match1 + "|" + match2));

    }
}
