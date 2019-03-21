package com.patty3130;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Customer implements Comparable<Customer> {

    private int custNum;
    private String custName;
    private int balanceDue = 0;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Customer(int custNum, String custName) {
        if (custName.length()> 20) {
            throw new IllegalArgumentException("Customer name must be less than 20 characters");
        }
        if (custNum < 1000 || custNum > 9999) {
            throw new IllegalArgumentException("Customer number must be 4 digits");
        }
        this.custName = custName;
        this.custNum = custNum;
    }

    @Override
    public int compareTo(Customer customer) {
        if (customer.getCustNum() > custNum) {
            return -1;
        } else if (customer.getCustNum() < custNum) {
            return 1;
        } else {
            return 0;
        }
    }

    public Transaction createOrderTransaction(String itemOrdered, int qtyOrdered, int itemCost) {

        Transaction trans = new Transaction(custNum, 'O', itemOrdered, qtyOrdered, itemCost);
        if (transactions.contains(trans)) { return null; }
        transactions.add(trans);
        return trans;
    }

    public Transaction createPaymentTransaction(int paymentAmt){

        Transaction trans = new Transaction(custNum, 'P', paymentAmt);
        if (transactions.contains(trans)) { return null; }
        transactions.add(trans);
        return trans;
    }

    public void prepareInvoice() {
        int previousBalance = balanceDue;

        try (BufferedReader reader = new BufferedReader(new FileReader("transactions.txt"))){
            String str;

            System.out.println("\n" + custName + "\t" + custNum + "\n");
            System.out.println("\t\t\t\tPREVIOUS BALANCE\t$ " + previousBalance + "\n");

            while ((str = reader.readLine()) != null) {
                String[] line = str.split(",");
                if(line[1].equals(String.valueOf(custNum))){
                    String transactionNum = line[2];
                    String format = "%-20s%s%n";
                    if(line[0].equals("O")){
                        int totalDollarAmtOrdered = Integer.parseInt(line[4]) * Integer.parseInt(line[5]);
                        String itmOrdered = line[3];
                        balanceDue += totalDollarAmtOrdered;
                        System.out.print(transactionNum + "\t" );
                        System.out.printf(format, itmOrdered, "$ " + totalDollarAmtOrdered);
                    }
                    if(line[0].equals("P")){
                        int paymentAmt = Integer.parseInt(line[3]);
                        balanceDue -= paymentAmt;
                        System.out.print(transactionNum + "\t");
                        System.out.printf(format, "PAYMENT", "$ " + paymentAmt);
                    }
                }
            }
            System.out.println("\n\t\t\t\tBALANCE DUE   \t\t$ " + balanceDue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "My name is: " + custName + ", this is my number: " + custNum +
                ", and this is by balance: " + balanceDue;
    }

    public int getBalanceDue() {
        return balanceDue;
    }

    public int getCustNum() {
        return custNum;
    }

    public String getCustName() {
        return custName;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
}
