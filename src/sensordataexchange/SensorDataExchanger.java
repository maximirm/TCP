package sensordataexchange;

import java.io.*;

public class SensorDataExchanger implements SensorDataSender, SensorDataReceiver{

    @Override
    public void sendSensorData(SensorData data, OutputStream outputStream) throws IOException {

        DataOutputStream daos = new DataOutputStream(outputStream);
        daos.writeLong(data.getTimeStamp());
        daos.writeFloat(data.getValue());
        daos.writeUTF(data.getSensorName());
        outputStream.close();
    }

    @Override
    public SensorData receiveSensorData(InputStream inputStream) throws IOException {

        DataInputStream dais = new DataInputStream(inputStream);

        long timeStamp = dais.readLong();
        float value = dais.readFloat();
        String sensorName = dais.readUTF();
        return new SensorDataImpl(timeStamp, value, sensorName);


    }
}
