/*
	interface Мебель <- abstract class Шкаф <- class Книжный Шкаф
 */

// Интерфейс Furniture
interface Furniture {
    void description();
}

// Абстрактный класс Closet реализует интерфейс Furniture
abstract class Closet implements Furniture {
    @Override
    public void description() {
        System.out.println("This is a closet.");
    }

    abstract void type();
}

// Класс Bookshelf наследует от абстрактного класса Closet
class Bookshelf extends Closet {
    @Override
    void type() {
        System.out.println("This is a bookshelf.");
    }
}

public class Main {
    public static void main(String[] args) {
        Furniture bookshelf = new Bookshelf();

        bookshelf.description();
        ((Closet) bookshelf).type(); // Приведение типа для вызова метода type()
    }
}