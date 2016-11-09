package ad.page4_nfa_sort.nfa;

import java.util.List;

/**
 * Created by MattX7 on 09.11.2016.
 */
public class TransitionFunction {
    private State fromState;
    private Symbol withSymbol;
    private List<State> toStates;

    /**
     * State x Symbol -> P(State)
     *
     * @param fromState  From
     * @param withSymbol with
     * @param toStates   to
     */
    public TransitionFunction(State fromState, Symbol withSymbol, List<State> toStates) {
        this.fromState = fromState;
        this.withSymbol = withSymbol;
        this.toStates = toStates;
    }

    public State getFromState() {
        return fromState;
    }

    public void setFromState(State fromState) {
        this.fromState = fromState;
    }

    public Symbol getWithSymbol() {
        return withSymbol;
    }

    public void setWithSymbol(Symbol withSymbol) {
        this.withSymbol = withSymbol;
    }

    public List<State> getToStates() {
        return toStates;
    }

    public void setToStates(List<State> toStates) {
        this.toStates = toStates;
    }

    @Override
    public String toString() {
        return "TF{"
                + fromState + " x "
                + withSymbol + " -> "
                + toStates +
                '}';
    }
}
