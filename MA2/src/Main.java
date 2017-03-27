import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main( String[] args){
        TransitionSystem ts = new TransitionSystem();

        ts.add(1,true, new String[] {"AAA"}, new int[] {2,3});
        ts.add(2,false, new String[] {"BAA"}, new int[] {1,3,4});
        ts.add(3,false, new String[] {"CAA"}, new int[] {1,2,5});
        ts.add(4,false, new String[] {"BCA"}, new int[] {2,6,7});
        ts.add(5,false, new String[] {"CBA"}, new int[] {3,8,9});
        ts.add(6,false, new String[] {"CCA"}, new int[] {4,7,10});
        ts.add(7,false, new String[] {"ACA"}, new int[] {4,6,8});
        ts.add(8,false, new String[] {"ABA"}, new int[] {5,7,9});
        ts.add(9,false, new String[] {"BBA"}, new int[] {5,8,11});
        ts.add(10,false, new String[] {"CCB"}, new int[] {6,12,13});
        ts.add(11,false, new String[] {"BBC"}, new int[] {9,14,15});
        ts.add(12,false, new String[] {"ACB"}, new int[] {10,13,16});
        ts.add(13,false, new String[] {"BCB"}, new int[] {10,12,17});
        ts.add(14,false, new String[] {"CBC"}, new int[] {11,15,18});
        ts.add(15,false, new String[] {"ABC"}, new int[] {11,14,19});
        ts.add(16,false, new String[] {"ABB"}, new int[] {12,20,21});
        ts.add(17,false, new String[] {"BAB"}, new int[] {13,22,23});
        ts.add(18,false, new String[] {"CAC"}, new int[] {14,24,25});
        ts.add(19,false, new String[] {"ACC"}, new int[] {15,26,27});
        ts.add(20,false, new String[] {"BBB"}, new int[] {16,21});
        ts.add(21,false, new String[] {"CBB"}, new int[] {16,20,22});
        ts.add(22,false, new String[] {"CAB"}, new int[] {17,21,23});
        ts.add(23,false, new String[] {"AAB"}, new int[] {17,22,24});
        ts.add(24,false, new String[] {"AAC"}, new int[] {23,18,25});
        ts.add(25,false, new String[] {"BAC"}, new int[] {18,24,26});
        ts.add(26,false, new String[] {"ABA"}, new int[] {19,25,27});
        ts.add(27,false, new String[] {"CCC"}, new int[] {19,26});

        
        
        ArrayList<State> apList = ts.ctlAP("CCC");
        ArrayList<State> exList = ts.ctlEX(ts.ctlEX(ts.ctlEX(apList)));
        ArrayList<State> agList = ts.ctlAG(exList);




        System.out.println(ts.toString());


        System.out.println("AP");

        printArray(apList);

        System.out.println("exList:");

        printArray(exList);

        System.out.println("aglist");

        printArray(agList);





/*
        System.out.println("AG");

        for (State state : agList){
            System.out.println(state.toString());
        }




        System.out.println("AX");

        for (State state : axList){
            System.out.println(state.toString());
        }

        System.out.println("EF");

        printArray(efList);
        System.out.println("\n " + ts.ctlCheckInitialStates(efList));
        */

    }
    public static void printArray(ArrayList<State> states){
        for (State state : states) {
            System.out.println(state.toString());
        }
    }
}
