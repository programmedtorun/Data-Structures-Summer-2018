package com.patty3130;

public class TreeNode {

    private int data;
    private TreeNode parent;
    private TreeNode left;
    private TreeNode right;
    private int duplicateCount;
    private boolean deleted;

    public TreeNode(int data) {
        this.data = data;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void setDuplicateCount(int duplicateCount) {
        this.duplicateCount = duplicateCount;
    }

    public int getDuplicateCount() {
        return duplicateCount;
    }

    public int getData() {
        return data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode setLeft(int data) {
        return this.left = new TreeNode(data);
    }

    public TreeNode getRight() {
        return right;
    }

    public TreeNode setRight(int data) {
        return this.right = new TreeNode(data);
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", duplicateCount=" + duplicateCount +
                '}';
    }

}
