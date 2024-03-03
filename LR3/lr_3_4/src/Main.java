import java.util.ArrayList;

/*
    Car: id, Марка, Модель, Год выпуска, Цвет, Цена, Регистрационный номер.
    Создать массив объектов. Вывести: a) список автомобилей заданной марки;
    b) список автомобилей заданной модели, которые эксплуатируются больше n лет;
    c) список автомобилей заданного года выпуска, цена которых больше указанной.
*/

class Car {
    private int id;
    private String brand;
    private String model;
    private int year;
    private String color;
    private double price;
    private String regNumber;

    public Car(int id, String brand, String model, int year, String color, double price, String regNumber) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.regNumber = regNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
        ", model='" + model + '\'' +
        ", year=" + year +
                ", color='" + color + '\'' +
        ", price=" + price +
                ", regNumber='" + regNumber +
        '}';
    }

    public static ArrayList<Car> filterByBrand(ArrayList<Car> carList, String brand) {
        ArrayList<Car> result = new ArrayList<>();
        for (Car car : carList) {
            if (car.getBrand().equalsIgnoreCase(brand)) {
                result.add(car);
            }
        }
        return result;
    }

    public static ArrayList<Car> filterByModelAndYears(ArrayList<Car> carList, String model, int years) {
        ArrayList<Car> result = new ArrayList<>();
        for (Car car : carList) {
            if (car.getModel().equalsIgnoreCase(model) && (2024 - car.getYear()) > years) {
                result.add(car);
            }
        }
        return result;
    }

    public static ArrayList<Car> filterByYearAndPrice(ArrayList<Car> carList, int year, double price) {
        ArrayList<Car> result = new ArrayList<>();
        for (Car car : carList) {
            if (car.getYear() == year && car.getPrice() > price) {
                result.add(car);
            }
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Car> carList = new ArrayList<>();

        // Добавляем данные об автомобилях в список
        carList.add(new Car(1, "Toyota", "Camry", 2018, "Black", 25000.0, "AB1234"));
        carList.add(new Car(2, "Honda", "Civic", 2015, "White", 20000.0, "CD5678"));

        // Выводим список автомобилей заданной марки
        System.out.println("Список автомобилей марки Toyota:");
        ArrayList<Car> filteredByBrand = Car.filterByBrand(carList, "Toyota");
        for (Car car : filteredByBrand) {
            System.out.println(car);
        }

        // Выводим список автомобилей заданной модели, которые эксплуатируются больше n лет
        System.out.println("\nСписок автомобилей модели Civic, которые эксплуатируются больше 5 лет:");
        ArrayList<Car> filteredByModelAndYears = Car.filterByModelAndYears(carList, "Civic", 5);
        for (Car car : filteredByModelAndYears) {
            System.out.println(car);
        }

        // Выводим список автомобилей заданного года выпуска, цена которых больше указанной
        System.out.println("\nСписок автомобилей 2018 года выпуска с ценой выше 24000:");
        ArrayList<Car> filteredByYearAndPrice = Car.filterByYearAndPrice(carList, 2018, 24000.0);
        for (Car car : filteredByYearAndPrice) {
            System.out.println(car);
        }

    }
}