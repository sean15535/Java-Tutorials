public class Motorcycle implements Vehicle, MotorVehicle {
    private String make, model, motorcycleType;
    private int year, wheels;

    public Motorcycle(String make, String model, int year, int wheels, String type) {
        this.make = make;
        this.model = model;
        this.year = year;
        setNumberOfWheels(wheels);
        setMotorcycleType(type);
    }

    @Override
    public String getMake() { return make; }

    @Override
    public String getModel() { return model; }

    @Override
    public int getYear() { return year; }

    @Override
    public void setNumberOfWheels(int wheels) {
        if (wheels < 2 || wheels > 3) {
            throw new IllegalArgumentException("Motorcycles must have 2 or 3 wheels.");
        }
        this.wheels = wheels;
    }

    @Override
    public int getNumberOfWheels() { return wheels; }

    @Override
    public void setMotorcycleType(String type) {
        if (!type.equalsIgnoreCase("Sport") &&
            !type.equalsIgnoreCase("Cruiser") &&
            !type.equalsIgnoreCase("Off-road")) {
            throw new IllegalArgumentException("Invalid motorcycle type.");
        }
        this.motorcycleType = type;
    }

    @Override
    public String getMotorcycleType() { return motorcycleType; }

    @Override
    public String toString() {
        return "Motorcycle: " + make + " " + model + " (" + year + "), " + wheels +
                " wheels, Type: " + motorcycleType;
    }
}
