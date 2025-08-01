/**
 * TruckVehicle interface defines additional methods specific to trucks.
 */
public interface TruckVehicle {
    void setCargoCapacity(double capacity); // in tons
    double getCargoCapacity();
    void setTransmissionType(String type); // Manual, Automatic
    String getTransmissionType();
}
