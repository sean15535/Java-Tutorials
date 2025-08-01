public class Truck implements Vehicle, TruckVehicle {
    private String make, model, transmissionType;
    private int year;
    private double cargoCapacity;

    public Truck(String make, String model, int year, double cargoCapacity, String transmissionType) {
        this.make = make;
        this.model = model;
        this.year = year;
        setCargoCapacity(cargoCapacity);
        setTransmissionType(transmissionType);
    }

    @Override
    public String getMake() { return make; }

    @Override
    public String getModel() { return model; }

    @Override
    public int getYear() { return year; }

    @Override
    public void setCargoCapacity(double capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Cargo capacity must be positive.");
        }
        this.cargoCapacity = capacity;
    }

    @Override
    public double getCargoCapacity() { return cargoCapacity; }

    @Override
    public void setTransmissionType(String type) {
        if (!type.equalsIgnoreCase("Manual") &&
            !type.equalsIgnoreCase("Automatic")) {
            throw new IllegalArgumentException("Invalid transmission type.");
        }
        this.transmissionType = type;
    }

    @Override
    public String getTransmissionType() { return transmissionType; }

    @Override
    public String toString() {
        return "Truck: " + make + " " + model + " (" + year + "), " +
                cargoCapacity + " tons, Transmission: " + transmissionType;
    }
}
