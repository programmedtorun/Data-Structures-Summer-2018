package com.patty3130;

public class Sort {
    // variables to count the number of comparisons and element interchanges.
    static int bsComparisonCount;
    static int bsInterchangeCount;
    static int qsComparisonCount;
    static int qsInterchangeCount;
    static int msComparisonCount;
    static int msInterchangeCount;

    static int[] bubbleSort(int[] array){
        bsComparisonCount = 0;
        bsInterchangeCount = 0;

        int temp;
        int length = array.length;
        while(length >= 0){
            for (int i = 0; i < length - 1; i++){
                bsComparisonCount++;
                if (array[i] > array[i+1]){
                    bsInterchangeCount++;
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            length--;
        }
        return array;
    }

    static void zeroOutCounters(){
        qsComparisonCount = 0;
        qsInterchangeCount = 0;
        bsComparisonCount = 0;
        bsInterchangeCount = 0;
        msComparisonCount = 0;
        msInterchangeCount = 0;
    }

    static void quickSort(int[] array, int start, int end){

        if (end - start < 2){ return; }
        int pivotIndex = partition(array, start, end);
        quickSort(array, start, pivotIndex);
        quickSort(array, pivotIndex + 1, end);
    }

    static int partition(int[] input, int start, int end){

        int pivot = input[start];
        int i = start;
        int j = end;

        while (i< j) {
            while (i < j && input[--j] >= pivot){
                qsComparisonCount++;
            }
            if (i < j) {
                qsInterchangeCount++;
                input[i] = input[j];
            }
            while (i < j && input[++i] <= pivot){
                qsComparisonCount++;
            }
            if (i < j){
                qsInterchangeCount++;
                input[j] = input[i];
            }
        }
        input[j] = pivot;
        qsInterchangeCount++;
        return j;
    }

    static void mergeSort(int[] input, int start, int end){
        if (end - start < 2) {
            msComparisonCount++;
            return;
        }

        int mid = (start + end) / 2;
        // we want positions 0 - 2 to go into the left partition.
        // mid is 3 and mid --> end goes into right.
        // after 2 recursive calls to mergeSort, array is partitioned.
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }

    static void merge(int[] input, int start, int mid, int end){

        // if true the all elements in left partition are less than
        // right elements
        if (input[mid - 1] <= input[mid]){
            msComparisonCount++;
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;
        int[] temp = new int[end - start];
        while (i < mid && j < end){
            msComparisonCount++;
            if (input[i] <= input[j]){
                temp[tempIndex] = input[i];
                i++;
                tempIndex++;
                msInterchangeCount++;
            } else {
                temp[tempIndex] = input[j];
                j++;
                tempIndex++;
                msInterchangeCount++;
            }
        }
        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }

    public static int getBsComparisonCount() {
        return bsComparisonCount;
    }

    public static int getBsInterchangeCount() {
        return bsInterchangeCount;
    }

    public static int getQsComparisonCount() {
        return qsComparisonCount;
    }

    public static int getQsInterchangeCount() {
        return qsInterchangeCount;
    }

    public static int getMsComparisonCount() {
        return msComparisonCount;
    }

    public static int getMsInterchangeCount() {
        return msInterchangeCount;
    }
}
