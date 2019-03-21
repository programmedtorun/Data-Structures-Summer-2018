package com.patty3130;

        import java.util.HashMap;

public class Run {
    static HashMap<String, int[]> runAllSorts(){

        NumberData dataBblSrt = new NumberData();
        NumberData dataQkSrt = new NumberData();
        NumberData mergeSrt = new NumberData();
        String bubbleSort = "Bubble Sort";
        String quickSort = "Quick Sort";
        String mergeSort = "Merge Sort";

        HashMap<String, int[]> results = new HashMap<>();

        // Running bubble sort with 10 numbers in various orders
        results.put("bsrt10RAN", Run.runSortData(dataBblSrt, bubbleSort, dataBblSrt.getRandomTEN()));
        results.put("bsrt10REV", Run.runSortData(dataBblSrt, bubbleSort, dataBblSrt.getReverseTEN()));
        results.put("bsrt10ALM", Run.runSortData(dataBblSrt, bubbleSort, dataBblSrt.getAlmostSortedTEN()));

        // Running bubble sort with 50 numbers in various orders
        results.put("bsrt50RAN", Run.runSortData(dataBblSrt, bubbleSort, dataBblSrt.getRandomFIFTY()));
        results.put("bsrt50REV", Run.runSortData(dataBblSrt, bubbleSort, dataBblSrt.getReverseFIFTY()));
        results.put("bsrt50ALM", Run.runSortData(dataBblSrt, bubbleSort, dataBblSrt.getAlmostSortedFIFTY()));

        // Running bubble sort with 100 numbers in various orders
        results.put("bsrt1-RAN", Run.runSortData(dataBblSrt, bubbleSort, dataBblSrt.getRandomHUNDRED()));
        results.put("bsrt1-REV", Run.runSortData(dataBblSrt, bubbleSort, dataBblSrt.getReverseHUNDRED()));
        results.put("bsrt1-ALM", Run.runSortData(dataBblSrt, bubbleSort, dataBblSrt.getAlmostSortedHUNDRED()));
        // __________________________________________________________________________

        // Running quick sort with 10 numbers in various orders
        results.put("qsrt10RAN", Run.runSortData(dataQkSrt, quickSort, dataQkSrt.getRandomTEN()));
        results.put("qsrt10REV", Run.runSortData(dataQkSrt, quickSort, dataQkSrt.getReverseTEN()));
        results.put("qsrt10ALM", Run.runSortData(dataQkSrt, quickSort, dataQkSrt.getAlmostSortedTEN()));

        // Running quick sort with 50 numbers in various orders
        results.put("qsrt50RAN", Run.runSortData(dataQkSrt, quickSort, dataQkSrt.getRandomFIFTY()));
        results.put("qsrt50REV", Run.runSortData(dataQkSrt, quickSort, dataQkSrt.getReverseFIFTY()));
        results.put("qsrt50ALM", Run.runSortData(dataQkSrt, quickSort, dataQkSrt.getAlmostSortedFIFTY()));

        // Running quick sort with 100 numbers in various orders
        results.put("qsrt1-RAN", Run.runSortData(dataQkSrt, quickSort, dataQkSrt.getRandomHUNDRED()));
        results.put("qsrt1-REV", Run.runSortData(dataQkSrt, quickSort, dataQkSrt.getReverseHUNDRED()));
        results.put("qsrt1-ALM", Run.runSortData(dataQkSrt, quickSort, dataQkSrt.getAlmostSortedHUNDRED()));
        // __________________________________________________________________________

        // Running merge sort with 10 numbers in various orders
        results.put("msrt10RAN", Run.runSortData(mergeSrt, mergeSort, mergeSrt.getRandomTEN()));
        results.put("msrt10REV", Run.runSortData(mergeSrt, mergeSort, mergeSrt.getReverseTEN()));
        results.put("msrt10ALM", Run.runSortData(mergeSrt, mergeSort, mergeSrt.getAlmostSortedTEN()));

        // Running quick sort with 50 numbers in various orders
        results.put("msrt50RAN", Run.runSortData(mergeSrt, mergeSort, mergeSrt.getRandomFIFTY()));
        results.put("msrt50REV", Run.runSortData(mergeSrt, mergeSort, mergeSrt.getReverseFIFTY()));
        results.put("msrt50ALM", Run.runSortData(mergeSrt, mergeSort, mergeSrt.getAlmostSortedFIFTY()));

        // Running quick sort with 100 numbers in various orders
        results.put("msrt1-RAN", Run.runSortData(mergeSrt, mergeSort, mergeSrt.getRandomHUNDRED()));
        results.put("msrt1-REV", Run.runSortData(mergeSrt, mergeSort, mergeSrt.getReverseHUNDRED()));
        results.put("msrt1-ALM", Run.runSortData(mergeSrt, mergeSort, mergeSrt.getAlmostSortedHUNDRED()));

        return results;
    }

