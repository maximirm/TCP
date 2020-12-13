package sensordataexchange;

import java.io.IOException;
import java.io.OutputStream;

public interface SensorDataSender {

    /**
     * send data via outputStream
     * @param data dataObject
     * @param outputStream outputStream
     */
    void sendSensorData(SensorData data, OutputStream outputStream) throws IOException;

}
