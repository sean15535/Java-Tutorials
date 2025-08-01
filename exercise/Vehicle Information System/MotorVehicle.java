/**
 * MotorVehicle interface defines additional methods specific to motorcycles.
 */
public interface MotorVehicle {
    void setNumberOfWheels(int wheels);
    int getNumberOfWheels();
    void setMotorcycleType(String type); // Sport, Cruiser, Off-road
    String getMotorcycleType();
}