    static int[] runSortData(NumberData data, String sortType, int[] dataArray){
        int[] comparisonArray = new int[3];
        data.printHeading(dataArray, sortType);
        data.printNumberGroup(dataArray);
        data.printPostSortHeading(sortType);
        if (sortType.equals("Bubble Sort")){
            data.printNumberGroup(Sort.bubbleSort(dataArray));
            data.printComparisonsAndInterchanges();
            comparisonArray[0] = Sort.getBsComparisonCount();
            comparisonArray[1] = Sort.getBsInterchangeCount();
            comparisonArray[2] = 1;
        } else if (sortType.equals("Quick Sort")){
            Sort.zeroOutCounters();
            Sort.quickSort(dataArray, 0, dataArray.length);
            data.printNumberGroup(dataArray);
            data.printComparisonsAndInterchangesQS();
            comparisonArray[0] = Sort.getQsComparisonCount();
            comparisonArray[1] = Sort.getQsInterchangeCount();
            comparisonArray[2] = 2;
        } else if (sortType.equals("Merge Sort")){
            Sort.zeroOutCounters();
            Sort.mergeSort(dataArray,0, dataArray.length);
            data.printNumberGroup(dataArray);
            data.printComparisonsAndInterchangesMS();
            comparisonArray[0] = Sort.getMsComparisonCount();
            comparisonArray[1] = Sort.getMsInterchangeCount();
            comparisonArray[2] = 3;
        }
        return comparisonArray;
    }

    static void compareSorts(HashMap<String, int[]> results, String sortOneKey, String sortTwoKey, String sortThreeKey){

        // assuming data sets of same type and record count are passed for each sort comparison
        // Also assuming the data is passed to the compareSorts function
        // in order - bubble data, quicksort data, merge data

        String incomingDataType = sortOneKey.substring(6,9);
        String recordCount = sortOneKey.substring(4,6);

        if (incomingDataType.equals("RAN")){
            incomingDataType = "random";
        } else if (incomingDataType.equals("REV")){
            incomingDataType = "reverse";
        } else {
            incomingDataType = "almost sorted";
        }

        if (recordCount.equals("1-")) { recordCount = "100"; }

        int[] bubble = results.get(sortOneKey);
        int[] quick = results.get(sortTwoKey);
        int[] merge = results.get(sortThreeKey);
        printCount(bubble[0], quick[0], merge[0], "comparison", incomingDataType, recordCount);
        printCount(bubble[1], quick[1], merge[1], "interchange", incomingDataType, recordCount);
    }

    static void printCount(int bubble, int quick, int merge, String compType, String incomingDataType, String recordCount){

        int minCount = Math.min(bubble, Math.min(quick, merge));
        int maxcount = Math.max(bubble, Math.max(quick, merge));

        int sortTypeMin = 0;
        int sortTypeMax = 0;
        if (minCount == bubble){
            printDetails(incomingDataType, "Bubble", compType, recordCount, bubble, "least");
            sortTypeMin = 1;
        } else if (minCount == quick){
            printDetails(incomingDataType, "Quick", compType, recordCount, quick, "least");
            sortTypeMin = 2;
        } else if (minCount == merge){
            printDetails(incomingDataType, "Merge", compType, recordCount, merge, "least");
            sortTypeMin = 3;
        }

        if (maxcount == bubble){
            printDetails(incomingDataType, "Bubble", compType, recordCount, bubble, "most");
            sortTypeMax = 1;
        } else if (maxcount == quick){
            printDetails(incomingDataType, "Quick", compType, recordCount, quick, "most");
            sortTypeMax = 2;
        } else if (maxcount == merge){
            printDetails(incomingDataType, "Merge", compType, recordCount, merge, "most");
            sortTypeMax = 3;
        }

        if (sortTypeMin == 1 && sortTypeMax == 2 || sortTypeMin == 2 && sortTypeMax == 1){
            printDetails(incomingDataType, "Merge", compType, recordCount, merge, "middle");
        } else if (sortTypeMin == 2 && sortTypeMax == 3 || sortTypeMin == 3 && sortTypeMax == 2){
            printDetails(incomingDataType, "Bubble", compType, recordCount, bubble, "middle");
        } else if (sortTypeMin == 1 && sortTypeMax == 3 || sortTypeMin == 3 && sortTypeMax == 1){
            printDetails(incomingDataType, "Quick", compType, recordCount, quick, "middle");
        }
        System.out.println("=============================================================");
    }

    static void printDetails(String incomingDataType, String sortType, String compType, String recordCount, int count, String amt){
        System.out.println(sortType + " sort has the " + amt + " amount of " +
                compType + "s for " + incomingDataType + " data with " + recordCount + " records.");
        System.out.println(compType + " count is: " + count);
    }
}
