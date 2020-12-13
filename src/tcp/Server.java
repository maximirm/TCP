package tcp;

import java.io.IOException;

public interface Server {


    /**
     * create Socket and accept Client connection
     * @param port port
     * @return ConnectionObject
     */
    Connection acceptConnection(int port) throws IOException;

}
