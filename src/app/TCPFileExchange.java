package app;

import java.io.IOException;

public interface TCPFileExchange {


    /**
     * send file to remote host
     * @param fileName file name
     * @param hostName host name
     * @param port     port
     */
    void sendFile2Host(String fileName, String hostName, int port) throws IOException;


    /**
     * receive content + write into local file
     * @param fileName file name
     * @param port port
     */
    void receiveFile(String fileName, int port) throws IOException;

}
