package com.patty3130;

public class Item {
    private double price;
    private String itemName;
    private int amountInStock;

    public Item() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getAmountInStock() {
        return amountInStock;
    }

    public void setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
    }

    @Override
    public String toString() {
        return "Item{" +
                "price=" + price +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
