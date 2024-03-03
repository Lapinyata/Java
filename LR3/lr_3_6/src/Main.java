import java.util.Objects;
import java.util.Arrays;

/*
    Создать объект класса Пианино, используя класс Клавиша.
    Методы: настроить, играть на пианино, нажимать клавишу.
*/

class Piano {
    private String brand;
    private Key[] keys;

    public Piano(String brand, Key[] keys) {
        this.brand = brand;
        this.keys = keys;
    }

    public void tune() {
        System.out.println("Piano is tuned.");
    }

    public void play() {
        System.out.println("Playing the piano.");
    }

    public void pressKey(int keyIndex) {
        if (keyIndex >= 0 && keyIndex < keys.length) {
            System.out.println("Key " + keys[keyIndex].getNote() + " is pressed.");
        } else {
            System.out.println("Invalid key index.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Piano piano = (Piano) obj;
        return brand.equals(piano.brand) && Arrays.equals(keys, piano.keys);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(brand);
        result = 31 * result + Arrays.hashCode(keys);
        return result;
    }

    @Override
    public String toString() {
        return "Piano{" +
                "brand='" + brand + '\'' +
                ", keys=" + Arrays.toString(keys) +
                '}';
    }
}

class Key {
    private String note;

    public Key(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Key key = (Key) obj;
        return note.equals(key.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(note);
    }

    @Override
    public String toString() {
        return "Key{" +
                "note='" + note + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Key key1 = new Key("C");
        Key key2 = new Key("D");

        Key[] keys = {key1, key2};

        Piano piano = new Piano("Yamaha", keys);

        piano.tune();
        piano.play();
        piano.pressKey(0);

        System.out.println(key1.equals(key2));
        System.out.println(key1.hashCode());
        System.out.println(key1.toString());

        System.out.println(piano.equals(new Piano("Yamaha", keys)));
        System.out.println(piano.hashCode());
        System.out.println(piano.toString());
    }
}