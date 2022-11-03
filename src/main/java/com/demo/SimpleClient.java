package com.demo;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class SimpleClient {
    public static void main(String[] args) throws TException {
        TTransport transport = null;
        transport = new TSocket("localhost",9090);
        TProtocol protocol = new TBinaryProtocol(transport);
        UserService.Client client = new UserService.Client(protocol);
        transport.open();

        User user = client.getById(1);
        System.out.println("result:" + user);



    }
}
