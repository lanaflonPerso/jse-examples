package com.org.ws.producer;

import com.org.ws.impl.PersonServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * http://localhost:8888/ws/person?wsdl
 */
public class SOAPPublisher {

    public static void main(String...args) {
        Endpoint.publish("http://localhost:8888/ws/person", new PersonServiceImpl());
    }

}
