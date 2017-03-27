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
    // Creates a new state with the given attributes and put them the lists they need to be
    public void add(int num, boolean init, String[] label, int[] transitions){

            states.add(new State(num,init,label,transitions));
            if(init){
                initStates.add(new State(num,init,label,transitions));
            }

    }

    // Returns a list, which is combined of the 2 given lists
    public ArrayList<State> ctlAnd(ArrayList<State> stateList1, ArrayList<State> stateList2){
        ArrayList<State> list = new ArrayList<>();
        list.addAll(stateList1);

        for (State state: stateList2) {
            if(!list.contains(state)){
                list.add(state);
            }

        }
        return list;
    }

    // returns all the states that are not in the given list
    public ArrayList<State> ctlNot(ArrayList<State> stateList){
        ArrayList<State> list = new ArrayList<>();
        for (State state: this.states) {
            if(!stateList.contains(state)){
                list.add(state);
            }

        }
        return list;
    }
    // returns all the states with the given proposition
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
    // Checks if there is a transition from any state to one of the given states, and return those who has.
    public ArrayList<State> ctlEX(ArrayList<State> tempStates){
        ArrayList<State> list = new ArrayList<>();
        for (State state:this.states             ) {
            for(int transition:state.transitions){


                for (State temp: tempStates                ) {
                    if(transition == temp.id && !list.contains(state)){
                        list.add(state);
                    }

                }
            }


        }

        return list;
    }
    // Returns all states which in any way can go to one of the given states in any number of transitions.
    // One way to do this is calling EX the same time as states, as that is the maximum number of transitions.
    public ArrayList<State> ctlEF(ArrayList<State> states){
        ArrayList<State> list = new ArrayList<>();
        list = ctlEX(states);

        for(int i = 0; i<this.states.size(); i++){
            list = ctlEX(list);
       }

        return list;
    }
    // checks which states always end in one of the given states no matter what, and return those who can
    public ArrayList<State> ctlAX(ArrayList<State> states){
        ArrayList<State> list = new ArrayList<>();

        ArrayList<Integer> idList = new ArrayList<>();
        for (State state : states){

            idList.add(state.id);

        }
        list.addAll(this.states);


        for (int i = 0; i < list.size(); i++){

            for (int trasition : list.get(i).transitions){
                if(!idList.contains(trasition)){

                    list.remove(i);

                    i--;
                    break;
                }
            }
        }

        return list;

    }
    //Checks if any of the given states can transition to a state that isn't in the given states and remove these from the list.
    public ArrayList<State> ctlAG(ArrayList<State> states){
        ArrayList<Integer> idList = new ArrayList<>();
        for (State state : states){
            idList.add((state.id));
        }

        for (int i = 0; i < states.size() && i>=0; i++){

            for (int trasition : states.get(i).transitions){
                //System.out.println(i);
                if(!idList.contains(trasition)){
                    states.remove(i);
                    i--;
                    break;

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
