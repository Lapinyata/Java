import java.util.Scanner;

/*
    9. Используя оператор switch, написать программу, которая
    выводит на экран сообщения о принадлежности некоторого
    значения k интервалам (-10k, 0], (0, 5], (5, 10], (10, 10k].
*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите значение k: ");
        int k = scanner.nextInt();

        switch (k) {
            case 0:
                System.out.println(k + " принадлежит интервалу (-10k, 0]");
                break;
            case 5:
                System.out.println(k + " принадлежит интервалу (0, 5]");
                break;
            case 10:
                System.out.println(k + " принадлежит интервалу (5, 10]");
                break;
            default:
                if (k < 0) {
                    System.out.println(k + " принадлежит интервалу (-10k, 0]");
                } else if (k > 10) {
                    System.out.println(k + " принадлежит интервалу (10, 10k]");
                } else {
                    System.out.println("Значение " + k + " не принадлежит заданным интервалам.");
                }
        }

        scanner.close();
    }
}