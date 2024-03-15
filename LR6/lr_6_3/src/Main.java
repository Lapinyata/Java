import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

/*
    На плоскости задано N отрезков. Найти точку пересечения
    двух отрезков, имеющую минимальную абсциссу. Использовать класс TreeMap.
 */

class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Line {
    Point start;
    Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public double slope() {
        return (end.y - start.y) / (end.x - start.x);
    }

    public double intercept() {
        return start.y - slope() * start.x;
    }

    public Point intersection(Line other) {
        double x = (other.intercept() - this.intercept()) / (this.slope() - other.slope());
        double y = this.slope() * x + this.intercept();
        return new Point(x, y);
    }
}

public class Main {

    public static void main(String[] args) {
        Line[] lines = {
                new Line(new Point(1, 1), new Point(3, 2)),
                new Line(new Point(2, 3), new Point(4, 1)),
                new Line(new Point(0, 4), new Point(5, 0))
        };

        TreeMap<Double, Point> intersections = new TreeMap<>();

        for (int i = 0; i < lines.length; i++) {
            for (int j = i + 1; j < lines.length; j++) {
                Point intersection = lines[i].intersection(lines[j]);
                intersections.put(intersection.x, intersection);
            }
        }

        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write("Point of intersection with minimum abscissa: (" + intersections.firstEntry().getValue().x + ", " + intersections.firstEntry().getValue().y + ")\n");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}