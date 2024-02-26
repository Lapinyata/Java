import java.util.Scanner;

/*
     8. Ввести n слов с консоли. Среди слов, состоящих только
     из цифр, найти слово-палиндром. Если таких слов больше
     одного, найти второе из них.
*/


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество слов: ");
        int n = scanner.nextInt();

        String firstPalindrome = null;
        String secondPalindrome = null;
        int palindromeCount = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Введите слово: ");
            String word = scanner.next();

            if (word.matches("[0-9]+")) { // Проверяем, состоит ли слово только из цифр
                if (isPalindrome(word)) {
                    palindromeCount++;
                    if (palindromeCount == 1) {
                        firstPalindrome = word;
                    } else if (palindromeCount == 2) {
                        secondPalindrome = word;
                        break;
                    }
                }
            }
        }

        if (secondPalindrome != null) {
            System.out.println("Второе слово-палиндром из введенных слов: " + secondPalindrome);
        } else if (firstPalindrome != null) {
            System.out.println("Единственное слово-палиндром из введенных слов: " + firstPalindrome);
        } else {
            System.out.println("Слово-палиндром среди введенных слов не найдено.");
        }

        scanner.close();
    }

    // Метод для проверки, является ли слово палиндромом
    private static boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}