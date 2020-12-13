package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPConnector implements Client,Server, Connection{

    private Socket socket;

    @Override
    public Connection connect(String hostName, int port) throws IOException {
        this.socket = new Socket(hostName, port);
        return this;
    }

    @Override
    public Connection acceptConnection(int port) throws IOException {
        ServerSocket srvSocket = new ServerSocket(port);
        System.out.println("server socket created");
        //open port -> Socket represents connection with the connected client
        this.socket = srvSocket.accept();
        return this;
    }

    @Override
    public OutputStream getOutputStream() throws IOException {
        return this.socket.getOutputStream();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return this.socket.getInputStream();
    }
}
