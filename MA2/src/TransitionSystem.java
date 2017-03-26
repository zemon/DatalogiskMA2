import com.sun.org.apache.xpath.internal.operations.Equals;

import java.util.ArrayList;

/**
 * Created by Simon on 24-03-2017.
 */
public class TransitionSystem {
    ArrayList<State> states;
    ArrayList<State> initStates;

    public TransitionSystem(){
        states = new ArrayList<>();
        initStates = new ArrayList<>();

    }

    public void add(int num, boolean init, String[] label, int[] transitions){
            State temp = new State(num,init,label,transitions);
            states.add(temp);
            if(init){
                initStates.add(temp);
            }

    }

    public ArrayList<State> ctlAP(String label){
        ArrayList<State> list = new ArrayList<>();
        for (State temp: this.states) {
            for (String prop:temp.labels ) {
                if(prop.equals(label)){
                    list.add(temp);
                }

            }

        }
        return list;
    }
    // Checks if there is a transition from any state to one of the given states, and return those who can.
    public ArrayList<State> ctlEX(ArrayList<State> tempStates){
        ArrayList<State> list = new ArrayList<>();
        for (State state:this.states             ) {
            for(int transition:state.transitions){


                for (State temp: tempStates                ) {
                    if(transition == temp.numb){
                        list.add(state);
                    }

                }
            }


        }

        return list;
    }
    // Returns all states which in any way can go to one of the given states in any number of transitions.
    public ArrayList<State> ctlEF(ArrayList<State> states){
        ArrayList<State> list = new ArrayList<>();

        return list;
    }
    // checks which states always end in one of the given states no matter what, and return those who can
    public ArrayList<State> ctlAX(ArrayList<State> states){
        ArrayList<State> list = new ArrayList<>();

        ArrayList<Integer> idList = new ArrayList<>();
        for (State state : states){

            idList.add(state.numb);

        }
        list.addAll(this.states);

        for (int i = 0; i < list.size(); i++){

            for (int trasition : list.get(i).transitions){
                if(!idList.contains(trasition)){
                    list.remove(i);

                    i--;
                }
            }
        }
        System.out.println(list.size());
        return list;

    }
    //Checks if any of the given states can transition to a state that isn't in the given states and return those.
    public ArrayList<State> ctlAG(ArrayList<State> states){
        ArrayList<Integer> idList = new ArrayList<>();
        for (State state : states){
            idList.add((state.numb));
        }

        for (int i = 0; i < states.size(); i++){
            for (int trasition : states.get(i).transitions){
                if(!idList.contains(trasition)){
                    states.remove(i);
                    i--;
                }
            }
        }



        return states;
    }

    public boolean ctlCheckInitialStates(ArrayList<State> states){
        for (int i = 0; i < states.size(); i++) {
            if(!states.get(i).init){
                states.remove(i);
                i--;
            }

        }

        return initStates.equals(states);

    }


    public String toString(){
        String printString = "";
        for (State state : states) {
            printString = printString + "\n" + state.toString();

        }
        return printString;
    }


}
