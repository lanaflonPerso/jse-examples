package com.org.jmx;

import java.lang.management.ManagementFactory;

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

    public static void main(String[] args) throws Exception {
        init();
        for (;;) {
            Thread.sleep(1000);
        }
    }
}