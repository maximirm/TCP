package server;

import java.io.*;
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

        if (args.length == 1) {
            tcpServer.readFile(args[0]);
        } else {
//            tcpServer.doSomething();
            tcpServer.receiveSensorData();
        }
    }

    private void receiveSensorData() throws IOException {

        Socket socket = this.acceptSocket();
        InputStream is = socket.getInputStream();
        DataInputStream dais = new DataInputStream(is);
        long timeStamp = dais.readLong();
        float value = dais.readFloat();
        String sensorName = dais.readUTF();
        System.out.println("timeStamp: " + timeStamp + System.lineSeparator()
                + "value: " + value + System.lineSeparator() + "sensorName: " + sensorName);

    }

    private Socket acceptSocket() throws IOException {
        //create socket
        ServerSocket srvSocket = new ServerSocket(this.port);
        System.out.println("server socket created");
        //open port -> Socket represents connection with the connected client
        return srvSocket.accept();
    }


    private void readFile(String fileName) throws IOException {

        Socket socket = this.acceptSocket();
        FileOutputStream fos = new FileOutputStream(fileName);
        InputStream is = socket.getInputStream();
        int read = 0;
        do {
            //read from inputStream
            read = is.read();
            if (read != -1) {
                //write into FileOutputStream
                fos.write(read);
            }
        } while (read != -1);

    }

    private void doSomething() throws IOException, InterruptedException {

        Socket socket = this.acceptSocket();

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
