import java.util.ArrayList;
import java.util.List;

/*
    Система Автобаза. Диспетчер распределяет заявки на Рейсы между Водителями
    и назначает для этого Автомобиль. Водитель может сделать заявку на ремонт.
    Диспетчер может отстранить Водителя от работы. Водитель делает отметку
    о выполнении Рейса и состоянии Автомобиля.
*/

class Dispatcher {
    private List<Driver> drivers;
    private List<Car> cars;
    private List<Trip> trips;

    public Dispatcher(List<Driver> drivers, List<Car> cars, List<Trip> trips) {
        this.drivers = drivers;
        this.cars = cars;
        this.trips = trips;
    }

    public void assignTrip(Driver driver, Trip trip, Car car) {
        if (drivers.contains(driver) && cars.contains(car)) {
            driver.setCar(car);
            trips.add(trip);
            System.out.println("Trip assigned to driver: " + driver.getName());
        } else {
            System.out.println("Driver or car not found.");
        }
    }

    public void suspendDriver(Driver driver) {
        if (drivers.contains(driver)) {
            driver.setSuspended(true);
            System.out.println("Driver suspended: " + driver.getName());
        } else {
            System.out.println("Driver not found.");
        }
    }
}

class Driver {
    private String name;
    private Car car;
    private boolean suspended;

    public Driver(String name) {
        this.name = name;
        this.suspended = false;
    }

    public void makeRepairRequest() {
        System.out.println("Repair request made by driver: " + name);
    }

    public void makeTripReport(Trip trip, String carCondition) {
        System.out.println("Trip report submitted by driver: " + name);
        trip.setCompleted(true);
        car.setCarCondition(carCondition);
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }

    public String getName() {
        return name;
    }
}

class Car {
    private String model;

    private String carCondition;

    public Car(String model) {
        this.model = model;
        this.carCondition = "";
    }

    public void setCarCondition(String carCondition) {
        this.carCondition = carCondition;
    }
}

class Trip {
    private boolean completed;

    public Trip() {
        this.completed = false;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

public class Main {
    public static void main(String[] args) {
        Driver driver1 = new Driver("John");
        Driver driver2 = new Driver("Alice");

        Car car1 = new Car("Toyota");
        Car car2 = new Car("Ford");

        List<Driver> drivers = new ArrayList<>();
        drivers.add(driver1);
        drivers.add(driver2);

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);

        List<Trip> trips = new ArrayList<>();

        Dispatcher dispatcher = new Dispatcher(drivers, cars, trips);

        Trip trip1 = new Trip();
        dispatcher.assignTrip(driver1, trip1, car1);

        driver1.makeRepairRequest();

        driver1.makeTripReport(trip1, "Good condition");

        dispatcher.suspendDriver(driver2);
    }
}