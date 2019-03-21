package com.patty3130;

        import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        HashMap<String, int[]> results = Run.runAllSorts();

        System.out.println("************************* 10 RECORDS ************************");
        Run.compareSorts(results, "bsrt10RAN", "qsrt10RAN", "msrt10RAN");
        Run.compareSorts(results, "bsrt10REV", "qsrt10REV", "msrt10REV");
        Run.compareSorts(results, "bsrt10ALM", "qsrt10ALM", "msrt10ALM");


        System.out.println("************************* 50 RECORDS ************************");
        Run.compareSorts(results, "bsrt50RAN", "qsrt50RAN", "msrt50RAN");
        Run.compareSorts(results, "bsrt50REV", "qsrt50REV", "msrt50REV");
        Run.compareSorts(results, "bsrt50ALM", "qsrt50ALM", "msrt50ALM");

        System.out.println("************************* 100 RECORDS ***********************");
        Run.compareSorts(results, "bsrt1-RAN", "qsrt1-RAN", "msrt1-RAN");
        Run.compareSorts(results, "bsrt1-REV", "qsrt1-REV", "msrt1-REV");
        Run.compareSorts(results, "bsrt1-ALM", "qsrt1-ALM", "msrt1-ALM");
    }
}
