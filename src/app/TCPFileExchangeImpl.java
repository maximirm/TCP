package app;

import fileexchange.FileExchanger;
import fileexchange.FileReceiver;
import fileexchange.FileSender;
import tcp.Client;
import tcp.Connection;
import tcp.Server;
import tcp.TCPConnector;

import java.io.IOException;

public class TCPFileExchangeImpl implements TCPFileExchange {

    @Override
    public void sendFile2Host(String fileName, String hostName, int port) throws IOException {
        //connection
        Client client = new TCPConnector();
        Connection connection = client.connect(hostName, port);

        //send file
        FileSender fileSender = new FileExchanger();
        fileSender.sendFile(fileName, connection.getOutputStream());

    }

    @Override
    public void receiveFile(String fileName, int port) throws IOException {
        //connection
        Server server = new TCPConnector();
        Connection connection = server.acceptConnection(port);

        //receive file
        FileReceiver fileReceiver = new FileExchanger();
        fileReceiver.receiveFile(fileName, connection.getInputStream());
    }

}
