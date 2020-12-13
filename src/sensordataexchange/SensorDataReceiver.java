package sensordataexchange;

import java.io.IOException;
import java.io.InputStream;

public interface SensorDataReceiver {

    /**
     * receive data from inputStream
     * @param inputStream inputStream
     * @return dataObject
     */

    SensorData receiveSensorData(InputStream inputStream) throws IOException;

}
