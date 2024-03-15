import java.util.Arrays;
import java.util.List;

/*
    Задана коллекция чисел. Вернуть сумму нечетных чисел.
 */

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sumOfOddNumbers = numbers.stream()
                .filter(num -> num % 2 != 0)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Сумма нечетных чисел: " + sumOfOddNumbers);
    }
}