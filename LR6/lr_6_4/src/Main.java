import java.util.Stack;

/*
    Дана матрица из целых чисел. Найти в ней прямоугольную подматрицу, состоящую из
    максимального количества одинаковых элементов. Использовать класс Stack.
 */

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 2, 2},
                {2, 2, 2, 2},
                {2, 2, 2, 2}
        };

        int maxCount = 0;

        for (int i = 0; i < matrix.length; i++) {
            int[] hist = new int[matrix[i].length];
            for (int j = i; j < matrix.length; j++) {
                for (int k = 0; k < matrix[j].length; k++) {
                    if (matrix[j][k] == matrix[i][k]) {
                        hist[k]++;
                    } else {
                        hist[k] = 0;
                    }
                }

                Stack<Integer> stack = new Stack<>();
                int count = 0;
                for (int h : hist) {
                    while (!stack.isEmpty() && hist[stack.peek()] >= h) {
                        int height = hist[stack.pop()];
                        int width = stack.isEmpty() ? count : count - stack.peek() - 1;
                        maxCount = Math.max(maxCount, height * width);
                    }
                    stack.push(count++);
                }
                while (!stack.isEmpty()) {
                    int height = hist[stack.pop()];
                    int width = stack.isEmpty() ? count : count - stack.peek() - 1;
                    maxCount = Math.max(maxCount, height * width);
                }
            }
        }

        System.out.println("Максимальное количество одинаковых элементов: " + maxCount);
    }
}