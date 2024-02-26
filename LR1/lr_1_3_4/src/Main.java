import java.util.Scanner;

/*
    Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести:
    3. Числа, которые делятся на 3 или на 9.
    4. Числа, которые делятся на 5 и на 7.
*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество целых чисел:");
        int n = scanner.nextInt();

        int[] numbers = new int[n];

        System.out.println("Введите целые числа:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println("Числа, которые делятся на 3 или на 9:");
        for (int number : numbers) {
            if (number % 3 == 0) {
                System.out.print(number + " ");
            }
        }

        System.out.println("\nЧисла, которые делятся на 5 и на 7:");
        for (int number : numbers) {
            if (number % 5 == 0 && number % 7 == 0) {
                System.out.print(number + " ");
            }
        }

    }
}