package fileexchange;

import java.io.IOException;
import java.io.OutputStream;

public interface FileSender {

    /**
     * send file via outputStream
     * @param fileName     local file name
     * @param outputStream outputStream
     */
    void sendFile(String fileName, OutputStream outputStream) throws IOException;

}
