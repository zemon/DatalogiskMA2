
public class State {
    public int id;
    public boolean init;
    public String[] labels;
    public int[] transitions;

    public State(int id, boolean init, String[] labels, int[] transitions){
        this.id = id;
        this.init = init;
        this.labels = labels;
        this.transitions = transitions;

    }

    public String toString(){
        String labelS = "";
        String transitionsS = "";
        for (String label : labels){
            labelS = labelS + " " +label;
        }
        for(int transition : transitions){
            transitionsS = transitionsS +" "+ transition;
        }
        return "id: "+ id + " init: " + init + " label: " + labelS + " transitions to: " + transitionsS;
    }

    public boolean equals(Object other){
        if(other==null) return false;
        if(other==this) return true;
        if(!(other instanceof State)) return false;
        State otherState = (State)other;
        return this.id == otherState.id;
    }
}
