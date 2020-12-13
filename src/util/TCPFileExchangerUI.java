package util;


import app.TCPFileExchange;
import app.TCPFileExchangeImpl;

import java.io.IOException;


/**
 * UI file transfer
 */
public class TCPFileExchangerUI {

    public static void main(String[] args) throws IOException {

        if (args.length < 2) {
            System.err.println("at least two arguments required");
            return;
        }
        String fileName = args[0];
        String hostName = null;
        int port = -1;

        if (args.length == 3) {
            hostName = args[1];
            port = Integer.parseInt(args[2]);
        } else if (args.length == 2) {
            port = Integer.parseInt(args[1]);
        }
        TCPFileExchange tcpFileExchange = new TCPFileExchangeImpl();
        if (hostName == null) {
            //receive
            tcpFileExchange.receiveFile(fileName, port);
        } else {
            tcpFileExchange.sendFile2Host(fileName, hostName, port);
        }

    }
}
