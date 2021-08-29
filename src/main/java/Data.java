import java.util.HashMap;

public class Data {

    private static final HashMap<String, Item> mapItems = new HashMap<>();

    public static String addItem(String name, Item obj) {
        mapItems.put(name, obj);
        return "Added "+ name;
    }

    public static Object getItem(String key) {
        return mapItems.get(key);
    }

    //TODO: Implement File output for object data
    public static void saveData() {

    }

    //TODO: Implement File input for object data
    public static void loadData() {

    }

}
