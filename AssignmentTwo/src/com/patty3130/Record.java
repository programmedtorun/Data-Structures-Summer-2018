package com.patty3130;

import java.util.ArrayList;

public class Record {
    private ArrayList<Warehouse> warehouses;

    public Record(ArrayList<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    public void processLine(String[] lineArray, Record record){
        if (lineArray[0].equals("S")){
            processShipment(lineArray);
        } else if (lineArray[0].equals("O")){
            processOrder(lineArray, record);
        }
    }

    private void processShipment(String[] lineArray) {
        printOutInitialCard(lineArray);
        for (Warehouse wh : warehouses) {
            wh.processWarehouseShipment(lineArray);
        }
    }

    private void processOrder(String[] lineArray, Record record){
        printOutInitialCard(lineArray);
        for (Warehouse wh : warehouses) {
            wh.processWarehouseOrder(lineArray, wh, record);
        }
    }

    private void printOutInitialCard(String[] lineArray){
        String type = "";
        if(lineArray[0].equals("S")){
            type = "SHIPMENT";
        } else if(lineArray[0].equals("O")){
            type = "RETAIL ORDER";
        }
        System.out.println("Reading in a " + type + " for " + lineArray[1] +
                " containing: " + lineArray[2] + " TESLAS, " +
                lineArray[3] + " NISSAN GT-RS, AND " + lineArray[4]
                + " AUDI R8S.");
    }

    public boolean searchWarehouses(int amtNeeded, Item itemInNeed, Warehouse whInNeed){

        // Can't take inventory from warehouse in need
        ArrayList<Warehouse> whList = new ArrayList<>(warehouses);
        whList.remove(whInNeed);

        int mostInStock = 0;
        Warehouse whWithMost = whInNeed;

        for (Warehouse wh : whList){
            for (Item item: wh.getItems()){
                if (itemInNeed.getItemName().equals(item.getItemName())){

                    // Finding the warehouse with the most in stock
                    if (mostInStock < (item.getAmountInStock() - amtNeeded)) {
                        mostInStock = item.getAmountInStock() - amtNeeded;
                        whWithMost = wh;
                    }
                }
            }
        }
        if(mostInStock > 0 && whWithMost != whInNeed){
            for (Item item : whWithMost.getItems()){
                if(item.getItemName().equals(itemInNeed.getItemName())){
                    item.setAmountInStock(mostInStock);
                    itemInNeed.setAmountInStock(0);
                }
            }
            System.out.print(amtNeeded + " of the " + itemInNeed.getItemName() +
                    " sent from " + whWithMost.getWarehouseName() +
                    " to " + whInNeed.getWarehouseName() + ". ");
            return true;
        } else {
            return false;
        }
    }
}
