import java.util.*;

public class VehicleSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Vehicle> vehicles = new ArrayList<>();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Vehicle Information System ---");
            System.out.println("1. Add Car");
            System.out.println("2. Add Motorcycle");
            System.out.println("3. Add Truck");
            System.out.println("4. View All Vehicles");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter make: ");
                        String cmake = sc.nextLine();
                        System.out.print("Enter model: ");
                        String cmodel = sc.nextLine();
                        System.out.print("Enter year: ");
                        int cyear = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter number of doors: ");
                        int doors = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter fuel type (Petrol/Diesel/Electric): ");
                        String fuel = sc.nextLine();
                        vehicles.add(new Car(cmake, cmodel, cyear, doors, fuel));
                        System.out.println("Car added successfully!");
                        break;

                    case 2:
                        System.out.print("Enter make: ");
                        String mmake = sc.nextLine();
                        System.out.print("Enter model: ");
                        String mmodel = sc.nextLine();
                        System.out.print("Enter year: ");
                        int myear = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter number of wheels: ");
                        int wheels = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter motorcycle type (Sport/Cruiser/Off-road): ");
                        String mtype = sc.nextLine();
                        vehicles.add(new Motorcycle(mmake, mmodel, myear, wheels, mtype));
                        System.out.println("Motorcycle added successfully!");
                        break;

                    case 3:
                        System.out.print("Enter make: ");
                        String tmake = sc.nextLine();
                        System.out.print("Enter model: ");
                        String tmodel = sc.nextLine();
                        System.out.print("Enter year: ");
                        int tyear = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter cargo capacity in tons: ");
                        double capacity = Double.parseDouble(sc.nextLine());
                        System.out.print("Enter transmission type (Manual/Automatic): ");
                        String ttrans = sc.nextLine();
                        vehicles.add(new Truck(tmake, tmodel, tyear, capacity, ttrans));
                        System.out.println("Truck added successfully!");
                        break;

                    case 4:
                        System.out.println("\n--- Vehicle List ---");
                        if (vehicles.isEmpty()) {
                            System.out.println("No vehicles added yet.");
                        } else {
                            for (Vehicle v : vehicles) {
                                System.out.println(v.toString());
                            }
                        }
                        break;

                    case 5:
                        exit = true;
                        System.out.println("Exiting Vehicle System. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input format. Please enter correct numbers.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();
    }
}
