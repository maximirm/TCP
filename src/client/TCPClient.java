package client;

import java.io.*;
import java.net.Socket;

public class TCPClient {

    public static final String HOST = "localhost";
    public static final int PORT = 7777;
    private static final String FUNNY_MESSAGE = "hihi";
    private final int port;
    private final String hostname;

    TCPClient(String hostname, int port) {

        this.hostname = hostname;
        this.port = port;
    }

    public static void main(String[] args) throws IOException {

        if (args.length < 2) {
            System.out.println("Missing parameters: hostname, portnumber");
        }
        String hostName = args[0];
        int port = Integer.parseInt(args[1]);
        TCPClient tcpClient = new TCPClient(hostName, port);

        String fileName = null;
        if(args.length>2){
            fileName = args[2];
        }

        if(fileName != null){
            tcpClient.copyFile(fileName);
        } else{
            tcpClient.doSomething();
        }


    }

    private void copyFile(String fileName) throws IOException {
        //create port
        Socket socket = new Socket(this.hostname, this.port);
        //get file from FileInputStream
        FileInputStream fis = new FileInputStream(fileName);
        //get outputStream from socket
        OutputStream os = socket.getOutputStream();


        int read = 0;
        do{
            //read file from FileInputStream
            read = fis.read();
            if (read != -1){
                //write content in OutputStream
                os.write(read);
            }
        } while(read != -1);
    }

    private void doSomething() throws IOException {
        //create port
        Socket socket = new Socket(this.hostname, this.port);
        //write something in outputStream
        socket.getOutputStream().write(FUNNY_MESSAGE.getBytes());

        //read from socket via inputStream
        InputStream is = socket.getInputStream();
        //buffer
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //write everything we read from InputStream into ByteArrayOutputStream
        int read;
        do {
            read = is.read();
            if (read != -1) {
                baos.write(read);
            }
        } while (read != -1);

        //write everything from ByteArrayOutputStream into String
        System.out.println("received: " + baos.toString());

    }

}
