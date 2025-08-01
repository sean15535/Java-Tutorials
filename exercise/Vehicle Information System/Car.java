/**
 * Car class implements Vehicle and CarVehicle.
 * Stores and retrieves details specific to cars.
 */
public class Car implements Vehicle, CarVehicle {
    private String make, model, fuelType;
    private int year, numberOfDoors;

    public Car(String make, String model, int year, int numberOfDoors, String fuelType) {
        this.make = make;
        this.model = model;
        this.year = year;
        setNumberOfDoors(numberOfDoors);
        setFuelType(fuelType);
    }

    @Override
    public String getMake() { return make; }

    @Override
    public String getModel() { return model; }

    @Override
    public int getYear() { return year; }

    @Override
    public void setNumberOfDoors(int doors) {
        if (doors < 2 || doors > 6) {
            throw new IllegalArgumentException("Doors must be between 2 and 6.");
        }
        this.numberOfDoors = doors;
    }

    @Override
    public int getNumberOfDoors() { return numberOfDoors; }

    @Override
    public void setFuelType(String fuelType) {
        if (!fuelType.equalsIgnoreCase("Petrol") &&
            !fuelType.equalsIgnoreCase("Diesel") &&
            !fuelType.equalsIgnoreCase("Electric")) {
            throw new IllegalArgumentException("Invalid fuel type.");
        }
        this.fuelType = fuelType;
    }

    @Override
    public String getFuelType() { return fuelType; }

    @Override
    public String toString() {
        return "Car: " + make + " " + model + " (" + year + "), " + numberOfDoors +
                " doors, Fuel: " + fuelType;
    }
}
