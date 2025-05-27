// Car class definition
class Car {
    // Attributes
    String make;
    String model;
    int year;

    // Constructor to initialize attributes
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Method to display car details
    public void displayDetails() {
        System.out.println("Car Make: " + make);
        System.out.println("Car Model: " + model);
        System.out.println("Manufacture Year: " + year);
        System.out.println();
    }
}

public class CarDemo {
    public static void main(String[] args) {
        // Creating Car objects
        Car car1 = new Car("Toyota", "Corolla", 2020);
        Car car2 = new Car("Honda", "Civic", 2018);

        // Calling method to display details
        car1.displayDetails();
        car2.displayDetails();
    }
}
