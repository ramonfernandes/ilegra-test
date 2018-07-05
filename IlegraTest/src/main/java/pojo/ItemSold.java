package pojo;

public class ItemSold {
    private int itemId;
    private int itemQuantity;
    private double price;

    public ItemSold(int itemId, int itemQuantity, double price) {
        this.itemId = itemId;
        this.itemQuantity = itemQuantity;
        this.price = price;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public double getPrice() {
        return price;
    }
}
