package com.patty3130;

import java.util.Random;

class NumberData {
    private int[] almostSortedTEN = new int[] {0, 5, 2, 7, 4, 1, 6, 3, 8, 9};
    private int[] randomTEN = new int[] {9, 4, 7, 5, 2, 6, 3, 8, 0, 1};
    private int[] reverseTEN = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    
    private int[] almostSortedFIFTY = new int[50];
    private int[] randomFIFTY = new int[50];
    private int[] reverseFIFTY = new int[50];
    
    private int[] almostSortedHUNDRED = new int[100];
    private int[] randomHUNDRED = new int[100];
    private int[] reverseHUNDRED = new int[100];



    NumberData() {
        
        // initializing 50 length arrays
        Random rand = new Random();
        for (int i = 0; i < randomFIFTY.length; i++){
            randomFIFTY[i] = rand.nextInt(50);
            almostSortedFIFTY[i] = i;
            reverseFIFTY[i] = (reverseFIFTY.length -1 - i);
        }
        almostSortedFIFTY[20] = 4;
        almostSortedFIFTY[4] = 20;
        almostSortedFIFTY[40] = 10;
        almostSortedFIFTY[10] = 40;
        almostSortedFIFTY[3] = 16;
        almostSortedFIFTY[16] = 3;

        // initializing 100 length arrays
        for (int i = 0; i < randomHUNDRED.length; i++){
            randomHUNDRED[i] = rand.nextInt(100);
            almostSortedHUNDRED[i] = i;
            reverseHUNDRED[i] = (reverseHUNDRED.length - 1 - i);
        }
        almostSortedHUNDRED[20] = 4;
        almostSortedHUNDRED[4] = 20;
        almostSortedHUNDRED[40] = 10;
        almostSortedHUNDRED[10] = 40;
        almostSortedHUNDRED[3] = 16;
        almostSortedHUNDRED[16] = 3;
        almostSortedHUNDRED[9] = 90;
        almostSortedHUNDRED[90] = 9;
        almostSortedHUNDRED[21] = 84;
        almostSortedHUNDRED[84] = 21;
        almostSortedHUNDRED[54] = 64;
        almostSortedHUNDRED[64] = 54;

    }

    void printComparisonsAndInterchanges(){
        System.out.println("comp count is: " + Sort.bsComparisonCount);
        System.out.println("elem interchange count is: " + Sort.bsInterchangeCount);
        System.out.println("=============================================================");
    }

    void printComparisonsAndInterchangesQS(){
        System.out.println("comp count is: " + Sort.qsComparisonCount);
        System.out.println("elem interchange count is: " + Sort.qsInterchangeCount);
        System.out.println("=============================================================");
    }

    void printComparisonsAndInterchangesMS(){
        System.out.println("comp count is: " + Sort.msComparisonCount);
        System.out.println("elem interchange count is: " + Sort.msInterchangeCount);
        System.out.println("=============================================================");
    }

    void printPostSortHeading(String sortType){
        System.out.println("Running " + sortType + ". . . ");
    }

    void printHeading(int[] numberGroup, String sortType){
        System.out.println("*************** Printing for sort type: " + sortType + " *****************");
        if (numberGroup.equals(almostSortedTEN)){
            System.out.println("10 numbers in almost sorted order.......");
        } else if (numberGroup.equals(randomTEN)){
            System.out.println("10 numbers in random order.......");
        } else if (numberGroup.equals(reverseTEN)){
            System.out.println("10 numbers in reverse order.......");
        } else if (numberGroup.equals(almostSortedFIFTY)){
            System.out.println("50 numbers in almost sorted order.......");
        } else if (numberGroup.equals(randomFIFTY)){
            System.out.println("50 numbers in random order.......");
        } else if (numberGroup.equals(reverseFIFTY)){
            System.out.println("50 numbers in reverse order.......");
        }  else if (numberGroup.equals(almostSortedHUNDRED)){
            System.out.println("100 numbers in almost sorted order.......");
        }  else if (numberGroup.equals(randomHUNDRED)){
            System.out.println("100 numbers in random order.......");
        }  else if (numberGroup.equals(reverseHUNDRED)){
            System.out.println("100 numbers in reverse order.......");
        }
    }

    void printNumberGroup(int[] numberGroup){
        for(int i = 0; i < numberGroup.length; i++){
            System.out.println("Printing value: " + numberGroup[i] + ", at index " + i);
        }
        System.out.println("********************************");

    }

    int[] getAlmostSortedTEN() {
        return almostSortedTEN;
    }

    int[] getReverseTEN() {
        return reverseTEN;
    }

    int[] getRandomTEN() {
        return randomTEN;
    }

    int[] getAlmostSortedFIFTY() {
        return almostSortedFIFTY;
    }

    int[] getRandomFIFTY() {
        return randomFIFTY;
    }

    int[] getReverseFIFTY() {
        return reverseFIFTY;
    }

    int[] getAlmostSortedHUNDRED() {
        return almostSortedHUNDRED;
    }

    int[] getRandomHUNDRED() {
        return randomHUNDRED;
    }

    int[] getReverseHUNDRED() {
        return reverseHUNDRED;
    }
}
