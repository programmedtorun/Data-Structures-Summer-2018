package com.patty3130;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {

        // Creating customers:
        Customer bobby = new Customer(3546, "Bobby");
	    Customer alena = new Customer(1234, "Alena");
	    Customer mark = new Customer(2222, "Mark");
	    Customer liam = new Customer(9487, "Liam");
	    Customer moshe = new Customer(6789, "Moshe");
	    Customer sheila = new Customer(1111, "Sheila");
	    Customer patty = new Customer(5238, "Patty");

	    // Creating transactions:
        bobby.createOrderTransaction("lamp", 2, 25);
        bobby.createOrderTransaction("necklace", 1, 10);
        bobby.createOrderTransaction("bike", 1, 100);
        bobby.createPaymentTransaction(50);
        bobby.createPaymentTransaction(25);
        bobby.createOrderTransaction("table", 1, 200);
        bobby.createPaymentTransaction(200);

        alena.createOrderTransaction("bike horn", 1, 15);
        alena.createOrderTransaction("bike bell", 1, 10);
        alena.createOrderTransaction("bike pedal", 2, 15);
        alena.createOrderTransaction("bike front wheel", 1, 200);
        alena.createOrderTransaction("bike back wheel", 1, 200);
        alena.createOrderTransaction("bike frame", 1, 500);
        alena.createPaymentTransaction(500);
        alena.createPaymentTransaction(200);

        mark.createOrderTransaction("note book", 3, 5);
        mark.createOrderTransaction("text book", 3, 87);
        mark.createOrderTransaction("online course", 2, 14);
        mark.createOrderTransaction("yankees tickets", 4, 50);
        mark.createOrderTransaction("bobsled", 1, 5000);
        mark.createPaymentTransaction(2000);
        mark.createPaymentTransaction(2000);
        mark.createPaymentTransaction(440);

        liam.createOrderTransaction("ray gun", 3, 5);
        liam.createOrderTransaction("molecular helmet", 1, 700);
        liam.createOrderTransaction("space gloves", 2, 40);
        liam.createOrderTransaction("death visor", 1, 50);
        liam.createOrderTransaction("reflective armor", 1, 50000);
        liam.createPaymentTransaction(20000);
        liam.createPaymentTransaction(20000);
        liam.createPaymentTransaction(880);

        moshe.createOrderTransaction("black sweater", 1, 150);
        moshe.createOrderTransaction("white collar shirt", 1, 60);
        moshe.createOrderTransaction("black pants", 1, 85);
        moshe.createOrderTransaction("glasses", 1, 250);
        moshe.createOrderTransaction("kippah", 1, 45);
        moshe.createPaymentTransaction(250);
        moshe.createPaymentTransaction(190);
        moshe.createPaymentTransaction(150);

        sheila.createOrderTransaction("jack daniels", 2, 20);
        sheila.createOrderTransaction("svedka", 1, 17);
        sheila.createOrderTransaction("jameson", 1, 25);
        sheila.createOrderTransaction("shock top", 12, 2);
        sheila.createOrderTransaction("merlot", 1, 45);
        sheila.createPaymentTransaction(102);
        sheila.createPaymentTransaction(25);
        sheila.createPaymentTransaction(24);

        patty.createOrderTransaction("computer", 1, 2000);
        patty.createOrderTransaction("running shoes", 1, 160);
        patty.createOrderTransaction("records", 24, 4);
        patty.createPaymentTransaction(2000);
        patty.createPaymentTransaction(246);
        patty.createOrderTransaction("drums", 1, 500);
        patty.createPaymentTransaction(500);

        // Create data structure of customers adding customers to the list
        ArrayList<Customer> customerList = new ArrayList<>();
        customerList.add(bobby);
        customerList.add(alena);
        customerList.add(mark);
        customerList.add(liam);
        customerList.add(moshe);
        customerList.add(sheila);
        customerList.add(patty);

        // Sort by customer number
        Collections.sort(customerList);

        // write customers objects to master file
        try (FileWriter masterFile = new FileWriter("master.txt")) {
            for (Customer cust : customerList) {
                masterFile.write(cust.getCustNum() + "," + cust.getCustName() + "," +
                cust.getBalanceDue() + "\n");
            }
        }

        // Creating transaction list and adding customer transactions to the list
        ArrayList<Transaction> transactionList = new ArrayList<>();
        transactionList.addAll(bobby.getTransactions());
        transactionList.addAll(alena.getTransactions());
        transactionList.addAll(mark.getTransactions());
        transactionList.addAll(liam.getTransactions());
        transactionList.addAll(moshe.getTransactions());
        transactionList.addAll(sheila.getTransactions());
        transactionList.addAll(patty.getTransactions());

        // Sorting transaction list by customer number
        Collections.sort(transactionList);

        // write all transactions to transaction file
        try (FileWriter transactionFile = new FileWriter("transactions.txt")){
            for (Transaction trans : transactionList) {
                if(trans.getType() == 'O') {
                    transactionFile.write(trans.getType() + "," + trans.getCustNum() + "," +
                    trans.getRealTransNum() + "," + trans.getItemOrdered() + "," +
                    trans.getQtyOrdered() + "," + trans.getItemCost() + "\n");
                } else if(trans.getType() == 'P') {
                    transactionFile.write(trans.getType() + "," + trans.getCustNum() + "," +
                    trans.getRealTransNum() + "," + trans.getPaymentAmt() + "\n");
                }
            }
        }

        // print customer invoices
        int invoiceNumber = 0;
        for (Customer cust : customerList) {
            invoiceNumber += 1;
            System.out.println("*************************************************************");
            System.out.println("INVOICE NUMBER: " + invoiceNumber);
            cust.prepareInvoice();
        }
    }
}
