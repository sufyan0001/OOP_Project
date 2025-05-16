import java.util.ArrayList;
import java.util.Scanner;

class Car {
    String make;
    String model;
    int year;
    double price;
    String carType;

    public Car(String make, String model, int year, double price, String carType) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.carType = carType;
    }
}

public class CarShowroom {
    static ArrayList<Car> carInventory = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void addCar(String make, String model, int year, double price, String carType) {
        Car newCar = new Car(make, model, year, price, carType);
        carInventory.add(newCar);
        System.out.println("Car added successfully.");
    }

    public static void displayInventory() {
        if (carInventory.isEmpty()) {
            System.out.println("No cars available in the showroom.");
        } else {
            for (Car car : carInventory) {
                System.out.println("Make: " + car.make + ", Model: " + car.model +
                        ", Year: " + car.year + ", Price: $" + car.price + ", Type: " + car.carType);
            }
        }
    }

    public static void findCar(String make, String model) {
        for (Car car : carInventory) {
            if (car.make.equalsIgnoreCase(make) && car.model.equalsIgnoreCase(model)) {
                System.out.println("Car found in the showroom - Make: " + car.make +
                        ", Model: " + car.model + ", Year: " + car.year +
                        ", Price: $" + car.price + ", Type: " + car.carType);
                return;
            }
        }
        System.out.println("Car not found in the showroom.");
    }

    public static void filterCarsByTypeAndPrice(String type, double minPrice, double maxPrice) {
        boolean found = false;
        for (Car car : carInventory) {
            if (car.carType.equalsIgnoreCase(type) && car.price >= minPrice && car.price <= maxPrice) {
                System.out.println("Make: " + car.make + ", Model: " + car.model +
                        ", Year: " + car.year + ", Price: $" + car.price + ", Type: " + car.carType);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching cars found in the showroom.");
        }
    }

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("Welcome to the Car Showroom!");
            System.out.println("1. Add Car");
            System.out.println("2. Display Inventory");
            System.out.println("3. Find Car");
            System.out.println("4. Filter Cars by Type and Price");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    System.out.print("Enter make: ");
                    String make = scanner.nextLine();
                    System.out.print("Enter model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter type (sedan, suv, hatchback): ");
                    String carType = scanner.nextLine();
                    addCar(make, model, year, price, carType);
                    break;
                case 2:
                    displayInventory();
                    break;
                case 3:
                    System.out.print("Enter make to find: ");
                    make = scanner.nextLine();
                    System.out.print("Enter model to find: ");
                    model = scanner.nextLine();
                    findCar(make, model);
                    break;
                case 4:
                    System.out.print("Enter type to filter: ");
                    String type = scanner.nextLine();
                    System.out.print("Enter minimum price: ");
                    double minPrice = scanner.nextDouble();
                    System.out.print("Enter maximum price: ");
                    double maxPrice = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    filterCarsByTypeAndPrice(type, minPrice, maxPrice);
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 5);
    }
}
