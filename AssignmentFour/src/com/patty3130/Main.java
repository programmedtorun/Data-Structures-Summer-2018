package com.patty3130;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        BinaryTree setOne = new BinaryTree(new TreeNode(12));
        BinaryTree setTwo = new BinaryTree(new TreeNode(1));
        BinaryTree setThree = new BinaryTree(new TreeNode(-1));
        BinaryTree setFour = new BinaryTree(new TreeNode(2));
        BinaryTree setFive = new BinaryTree(new TreeNode(45));
        BinaryTree setSix = new BinaryTree(new TreeNode(60));
        BinaryTree setSeven = new BinaryTree(new TreeNode(30));

        Trees.run(setOne, "SET_1.txt");
        Trees.run(setTwo, "SET_2.txt");
        Trees.run(setThree, "SET_3.txt");
        Trees.run(setFour, "SET_4.txt");
        Trees.run(setFive, "SET_5.txt");
        Trees.run(setSix, "SET_6.txt");
        Trees.run(setSeven, "SET_7.txt");
    }
}
