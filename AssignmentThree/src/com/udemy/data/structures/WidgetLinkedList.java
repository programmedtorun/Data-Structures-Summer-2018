package com.udemy.data.structures;

class WidgetLinkedList {
    private WidgetNode rear;
    private WidgetNode head;
    private int size;

    WidgetLinkedList(WidgetNode lastNode) {
        this.rear = lastNode;
        this.size = 1;
    }

    private void setHead(WidgetNode head) {
        this.head = head;
    }

    WidgetNode addToEnd(int quantity, double price) {
        WidgetNode nodeToAdd = new WidgetNode(quantity, price);
        if(rear != null && size == 1){
            setHead(rear);
            rear.setNext(nodeToAdd);
            nodeToAdd.setNext(null);
            rear = nodeToAdd;
        }
        rear.setNext(nodeToAdd);
        nodeToAdd.setNext(null);
        rear = nodeToAdd;
        size++;
        return rear;
    }

    private WidgetNode pop(){
        WidgetNode poppedNode = head;
        head = head.getNext();
        poppedNode.setNext(null);
        size--;
        return poppedNode;
    }

    void processSale(int quantity, double promo){
        System.out.println(quantity + " Widgets requested for purchase");
        int headQty = head.getQuantity();
        double totalSales = 0.00;
        while (headQty < quantity) {
            if (head != null) {
                quantity = quantity - headQty;
                WidgetNode fIFONode = pop();
                totalSales += fIFONode.printSales(promo, fIFONode.getQuantity());
                if (isEmpty()){
                    System.out.println("Remainder of " + quantity + " Widgets not available");
                }
                if (head != null) {
                    headQty = head.getQuantity();
                }
            } else {
                break;
            }
        }
        if (head != null){
            if (head.getQuantity() == quantity) {
                WidgetNode fIFONode = pop();
                totalSales += fIFONode.printSales(promo, fIFONode.getQuantity());
            } else if (headQty > quantity){
                totalSales += head.printSales(promo, quantity);
                head.setQuantity(headQty - quantity);
            }
        }
        System.out.println("\t\tTotal Sales: $" + totalSales);
        System.out.println("************************************");
    }

    private boolean isEmpty(){
        return head == null;
    }

    void printList(){
        System.out.println("Widgets still in stock: ");
        WidgetNode current = head;
        while(current != null){
            System.out.println("Quantity:\t\t\t" + current.getQuantity());
            System.out.println("Original Price:\t\t$" + current.getPrice());
            System.out.println("-------------------------");
            current = current.getNext();
        }

    }

    public WidgetNode getHead() {
        return head;
    }
}
