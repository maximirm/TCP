package app;

import sensordataexchange.SensorData;

import java.io.IOException;

public interface TCPSensorDataExchanger {

    /**
     * send sensor data to host
     * @param sensorData sensorData
     * @param hostName hostName
     * @param port port
     */
    void sendSensorData2Host(SensorData sensorData, String hostName, int port) throws IOException;

    /**
     * receive sensor data
     * @param port port
     */
    void receiveSensorData(int port) throws IOException;

}
