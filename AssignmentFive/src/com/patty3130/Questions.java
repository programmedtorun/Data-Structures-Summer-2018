package com.patty3130;

class Questions {

    // Target node - Richard
    static void printFirstTreeAnswers(GeneralTree tree){
        GenTreeNode richard = tree.getRoot().oldestSon().oldestSon();
        processAnswers(richard);
    }

    // Target node - Michael Jackson
    static void printJacksonFamilyTreeAnswers(GeneralTree tree){
        for (GenTreeNode josephBro : tree.getRoot().getChildren()){
            if (josephBro.getFamilyMember().equals("Joseph")){
                for (GenTreeNode jackson : josephBro.getChildren()){
                    if (jackson.getFamilyMember().equals("MICHAEL")){
                        processAnswers(jackson);
                    }
                }
            }
        }
    }

    // Target node - Eileen
    static void printSettleTreeAnswers(GeneralTree tree){
        for (GenTreeNode settle : tree.getRoot().getChildren()){
            if (settle.getFamilyMember().equals("Ruth")){
                for (GenTreeNode eileen : settle.getChildren()){
                    if (eileen.getFamilyMember().equals("Eileen")){
                        processAnswers(eileen);
                    }
                }
            }
        }
    }

    static void processAnswers(GenTreeNode person){
        System.out.println("*********** Processing Family Tree Questions for " + person.getFamilyMember() + " ****************");
        System.out.println("1) Who is the father of " + person.getFamilyMember() + "?");
        System.out.println("--A) The father of " + person.getFamilyMember() + " is: " +
                person.getFather().getFamilyMember() + ".");
        System.out.println("2) Who are the sons of " + person.getFamilyMember() + "?");
        System.out.println("--A) The sons of " + person.getFamilyMember() + " are:");
        for (GenTreeNode son : person.getChildren()){
            System.out.print(son.getFamilyMember() + " : ");
        }
        System.out.println("\n3) Who are the brothers of " + person.getFamilyMember() + "?");
        System.out.println("--A) The brothers of " + person.getFamilyMember() + " are:");
        for (GenTreeNode bro : person.getBrothers()){
            System.out.print(bro.getFamilyMember() + " : ");
        }
        System.out.println("\n4) Who is the oldest brother of " + person.getFamilyMember() + "?");
        System.out.println("--A) The oldest brother of " + person.getFamilyMember() + " is: "
                + person.oldestBro().getFamilyMember());
        System.out.println("5) Who is the youngest brother of " + person.getFamilyMember() + "?");
        System.out.println("--A) The youngest brother of " + person.getFamilyMember() + " is: "
                + person.youngestBro().getFamilyMember());
        System.out.println("6) Who is the oldest son of " + person.getFamilyMember() + "?");
        System.out.println("--A) The oldest son of " + person.getFamilyMember() + " is: "
                + person.oldestSon().getFamilyMember());
        System.out.println("7) Who is the youngest son of " + person.getFamilyMember() + "?");
        System.out.println("--A) The youngest son of " + person.getFamilyMember() + " is: "
                + person.youngestSon().getFamilyMember());
        System.out.println("8) Who are the uncles of " + person.getFamilyMember() + "?");
        System.out.println("--A) The the uncles of " + person.getFamilyMember() + " are: ");
        for (GenTreeNode uncle : person.getUncles()){
            System.out.print(uncle.getFamilyMember() + " : ");
        }
        System.out.println("\n9) Who is the grandfather of " + person.getFamilyMember() + "?");
        System.out.println("--A) The grandfather of " + person.getFamilyMember() + " is: "
                + person.grandfather().getFamilyMember());
        System.out.println("*************************************************************************");
    }
}
