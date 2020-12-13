package fileexchange;

import java.io.IOException;
import java.io.InputStream;

public interface FileReceiver {

    /**
     * receive file from inputStream
     * @param fileName    local file name
     * @param inputStream inputStream
     */
    void receiveFile(String fileName, InputStream inputStream) throws IOException;

}
