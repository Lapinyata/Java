/*
    Создать класс Computer (компьютер) с внутренним классом, с помощью объектов
    которого можно хранить информацию об операционной системе, процессоре
    и оперативной памяти.
*/
class Computer {
    private String brand;
    private String model;
    private Specs specs;

    public Computer(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.specs = new Specs();
    }

    public Specs getSpecs() {
        return this.specs;
    }

    public void displayInfo() {
        System.out.println("Computer: " + brand + " " + model);
        System.out.println("Operating System: " + specs.operatingSystem);
        System.out.println("Processor: " + specs.processor);
        System.out.println("RAM: " + specs.ram + "GB");
    }

    class Specs {
        private String operatingSystem;
        private String processor;
        private int ram;

        public void setOperatingSystem(String operatingSystem) {
            this.operatingSystem = operatingSystem;
        }

        public void setProcessor(String processor) {
            this.processor = processor;
        }

        public void setRam(int ram) {
            this.ram = ram;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Computer myComputer = new Computer("Dell", "Inspiron");

        Computer.Specs myComputerSpecs = myComputer.getSpecs();
        myComputerSpecs.setOperatingSystem("Windows 10");
        myComputerSpecs.setProcessor("Intel Core i5");
        myComputerSpecs.setRam(8);

        myComputer.displayInfo();
    }
}