package app;

import sensordataexchange.SensorData;
import sensordataexchange.SensorDataExchanger;
import sensordataexchange.SensorDataReceiver;
import sensordataexchange.SensorDataSender;
import tcp.Client;
import tcp.Connection;
import tcp.Server;
import tcp.TCPConnector;

import java.io.IOException;

public class TCPSensorDataExchangerImpl implements TCPSensorDataExchanger {

    @Override
    public void sendSensorData2Host(SensorData sensorData, String hostName, int port) throws IOException {

        Client client = new TCPConnector();
        Connection connection = client.connect(hostName, port);
        SensorDataSender sensorDataSender = new SensorDataExchanger();
        sensorDataSender.sendSensorData(sensorData, connection.getOutputStream());

    }

    @Override
    public void receiveSensorData(int port) throws IOException {

        Server server = new TCPConnector();
        Connection connection = server.acceptConnection(port);
        SensorDataReceiver sensorDataReceiver = new SensorDataExchanger();
        sensorDataReceiver.receiveSensorData(connection.getInputStream());

    }
}
