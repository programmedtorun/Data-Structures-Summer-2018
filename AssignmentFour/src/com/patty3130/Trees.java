package com.patty3130;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Trees {

    static void run(BinaryTree tree, String fileName) throws IOException {
        header(fileName);
        createNodes(tree, fileName);
        printAll(tree);
        printCountAndChildren(tree);
        processingDeletionsAndInsertions(tree, fileName);
        printAll(tree);
        printCountAndChildren(tree);
        freeTree(tree);
    }

    private static void header(String fileName){
        System.out.println("_____________________________________________________________");
        System.out.println("Processing Binary Tree for Set number: " + fileName.charAt(4));
    }

    private static void createNodes(BinaryTree tree, String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            if (line != null){
                String[] lineArray = line.split(" ");
                for (int i = 0; i < lineArray.length; i++){
                    tree.insertNode(tree.getRoot(), Integer.parseInt(lineArray[i]));
                }
            }
        }
    }

    private static void freeTree(BinaryTree tree){
        tree.freeTree(tree.getRoot());
    }

    private static void processingDeletionsAndInsertions(BinaryTree tree, String fileName){
        System.out.println("************* PROCESSING INSERTIONS AND DELETIONS *************");
        switch (fileName){
            case "SET_1.txt":
                tree.insertNode(tree.getRoot(), 21);
                tree.delete(tree.getRoot(), 1);
                tree.insertNode(tree.getRoot(), 0);
                tree.delete(tree.getRoot(), 10);
                tree.delete(tree.getRoot(), 11);
                tree.delete(tree.getRoot(), 5);
                tree.delete(tree.getRoot(), 2);
                tree.insertNode(tree.getRoot(), 10);
                break;
            case "SET_2.txt":
                tree.delete(tree.getRoot(), 3);
                tree.delete(tree.getRoot(), 1);
                break;
            case "SET_3.txt":
                tree.delete(tree.getRoot(), 15);
                tree.insertNode(tree.getRoot(), 30);
                tree.insertNode(tree.getRoot(), 5);
                tree.insertNode(tree.getRoot(), 10);
                tree.insertNode(tree.getRoot(), 20);
                tree.delete(tree.getRoot(), 20);
                tree.delete(tree.getRoot(), 10);
                tree.delete(tree.getRoot(), 5);
                tree.delete(tree.getRoot(), 15);
                tree.delete(tree.getRoot(), 30);
                break;
            case "SET_4.txt":
                tree.delete(tree.getRoot(), 2);
                break;
            case "SET_5.txt":
                tree.delete(tree.getRoot(), 37);
                tree.delete(tree.getRoot(), 15);
                tree.insertNode(tree.getRoot(), 40);
                tree.insertNode(tree.getRoot(), 99);
                break;
            default:
                System.out.println("No insertions or deletions for this set.");
        }
    }

    private static void printAll(BinaryTree tree){
        System.out.println("**************** TRAVERSALS ****************");
        if (tree.getRoot() != null){
            System.out.println("******** IN ORDER ********");
            tree.printInOrder(tree.getRoot());
            System.out.println("******** PR ORDER ********");
            tree.printPreOrder(tree.getRoot());
            System.out.println("******** PO ORDER ********");
            tree.printPostOrder(tree.getRoot());
        }
        System.out.println("********************************************");
    }

    private static void printCountAndChildren(BinaryTree tree){
        System.out.println("The number of TreeNodes in the tree, is: " + tree.count(tree.getRoot()));
        System.out.println("The number of children each TreeNode has is: ");
        tree.children(tree.getRoot());
    }

}
