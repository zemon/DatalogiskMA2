import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main( String[] args){
        TransitionSystem ts = new TransitionSystem();
        ts.add(1,true, new String[] {"v"}, new int[] {2});
        ts.add(2,false, new String[] {"v"}, new int[] {1,4});
        ts.add(3,false, new String[] {"c"}, new int[] {4});
        ts.add(4,false, new String[] {"c"}, new int[] {3});
        ArrayList<State> apList = ts.ctlAP("c");
        ArrayList<State> agList = ts.ctlAG(apList);
        ArrayList<State> exList = ts.ctlEX(agList);
        exList=ts.ctlEX(exList);



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
/*
        System.out.println("AX");

        for (State state : exList){
            System.out.println(state.toString());
        }

        System.out.println("EF");

        for (State state : exList) {
            System.out.println(state.toString());
        }
        */
    }
}
