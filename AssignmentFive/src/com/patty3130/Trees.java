package com.patty3130;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Trees {

    static GeneralTree createGeneralTree(String fileName) throws IOException {
        printHeader(fileName);
        GeneralTree tree = new GeneralTree();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String [] lineArray = br.readLine().split(",");
            GenTreeNode root = new GenTreeNode(lineArray[0]);
            tree.setRoot(root);
            int sonCount = Integer.parseInt(lineArray[1]);
            printFamilyMember(root);
            processSons(sonCount, br, root);
        }
        return tree;
    }

    static void processSons (int sonCount, BufferedReader br, GenTreeNode father) throws IOException {
        for (int i = 0; i < sonCount; i++){
            String [] lineArray = br.readLine().split(",");
            GenTreeNode familyMember = new GenTreeNode(lineArray[0]);
            familyMember.setFather(father);
            father.getChildren().add(familyMember);
            if (i == 0) { familyMember.setOldest(); }
            if (i == sonCount - 1) { familyMember.setYoungest(); }
            printFamilyMember(familyMember);
            int sonCount2 = Integer.parseInt(lineArray[1]);
            if (sonCount2 > 0){
                processSons(sonCount2, br, familyMember);
            }
        }
    }

    static void printHeader(String filename){
        switch (filename){
            case "FAMILY_ONE.txt":
                System.out.println("Processing the example file from the assignment......");
                break;
            case "FAMILY_TWO.txt":
                System.out.println("Processing the Jackson family tree!......");
                break;
            case "FAMILY_THREE.txt":
                System.out.println("Processing the Settle family tree......");
                break;
                default:
                    System.out.println("No tree......");
        }
    }

    static void printFamilyMember(GenTreeNode familyMember){
        System.out.println(familyMember);
    }

}
