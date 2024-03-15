import java.util.Scanner;
import java.util.InputMismatchException;
/*
    Выполнить задания на основе варианта 1 лабораторной работы 3, контролируя
    состояние потоков ввода/вывода. При возникновении ошибок, связанных с корректностью
    выполнения математических операций, генерировать и обрабатывать исключительные ситуации.
    Предусмотреть обработку исключений, возникающих при нехватке памяти, отсутствии
    требуемой записи (объекта) в файле, недопустимом значении поля и т.д.
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

    public double[] findRoots() {
        double discriminant = b * b - 4 * a * c;
        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            return new double[]{root1, root2};
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            return new double[]{root};
        } else {
            return new double[0];
        }
    }

    public double findExtremePoint() {
        return -b / (2 * a);
    }

    public String findInterval() {
        if (a > 0) {
            return "(-∞, " + findExtremePoint() + "]";
        } else if (a < 0) {
            return "[" + findExtremePoint() + ", +∞)";
        } else {
            return "The coefficient 'a' must be non-zero.";
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the number of quadratic equations: ");
            int n = scanner.nextInt();
            QuadraticEquation[] equations = new QuadraticEquation[n];

            for (int i = 0; i < n; i++) {
                System.out.print("Enter coefficients for equation " + (i + 1) + " (a b c): ");
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                double c = scanner.nextDouble();
                equations[i] = new QuadraticEquation(a, b, c);
            }

            double maxRoot = Double.NEGATIVE_INFINITY;
            double minRoot = Double.POSITIVE_INFINITY;

            for (QuadraticEquation equation : equations) {
                double[] roots = equation.findRoots();
                for (double root : roots) {
                    if (!Double.isNaN(root)) {
                        maxRoot = Math.max(maxRoot, root);
                        minRoot = Math.min(minRoot, root);
                    }
                }
            }

            System.out.println("The largest root is: " + maxRoot);
            System.out.println("The smallest root is: " + minRoot);
        } catch (InputMismatchException e) {
            System.out.println("Неверный тип данных");
        } catch (OutOfMemoryError e) {
            System.out.println("Оперативка исчерпана");
        }
    }
}