package util;

import client.TCPClient;
import server.TCPServer;

import java.io.IOException;

public class start {

    // now we can start Client and Server with the same .jar
    public static void main(String[] args) throws IOException, InterruptedException {
        if(args.length >= 2){
            TCPClient.main(args);
        } else {
            TCPServer.main(args);
        }
    }
}
