/*
    interface Корабль <- class Грузовой Корабль <- class Танкер.
*/

// Интерфейс Ship
interface Ship {
    void sail();
}

// Класс CargoShip реализует интерфейс Ship
class CargoShip implements Ship {
    @Override
    public void sail() {
        System.out.println("Cargo ship is sailing.");
    }
}

// Класс Tanker наследует от CargoShip
class Tanker extends CargoShip {
    @Override
    public void sail() {
        System.out.println("Tanker is sailing.");
    }
}

public class Main {
    public static void main(String[] args) {
        Ship cargoShip = new CargoShip();
        Ship tanker = new Tanker();

        cargoShip.sail();
        tanker.sail();
    }
}