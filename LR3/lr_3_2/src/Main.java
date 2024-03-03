import java.util.Arrays;

/*
    9.	Определить класс Квадратное уравнение. Класс должен содержать
    несколько конструкторов. Реализовать методы для поиска корней,
    экстремумов, а также интервалов убывания/возрастания. Создать массив
    объектов и определить наибольшие и наименьшие по значению корни.
*/

class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public QuadraticEquation(double a, double b) {
        this(a, b, 0);
    }

    public QuadraticEquation(double a) {
        this(a, 0, 0);
    }

    public double[] findRoots() {
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            return new double[] {root1, root2};
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            return new double[] {root};
        } else {
            return new double[0]; // No real roots
        }
    }

    public double findExtremePoint() {
        return -b / (2 * a);
    }

    public String findIncreasingInterval() {
        return a > 0 ? "(-∞, " + findExtremePoint() + ")" : "(" + findExtremePoint() + ", +∞)";
    }

    public String findDecreasingInterval() {
        return a > 0 ? "(" + findExtremePoint() + ", +∞)" : "(-∞, " + findExtremePoint() + ")";
    }
}

public class Main {
    public static void main(String[] args) {
        int k = 3; // Количество квадратных уравнений в массиве

        QuadraticEquation[] equations = new QuadraticEquation[k];

        // Ввод значений для массива квадратных уравнений
        equations[0] = new QuadraticEquation(1, -3, 2); // x^2 - 3x + 2
        equations[1] = new QuadraticEquation(1, -2);     // x^2 - 2x
        equations[2] = new QuadraticEquation(1);         // x^2

        // Вывод корней для каждого уравнения
        for (int i = 0; i < k; i++) {
            double[] roots = equations[i].findRoots();
            System.out.println("Корни уравнения " + (i+1) + ": " + Arrays.toString(roots));
        }

        // Нахождение наибольшего и наименьшего корней
        double maxRoot = Double.MIN_VALUE;
        double minRoot = Double.MAX_VALUE;

        for (int i = 0; i < k; i++) {
            double[] roots = equations[i].findRoots();
            for (double root : roots) {
                if (root > maxRoot) {
                    maxRoot = root;
                }
                if (root < minRoot) {
                    minRoot = root;
                }
            }
        }

        System.out.println("\nНаибольший корень: " + maxRoot);
        System.out.println("Наименьший корень: " + minRoot);
    }
}