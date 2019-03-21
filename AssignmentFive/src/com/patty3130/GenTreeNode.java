package com.patty3130;

import java.util.ArrayList;
import java.util.List;

public class GenTreeNode {
    private String familyMember;
    private List<GenTreeNode> children;
    private GenTreeNode father;
    private boolean isOldest;
    private boolean isYoungest;

    GenTreeNode(String familyMember) {
        this.familyMember = familyMember;
        this.children = new ArrayList<>();
    }

    List<GenTreeNode> getBrothers() {
        List<GenTreeNode> justBros = new ArrayList<>();
        if(hasFather()){
            justBros.addAll(father.getChildren());
            justBros.remove(this);
        }
        return justBros;
    }

    List<GenTreeNode> getUncles(){
        return father.getBrothers();
    }

    boolean hasChildren(){
        if(getChildren().isEmpty()){
            return false;
        } else {
            return true;
        }
    }

    List<GenTreeNode> getChildren() {
        return children;
    }

    private boolean hasFather(){
        return father != null;
    }

    GenTreeNode oldestSon(){
        if(hasChildren()) {
            for (GenTreeNode son : children) { if (son.isOldest()) { return son; } }
        } else {
            return new GenTreeNode("No Children.");
        }
        return null;
    }

    GenTreeNode youngestSon(){
        if (hasChildren()){
            for (GenTreeNode son : children) { if (son.isYoungest()) { return son; } }
        } else {
            return new GenTreeNode("No Children.");
        }
        return null;
    }

    GenTreeNode getNextSibling(){
        List<GenTreeNode> allSibs = father.getChildren();
        GenTreeNode nextSib = new GenTreeNode("nextSib");
        for (int i = 0; i < allSibs.size(); i++){
             if (allSibs.get(i) == this && !allSibs.get(i).isYoungest()){
                 nextSib = allSibs.get(i + 1);
             }
        }
        return nextSib;

    }

    GenTreeNode oldestBro(){
        if(father.getChildren().size() < 2){
            return new GenTreeNode("No siblings");
        } else if (this.isOldest()){
            return getNextSibling();
        } else {
            return father.getChildren().get(0);
        }
    }

    GenTreeNode youngestBro(){
        if(father.getChildren().size() < 2){
            return new GenTreeNode("No siblings");
        } else if (this.isYoungest()){
            return father.getChildren().get(father.getChildren().size() - 2);
        } else {
            return father.getChildren().get(father.getChildren().size() - 1);
        }
    }

    GenTreeNode grandfather(){
        return father.getFather();
    }

    GenTreeNode getFather() {
        return father;
    }

    void setFather(GenTreeNode father) {
        this.father = father;
    }

    String getFamilyMember() {
        return familyMember;
    }

     void setOldest() {
        isOldest = true;
    }

     void setYoungest() {
        isYoungest = true;
    }

    private boolean isOldest() {
        return isOldest;
    }

    private boolean isYoungest() {
        return isYoungest;
    }

    @Override
    public String toString() {
        if (hasFather()) {
            return "Family member's name is: " + familyMember + ", and their father is " + father.getFamilyMember() + ".";
        } else {
            return "Family member's name is: " + familyMember + ".";
        }
    }
}
