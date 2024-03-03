import java.util.Arrays;
import java.util.Objects;

/*
    Создать объект класса Дерево, используя классы Лист.
    Методы: зацвести, опасть листьям, покрыться инеем, пожелтеть листьям.
*/

class Tree {
    private Leaf[] leaves;

    public Tree(Leaf[] leaves) {
        this.leaves = leaves;
    }

    public void blossom() {
        System.out.println("The tree is blooming.");
    }

    public void fallLeaves() {
        System.out.println("Leaves are falling.");
    }

    public void coverWithHoarfrost() {
        System.out.println("The tree is covered with hoarfrost.");
    }

    public void turnYellow() {
        for (Leaf leaf : leaves) {
            leaf.setColor("yellow");
        }
        System.out.println("Leaves are turning yellow.");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Tree tree = (Tree) obj;
        return Arrays.equals(leaves, tree.leaves);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(leaves);
    }

    @Override
    public String toString() {
        return "Tree{" +
                "leaves=" + Arrays.toString(leaves) +
                '}';
    }
}

class Leaf {
    private String color;

    public Leaf(String color) {
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Leaf leaf = (Leaf) obj;
        return color.equals(leaf.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }

    @Override
    public String toString() {
        return "Leaf{" +
                "color='" + color + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Leaf leaf1 = new Leaf("green");
        Leaf leaf2 = new Leaf("red");

        Leaf[] leaves = {leaf1, leaf2};

        Tree tree = new Tree(leaves);

        tree.blossom();
        tree.fallLeaves();
        tree.coverWithHoarfrost();

        System.out.println(leaf1.equals(leaf2));

        tree.turnYellow();

        System.out.println(leaf1.hashCode());
        System.out.println(leaf1.toString());

        System.out.println(tree.equals(new Tree(leaves)));
        System.out.println(tree.hashCode());
        System.out.println(tree.toString());
    }
}