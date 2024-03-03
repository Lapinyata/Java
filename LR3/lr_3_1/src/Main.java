import java.util.Scanner;

/*
    Определить класс Дробь в виде пары (m,n). Класс должен
    содержать несколько конструкторов. Реализовать методы для сложения,
    вычитания, умножения и деления дробей. Объявить массив из k дробей,
    ввести/вывести значения для массива дробей. Создать массив объектов
    и передать его в метод, который изменяет каждый элемент массива
    с четным индексом путем добавления следующего за ним элемента массива
*/

class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator != 0) {
            this.denominator = denominator;
        } else {
            System.out.println("Знаменатель не может быть равен нулю. Устанавливаю значение по умолчанию (1).");
            this.denominator = 1;
        }
    }

    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction subtract(Fraction other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            System.out.println("Деление на ноль. Возвращаю дробь (0/1).");
            return new Fraction(0, 1);
        }

        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    public String toString() {
        return this.numerator + "/" + this.denominator;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите k: ");
        int k = scanner.nextInt(); // Количество дробей в массиве

        Fraction[] fractions = new Fraction[k];

        // Ввод значений для массива дробей
        System.out.println("Введите дроби:");
        for (int i = 0; i < k; i++) {
            System.out.println("Числитель "+i+"-й "+"дроби: ");
            int m = scanner.nextInt();
            System.out.println("Знаменатель "+i+"-й "+"дроби: ");
            int o = scanner.nextInt();
            fractions[i] = new Fraction(m, o); // Пример значений для дробей
        }

        // Вывод значений массива дробей
        System.out.println("Исходные дроби:");
        for (int i = 0; i < k; i++) {
            System.out.println(fractions[i].toString());
        }

        modifyArray(fractions);

        // Вывод измененных дробей
        System.out.println("\nИзмененные дроби:");
        for (int i = 0; i < k; i++) {
            System.out.println(fractions[i].toString());
        }
    }

    public static void modifyArray(Fraction[] fractions) {
        for (int i = 0; i < fractions.length - 1; i += 2) {
            fractions[i] = fractions[i].add(fractions[i+1]);
        }
    }
}