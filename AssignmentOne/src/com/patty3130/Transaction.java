package com.patty3130;

public class Transaction implements Comparable<Transaction> {

    private int custNum;
    private char type;
    private static int transNum = 1000;
    private String itemOrdered;
    private int qtyOrdered;
    private int itemCost;
    private int paymentAmt;
    private int realTransNum;

    public Transaction(int custNum, char type, String itemOrdered,
                       int qtyOrdered, int itemCost) {
        this.custNum = custNum;
        this.type = type;
        this.transNum++;
        this.realTransNum = transNum;
        this.itemOrdered = itemOrdered;
        this.qtyOrdered = qtyOrdered;
        this.itemCost = itemCost;
    }

    public Transaction(int custNum, char type, int paymentAmt) {
        this.custNum = custNum;
        this.type = type;
        this.paymentAmt = paymentAmt;
        this.transNum++;
        this.realTransNum = transNum;

    }

    @Override
    public int compareTo(Transaction transaction) {
        if(transaction.getCustNum() > custNum) {
            return -1;
        } else if (transaction.getCustNum() < custNum) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return  "Customer Number: " + custNum + "\n" +
                "Transaction Type: " + type + "\n" +
                "Transaction Number: " + realTransNum + "\n" +
                "Name of Item Ordered: " + itemOrdered +  "\n" +
                "Qty: " + qtyOrdered + "\n" +
                "Item Cost: " + itemCost + "\n" +
                "Payment amount: " + paymentAmt;
    }

    public int getRealTransNum() {
        return realTransNum;
    }

    public int getCustNum() {
        return custNum;
    }

    public char getType() {
        return type;
    }

    public String getItemOrdered() {
        return itemOrdered;
    }

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public int getItemCost() {
        return itemCost;
    }

    public int getPaymentAmt() {
        return paymentAmt;
    }
}
