package com.patty3130;

import java.util.ArrayList;

public class Warehouse {
    private String warehouseName;
    private ArrayList<Item> items;

    public Warehouse(String warehouseName, ArrayList<Item> items) {
        this.warehouseName = warehouseName;
        this.items = items;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void processWarehouseShipment(String[] lineArray){
        if (warehouseName.equals(lineArray[1])){
            System.out.print("After shipment, CURRENT INVENTORY totals for " + warehouseName + ": ");
            int itemCounter = 0;
            for (Item item : items){
                int amtInStock = item.getAmountInStock();
                int amtReadIn = Integer.parseInt(lineArray[itemCounter+2]);
                item.setAmountInStock(amtInStock + amtReadIn);
                System.out.print(item.getAmountInStock() + "  ");
                itemCounter++;
            }
            System.out.println("\n");
        }
    }

    private void printAmtInStock(boolean before){
        String status;
        if (before){
            status = "BEFORE";
        } else {
            status = "AFTER";
        }
        System.out.print("Inventory for " + warehouseName + " " + status + " order: ");
        for(Item item : items){
            System.out.print(item.getAmountInStock() + "  ");
        }
        System.out.print("\n");
    }

    public void processWarehouseOrder(String[] lineArray, Warehouse warehouse, Record record){
        if (warehouseName.equals(lineArray[1])){
            double totalPrice = 0;
            printAmtInStock(true);
            int itemCounter = 0;
            boolean filled = false;
            for (Item item : items){
                int amtInStock = item.getAmountInStock();
                int amountOrdered = Integer.parseInt(lineArray[itemCounter+2]);

                // If not enough inventory is on hand at other warehouses, the order
                // for the particular item(s) that are out of stock is/are not filled.
                if (amountOrdered > amtInStock){
                    if(!record.searchWarehouses(amountOrdered - amtInStock, item, warehouse)){
                        System.out.println("Order for " + item.getItemName() + " not Filled.");
                    } else {
                        filled = true;
                        // If ordered item is out of stock and needs to ship from a separate city,
                        // charge an additional 10%
                        System.out.println(amountOrdered + " total units processed at $" + item.getPrice() +
                                " each. Plus 10% city to city shipment charge" +
                                " for an item total of $ " + Math.round((item.getPrice()
                                *amountOrdered*1.1) * 100.0) / 100.0);
                        totalPrice += (item.getPrice() * 1.1 * amountOrdered);
                    }
                } else {
                    filled = true;
                    item.setAmountInStock(amtInStock - amountOrdered);
                    System.out.println("Order for " + item.getItemName() + " has been filled. " +
                            amountOrdered + " units processed at $ " + item.getPrice() +
                            " each for an item total of $ " + (item.getPrice() * amountOrdered));
                    totalPrice += (item.getPrice() * amountOrdered);
                }
                itemCounter++;
            }
            printAmtInStock(false);
            if (filled) {
                System.out.println("______________");
                System.out.println("Price of order: $ " + Math.round(totalPrice * 100.0) / 100.0);
            }
        }
    }
}
