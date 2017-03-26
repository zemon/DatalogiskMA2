/**
 * Created by Simon on 24-03-2017.
 */
public class State {
    public int numb;
    public boolean init;
    public String[] labels;
    public int[] transitions;

    public State(int numb, boolean init, String[] labels, int[] transitions){
        this.numb = numb;
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
        return "id: "+ numb + " init: " + init + " label: " + labelS + " transitions to: " + transitionsS;
    }
    public boolean Equals(State state){
        return this.numb == state.numb;
    }
}
