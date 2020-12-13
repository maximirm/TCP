package tcp;

import java.io.IOException;

public interface Client {


    /**
     * create Socket
     * @param hostName hostName
     * @param port port
     * @return ConnectionObject
     */
    Connection connect(String hostName, int port) throws IOException;


}
