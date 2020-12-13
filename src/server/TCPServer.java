package server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static final int PORT_NUMBER = 7777;
    private final int port;

    TCPServer(int port) {

        this.port = port;
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        TCPServer tcpServer = new TCPServer(PORT_NUMBER);
        tcpServer.doSomething();
    }

    private void doSomething() throws IOException, InterruptedException {
        //create socket
        ServerSocket srvSocket = new ServerSocket(this.port);
        //open port -> Socket represents connection with the connected client
        Socket socket = srvSocket.accept();
        //read from socket e.g. GET/index.. / ignore result in this example
        socket.getInputStream().read();

        //get outputStream from socket
        OutputStream os = socket.getOutputStream();
        //respond -> write into os
        os.write("hey mister client".getBytes());
        //put process to sleep for a while
        Thread.sleep(5000);
        //close outputStream
        os.close();
    }

}
