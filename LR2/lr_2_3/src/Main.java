import java.util.Scanner;

/*
    8. Вычислить определитель матрицы.
*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер матрицы (n): ");
        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];

        System.out.println("Введите элементы матрицы:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int determinant = calculateDeterminant(matrix);

        System.out.println("Определитель матрицы равен: " + determinant);

        scanner.close();
    }

    public static int calculateDeterminant(int[][] matrix) {
        int n = matrix.length;
        int det = 0;

        if (n == 1) {
            return matrix[0][0];
        }

        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        for (int i = 0; i < n; i++) {
            int[][] minor = new int[n - 1][n - 1];
            for (int j = 1; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (k < i) {
                        minor[j - 1][k] = matrix[j][k];
                    } else if (k > i) {
                        minor[j - 1][k - 1] = matrix[j][k];
                    }
                }
            }
            det += Math.pow(-1, i) * matrix[0][i] * calculateDeterminant(minor);
        }

        return det;
    }
}