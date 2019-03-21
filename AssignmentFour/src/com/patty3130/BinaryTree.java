package com.patty3130;

public class BinaryTree {
    private TreeNode root;

    BinaryTree(TreeNode root) {
        if (root.getData() == -1) {
            this.root = null;
        } else {
            this.root = root;
        }
    }

    TreeNode getRoot() {
        return root;
    }

    TreeNode setRoot(TreeNode root) {
        return this.root = root;
    }

    void insertNode(TreeNode rootNodeToCheck, int data){
        if (root == null) { setRoot(new TreeNode(data)); }
        if (data != root.getData()) {
            if (data < rootNodeToCheck.getData()){
                if (rootNodeToCheck.getLeft() == null) {
                    rootNodeToCheck.setLeft(data);
                    rootNodeToCheck.getLeft().setParent(rootNodeToCheck);
                } else {
                    insertNode(rootNodeToCheck.getLeft(), data);
                }
            } else if (data > rootNodeToCheck.getData()){
                if (rootNodeToCheck.getRight() == null) {
                    rootNodeToCheck.setRight(data);
                    rootNodeToCheck.getRight().setParent(rootNodeToCheck);

                } else {
                    insertNode(rootNodeToCheck.getRight(), data);
                }
            } else {
                if (rootNodeToCheck.isDeleted()){
                    rootNodeToCheck.setDeleted(false);
                } else {
                    rootNodeToCheck.setDuplicateCount(rootNodeToCheck.getDuplicateCount() + 1);
                }
            }
        }

    }

    void freeTree(TreeNode root){
        if (root.getLeft() != null) { freeTree(root.getLeft()); }
        if (root.getRight() != null) { freeTree(root.getRight()); }
        root.setDeleted(true);
    }
    void children(TreeNode root){
        if (root != null){
            int count = 0;
            if(root.getLeft() != null) { children(root.getLeft()); }
            if (root.getLeft() != null) { count++; }
            if (root.getRight() != null) { count++; }
            if (!root.isDeleted()){
                System.out.println("Node -> data = " + root.getData() +
                        "; has " + count + (count == 1 ? " child." : " children."));
            }
            if (root.getRight() != null) { children(root.getRight()); }
        }
    }

    void delete(TreeNode root, int data){
        if (root != null){
            if (root.getLeft() != null) { delete(root.getLeft(), data); }
            if (root.getRight() != null) { delete(root.getRight(), data); }
            if (root.getData() == data){
                root.setDeleted(true);
            }
        }
    }

    int count(TreeNode root){
        if (root == null) { return 0; }
        if (root.isDeleted()){
            return count(root.getLeft()) + count(root.getRight());
        } else {
            return 1 + count(root.getLeft()) + count(root.getRight());
        }
    }

    void printPreOrder(TreeNode root){
            print(root);
            if (root.getLeft() != null) { printInOrder(root.getLeft()); }
            if (root.getRight() != null) { printInOrder(root.getRight()); }
    }

    void printInOrder(TreeNode root) {
            if (root.getLeft() != null) { printInOrder(root.getLeft()); }
            print(root);
            if (root.getRight() != null) { printInOrder(root.getRight()); }
    }

    void printPostOrder(TreeNode root){
            if (root.getLeft() != null) { printInOrder(root.getLeft()); }
            if (root.getRight() != null) { printInOrder(root.getRight()); }
            print(root);
    }

    private void print(TreeNode root){
        if (root.getData() != -1){
            System.out.println(" { data = " + root.getData() + ", duplicate count = " + root.getDuplicateCount()
                    + " deleted? = " + root.isDeleted() + " } ");
        } else {
            System.out.println("NULL");
        }
    }
}
