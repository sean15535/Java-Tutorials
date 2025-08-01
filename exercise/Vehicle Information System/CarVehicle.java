/**
 * CarVehicle interface defines additional methods specific to cars.
 */
public interface CarVehicle {
    void setNumberOfDoors(int doors);
    int getNumberOfDoors();
    void setFuelType(String fuelType); // Accepts Petrol, Diesel, Electric
    String getFuelType();
}
