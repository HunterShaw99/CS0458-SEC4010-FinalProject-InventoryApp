public class Item {

    private String name;
    private int quantity;

    public Item(String name, int quantity) {
        this.setName(name);
        this.setQuantity(quantity);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name= '" + name + '\'' +
                ", quantity= '" + quantity + '\'' +
                '}';
    }
}
