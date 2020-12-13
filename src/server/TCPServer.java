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
        System.out.println("server socket created");

        //open port -> Socket represents connection with the connected client
        Socket socket = srvSocket.accept();
        System.out.println("connection to client accepted");

        //read from socket e.g. GET/index.. / ignore result in this example
        socket.getInputStream().read();
        System.out.println("read from inputStream");

        //get outputStream from socket
        OutputStream os = socket.getOutputStream();
        os.write("hey mister client".getBytes());

        //respond -> write into os
        System.out.println("wrote in outputStream");
        System.out.println("going to sleep");

        //put process to sleep for a while
        Thread.sleep(5000);
        System.out.println("woke up");
        
        //close outputStream
        os.close();
    }

}
