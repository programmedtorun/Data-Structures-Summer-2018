package com.udemy.data.structures;

public class WidgetNode {
    private int quantity;
    private double price;
    private WidgetNode next;

    WidgetNode(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }

    int getQuantity() {
        return quantity;
    }

    double getPrice() {
        return price;
    }

    void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    WidgetNode getNext() {
        return next;
    }

    void setNext(WidgetNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "WidgetNode{" +
                "quantity=" + quantity +
                '}';
    }

    double printSales(double promo, int quantity){
        double totalSales = quantity * 1.3 * price * (1 - promo);
        System.out.println(quantity + " at "
                + Math.round( (1.3 * price * (1 - promo)) * 100.0) / 100.0 +
                " each - \tSales: $" + totalSales + (promo > 0 ? ", this " +
                "includes a promotional discount of " + promo * 100 + "%" : " "));
        return totalSales;
    }
}
