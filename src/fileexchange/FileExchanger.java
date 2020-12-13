package fileexchange;

import java.io.*;

public class FileExchanger implements FileReceiver, FileSender {

    @Override
    public void receiveFile(String fileName, InputStream is) throws IOException {
        //create new file
        FileOutputStream fos = new FileOutputStream(fileName);
        this.streamData(is, fos);
    }

    @Override
    public void sendFile(String fileName, OutputStream os) throws IOException {
        //open file
        FileInputStream fis = new FileInputStream(fileName);
        this.streamData(fis, os);
        //tell server that we're done
        os.close();
    }

    private void streamData(InputStream is, OutputStream os) throws IOException {

        int read = 0;
        do {
            //read file from FileInputStream
            read = is.read();
            if (read != -1) {
                //write content in OutputStream
                os.write(read);
            }
        } while (read != -1);
    }

}
