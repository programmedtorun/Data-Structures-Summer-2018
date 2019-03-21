package com.patty3130;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        GeneralTree assignmentTree = Trees.createGeneralTree("FAMILY_ONE.txt");
        GeneralTree jacksonFamily = Trees.createGeneralTree("FAMILY_TWO.txt");
        GeneralTree settles = Trees.createGeneralTree("FAMILY_THREE.txt");

        Questions.printFirstTreeAnswers(assignmentTree);
        Questions.printJacksonFamilyTreeAnswers(jacksonFamily);
        Questions.printSettleTreeAnswers(settles);
    }
}
