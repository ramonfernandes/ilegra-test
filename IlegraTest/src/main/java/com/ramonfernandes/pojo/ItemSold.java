package com.ramonfernandes.pojo;

public class ItemSold implements FileObject {
    private int itemId;
    private int itemQuantity;
    private double price;

    @Override
    public FileObject buildObject(String[] separatedString) {
        this.itemId = Integer.parseInt(separatedString[0]);
        this.itemQuantity = Integer.parseInt(separatedString[1]);
        this.price = Double.parseDouble(separatedString[2]);
        return this;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public double getPrice() {
        return price;
    }

}
