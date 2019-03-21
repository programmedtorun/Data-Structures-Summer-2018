package com.udemy.data.structures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class WidgetProgram {

    static void run() throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("DATA.txt"))){
            WidgetLinkedList list = createWidgetLinkedList(br.readLine());
            processLines(br, list);
            list.printList();
        }
    }

    private static WidgetLinkedList createWidgetLinkedList(String line){
        String[] lineArray = line.split(",");
        WidgetNode initialNode = new WidgetNode(
                Integer.parseInt(lineArray[1]),
                Double.parseDouble(lineArray[2]));
        printR(lineArray);
        return new WidgetLinkedList(initialNode);
    }

    private static void processLines(BufferedReader br, WidgetLinkedList list) throws IOException {
        String line;
        double promo = 0.00;
        int promoCount = 0;
        while((line = br.readLine()) != null) {
            String[] lineArray = line.split(",");
            String recordType = lineArray[0];
            if (recordType.equals("R")){
                if (list.addToEnd(Integer.parseInt(lineArray[1]),
                        Double.parseDouble(lineArray[2])) != null) {
                    printR(lineArray);
                } else {
                    System.out.println("Error adding record to list.");
                }
            } else if (recordType.equals("S")) {
                if (promo > 0){ promoCount++; }
                if (promoCount == 3){
                    promoCount = 0;
                    promo = 0.0;
                }
                list.processSale(Integer.parseInt(lineArray[1]), promo);
            } else if (recordType.equals("P")){
                promo = Double.parseDouble(lineArray[1]) / 100;
                printP(promo);
            }
        }
    }

    private static void printR(String[] lineArray){
            System.out.println("Successfully received " + lineArray[1]
                    + " widgets at $" + lineArray[2] + " each...");
            System.out.println("************************************");

    }

    private static void printP(double promo){
        System.out.println("The next 2 customers will receive a " + promo * 100 + "% PROMOTION!");
        System.out.println("************************************");
    }
}
