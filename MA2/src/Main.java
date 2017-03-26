import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main( String[] args){
        TransitionSystem ts = new TransitionSystem();
        ts.add(1,true, new String[] {"v"}, new int[] {2});
        ts.add(2,false, new String[] {"v"}, new int[] {1,4});
        ts.add(3,false, new String[] {"c"}, new int[] {4});
        ts.add(4,false, new String[] {"c"}, new int[] {3});
        
        /*Tower of Hanoi
        ts.add(1,true, new String[] {"A","A","A"}, new int[] {2,3});
        ts.add(2,false, new String[] {"B","A","A"}, new int[] {1,3});
        ts.add(3,false, new String[] {"C","A","A"}, new int[] {1,2});
        ts.add(4,false, new String[] {"B","C","A"}, new int[] {2,6,7});
        ts.add(5,false, new String[] {"C","B","A"}, new int[] {3,8,9});
        ts.add(6,false, new String[] {"C","C","A"}, new int[] {4,7,10});
        ts.add(7,false, new String[] {"A","C","A"}, new int[] {4,6,8});
        ts.add(8,false, new String[] {"A","B","A"}, new int[] {5,7,9});
        ts.add(9,false, new String[] {"B","B","A"}, new int[] {5,8,11});
        ts.add(10,false, new String[] {"C","C","B"}, new int[] {6,12,13});
        ts.add(11,false, new String[] {"B","B","C"}, new int[] {9,14,15});
        ts.add(12,false, new String[] {"A","C","B"}, new int[] {10,13,16});
        ts.add(13,false, new String[] {"B","C","B"}, new int[] {10,12,17});
        ts.add(14,false, new String[] {"C","B","C"}, new int[] {11,15,18});
        ts.add(15,false, new String[] {"A","B","C"}, new int[] {11,14,19});
        ts.add(16,false, new String[] {"A","B","B"}, new int[] {12,20,21});
        ts.add(17,false, new String[] {"B","A","B"}, new int[] {13,22,23});
        ts.add(18,false, new String[] {"C","A","C"}, new int[] {14,24,25});
        ts.add(19,false, new String[] {"A","C","C"}, new int[] {15,26,27});
        ts.add(20,false, new String[] {"B","B","B"}, new int[] {16,21});
        ts.add(21,false, new String[] {"C","B","B"}, new int[] {16,20,22});
        ts.add(22,false, new String[] {"C","A","B"}, new int[] {17,21,23});
        ts.add(23,false, new String[] {"A","A","B"}, new int[] {17,22,24});
        ts.add(24,false, new String[] {"A","A","C"}, new int[] {23,18,25});
        ts.add(25,false, new String[] {"B","A","C"}, new int[] {18,24,26});
        ts.add(26,false, new String[] {"A","B","A"}, new int[] {19,25,27});
        ts.add(27,false, new String[] {"C","C","C"}, new int[] {19,26});
        */
        
        
        ArrayList<State> apList = ts.ctlAP("c");
        ArrayList<State> agList = ts.ctlAG(apList);
        ArrayList<State> exList = ts.ctlEX(agList);
        //exList=ts.ctlEX(exList);
        ArrayList<State> axList = ts.ctlAX(exList);



        System.out.println(ts.toString());
        System.out.println("AP");

        for (State state : apList){
            System.out.println(state.toString());
        }


        System.out.println("AG");

        for (State state : agList){
            System.out.println(state.toString());
        }

        System.out.println("EX");

        for (State state : exList){
            System.out.println(state.toString());
        }
        System.out.println("\n " + ts.ctlCheckInitialStates(exList));

        System.out.println("AX");

        for (State state : axList){
            System.out.println(state.toString());
        }
/*
        System.out.println("EF");

        for (State state : exList) {
            System.out.println(state.toString());
        }
        */
    }
}
