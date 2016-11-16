package ad.page7_nfa;

/**
 * Created by MattX7 on 09.11.2016.
 */
public class TransitionFunction {
    private State fromState;
    private Symbol withSymbol;
    private State toState;

    /**
     * State x Symbol -> P(State)
     *
     * @param fromState  From
     * @param withSymbol with
     * @param toState   to
     */
    public TransitionFunction(State fromState, Symbol withSymbol, State toState) {
        this.fromState = fromState;
        this.withSymbol = withSymbol;
        this.toState = toState;
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

    public State getToStates() {
        return toState;
    }

    public void setToState(State toState) {
        this.toState = toState;
    }

    @Override
    public String toString() {
        return "TF{"
                + fromState + " x "
                + withSymbol + " -> "
                + toState +
                '}';
    }
}
