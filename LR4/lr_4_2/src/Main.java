import java.util.ArrayList;

/*
    Создать класс Park (парк) с внутренним классом, с помощью объектов которого
    можно хранить информацию об аттракционах, времени их работы и стоимости.
*/
class Park {
    private String name;
    private Attractions attractions;

    public Park(String name) {
        this.name = name;
        this.attractions = new Attractions();
    }

    public Attractions getAttractions() {
        return this.attractions;
    }

    public void displayInfo() {
        System.out.println("Park: " + name);
        System.out.println("List of attractions: " + attractions.attractions_list);
    }

    class Attractions {
        private ArrayList<String> attractions_list = new ArrayList<>();

        public void addAttraction(String attraction) {
            this.attractions_list.add(attraction);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Park park = new Park("DisneyLand");

        Park.Attractions parkAttractions = park.getAttractions();
        parkAttractions.addAttraction("roller coaster");
        parkAttractions.addAttraction("ferris wheel");
        parkAttractions.addAttraction("house of horror");

        park.displayInfo();
    }
}