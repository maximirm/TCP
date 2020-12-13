package sensordataexchange;

public interface SensorData {

    /**
     * @return measurement time Stamp
     */
    long getTimeStamp();

    /**
     * @return measurement value
     */
    float getValue();

    /**
     * @return sensor name
     */
    String getSensorName();

}
