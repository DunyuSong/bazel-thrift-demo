package com.demo;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

public class SimpleService {
    public static void main(String[] args) throws TTransportException {

        TServerTransport serverTransport = new TServerSocket(9090);
        UserService.Processor processor = new UserService.Processor(new UserServiceImp());
        TBinaryProtocol.Factory factory = new TBinaryProtocol.Factory();
        TServer.Args ags = new TServer.Args(serverTransport);
        ags.processor(processor);
        ags.protocolFactory(factory);

        TServer server = new TSimpleServer(ags);
        System.out.println("Starting the simple server...");
        server.serve();

    }
}
