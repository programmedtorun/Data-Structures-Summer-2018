package com.patty3130;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        // Creating list of Items
        ArrayList<Item> itemsChi = new ArrayList<>();
        itemsChi.add(new Item());
        itemsChi.add(new Item());
        itemsChi.add(new Item());

        ArrayList<Item> itemsLA = new ArrayList<>();
        itemsLA.add(new Item());
        itemsLA.add(new Item());
        itemsLA.add(new Item());

        ArrayList<Item> itemsMia = new ArrayList<>();
        itemsMia.add(new Item());
        itemsMia.add(new Item());
        itemsMia.add(new Item());

        ArrayList<Item> itemsNY = new ArrayList<>();
        itemsNY.add(new Item());
        itemsNY.add(new Item());
        itemsNY.add(new Item());

        ArrayList<Item> itemsHou = new ArrayList<>();
        itemsHou.add(new Item());
        itemsHou.add(new Item());
        itemsHou.add(new Item());

        // Reading in card assigning initial prices and names to Items
        File file = new File("InitialItemPricesCard.txt");
        try {
            Scanner scanner = new Scanner(file);
            int i = 0;
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(",");
                itemsChi.get(i).setItemName(line[0]);
                itemsChi.get(i).setPrice(Double.parseDouble(line[1]));
                itemsLA.get(i).setItemName(line[0]);
                itemsLA.get(i).setPrice(Double.parseDouble(line[1]));
                itemsNY.get(i).setItemName(line[0]);
                itemsNY.get(i).setPrice(Double.parseDouble(line[1]));
                itemsMia.get(i).setItemName(line[0]);
                itemsMia.get(i).setPrice(Double.parseDouble(line[1]));
                itemsHou.get(i).setItemName(line[0]);
                itemsHou.get(i).setPrice(Double.parseDouble(line[1]));
                i++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Creating Warehouses
        ArrayList<Warehouse> warehouses = new ArrayList<>();
        warehouses.add(new Warehouse("Chicago", itemsChi));
        warehouses.add(new Warehouse("Miami", itemsMia));
        warehouses.add(new Warehouse("New York", itemsNY));
        warehouses.add(new Warehouse("Houston", itemsHou));
        warehouses.add(new Warehouse("Los Angeles", itemsLA));

        // Creating 'record' of warehouses
        Record autoRecord = new Record(warehouses);

        // Reading in Shipment and Order cards [and printing]
        try (BufferedReader br = new BufferedReader(new
                FileReader("ShipmentAndOrderCardsData.txt"))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] lineArray = line.split(",");
                System.out.println("*****************************************");
                autoRecord.processLine(lineArray, autoRecord);
            }
        }
    }
}
