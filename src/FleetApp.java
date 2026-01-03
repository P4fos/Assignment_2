import java.util.ArrayList;
import java.util.Scanner;

public class FleetApp {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        FleetApp app = new FleetApp();
        app.run();
    }

    public void run() {
        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.next();
            scanner.nextLine();

            switch (choice) {
                case "1":
                    printAllVehicles();
                    break;
                case "2":
                    addCar();
                    break;
                case "3":
                    addBus();
                    break;
                case "4":
                    showTotalInsurance();
                    break;
                case "5":
                    showVehiclesOlderThan();
                    break;
                case "6":
                    performServiceAll();
                    break;
                case "7":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }

    private void printMenu() {
        System.out.println("--- Fleet Management System ---");
        System.out.println("1. Print all vehicles");
        System.out.println("2. Add new car");
        System.out.println("3. Add new bus");
        System.out.println("4. Show total yearly insurance fees");
        System.out.println("5. Show vehicles older than N years");
        System.out.println("6. Perform service for all vehicles");
        System.out.println("7. Quit");
    }

    private void printAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the fleet.");
        } else {
            for (Vehicle v : vehicles) {
                System.out.println(v.toString());
            }
        }
    }

    private void addCar() {
        try {
            System.out.print("Enter Model: ");
            String model = scanner.nextLine();
            System.out.print("Enter Year: ");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter Base Price: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter Number of Doors: ");
            int doors = Integer.parseInt(scanner.nextLine());

            Vehicle newCar = new Car(model, year, price, doors);
            vehicles.add(newCar);
            System.out.println("Car added successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void addBus() {
        try {
            System.out.print("Enter Model: ");
            String model = scanner.nextLine();
            System.out.print("Enter Year: ");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter Base Price: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter Passenger Capacity: ");
            int capacity = Integer.parseInt(scanner.nextLine());

            Vehicle newBus = new Bus(model, year, price, capacity);
            vehicles.add(newBus);
            System.out.println("Bus added successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void showTotalInsurance() {
        double total = 0;
        for (Vehicle v : vehicles) {
            total += v.calculateInsuranceFee();
        }
        System.out.printf("Total yearly insurance fees: $%.2f%n", total);
    }

    private void showVehiclesOlderThan() {
        try {
            System.out.print("Enter current year: ");
            int currentYear = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter age limit (N): ");
            int n = Integer.parseInt(scanner.nextLine());

            System.out.println("Vehicles older than " + n + " years:");
            boolean found = false;
            for (Vehicle v : vehicles) {
                if (v.getAge(currentYear) > n) {
                    System.out.println(v);
                    found = true;
                }
            }
            if (!found) System.out.println("None found.");

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input.");
        }
    }

    private void performServiceAll() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles to service.");
            return;
        }
        System.out.println("Performing service for fleet:");
        for (Vehicle v : vehicles) {
            v.performService();
            System.out.println("Next service in: " + v.getServiceIntervalKm() + " km");
        }
    }
}