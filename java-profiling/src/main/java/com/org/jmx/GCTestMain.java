package com.org.jmx;

import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

/**
 * set the value in vmoptins before running the program
 *  -Dcom.sun.management.jmxremote
 *  -Dcom.sun.management.jmxremote.port=1617
 *  -Dcom.sun.management.jmxremote.authenticate=false
 *  -Dcom.sun.management.jmxremote.ssl=false
 *  -XX:+UnlockCommercialFeatures
 *  -XX:+FlightRecorder
 *
 *  start any jmx console i.e. jconsole, jvisualvm or jmc(java mission control)
 *  also use eclipse memory analyser rcp
 *  list of profiler :
 *          https://github.com/Himansu-Nayak/ebooks/blob/master/java%20profilers.jpg
 */
public class GCTestMain {

    private static void init() throws MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException {
        MBeanServer mbs;
        mbs = ManagementFactory.getPlatformMBeanServer();
        GCTestAgent agent = new GCTestAgent();
        ObjectName agentName;
        agentName = new ObjectName("GCTestMbean:name=GCTestAgent");
        mbs.registerMBean(agent, agentName);
    }

    public static void main(String...args) throws Exception {
        init();
        System.out.println("Start Infinite running time Thread");
        for (;;) {
            TimeUnit.SECONDS.sleep(1);
        }
    }
}