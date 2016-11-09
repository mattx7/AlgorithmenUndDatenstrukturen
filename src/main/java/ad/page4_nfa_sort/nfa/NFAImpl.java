package ad.page4_nfa_sort.nfa;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

/**
 * Created by MattX7 on 09.11.2016.
 */
public class NFAImpl implements NFA {
    private List<State> states;
    private List<Symbol> symbols;
    private List<TransitionFunction> transitionFunctions;
    private State start;
    private List<State> ends;


    /**
     * Adds states to the NFA
     *
     * @param states States from the NFA
     */
    public void addStates(@NotNull State... states) {
        Collections.addAll(this.states, states);
    }

    /**
     * Adds input symbols to the NFA
     *
     * @param symbols Symbols from the NFA
     */
    public void addInputSymbols(@NotNull Symbol... symbols) {
        Collections.addAll(this.symbols, symbols);
    }

    /**
     * Adds transition functions to the NFA <br>
     * State x Symbol -> P(State)
     *
     * @param functions Transition functions
     * @throws IllegalArgumentException if param has unknown states or symbols
     */
    public void addTransitionFunctions(@NotNull TransitionFunction... functions) throws IllegalArgumentException {
        for (TransitionFunction function : functions) {
            if (!hasState(function.getFromState()))
                throw new IllegalArgumentException("NFA has no State: " + function.getFromState());
            if (!hasSymbol(function.getWithSymbol()))
                throw new IllegalArgumentException("NFA has no Symbol: " + function.getWithSymbol());
            for (State endState : function.getToStates()) {
                if (!hasState(endState))
                    throw new IllegalArgumentException("NFA has no State: " + endState);
            }

            this.transitionFunctions.add(function);
        }
    }

    /**
     * Sets a given state as start
     *
     * @param start State that should be the start
     * @throws IllegalArgumentException if param has unknown state
     */
    public void setStart(@NotNull State start) throws IllegalArgumentException {
        if (!hasState(start))
            throw new IllegalArgumentException("NFA has no State: " + start);
        this.start = start;
    }

    /**
     * Sets given state as acceptable end
     *
     * @param ends acceptable end state
     * @throws IllegalArgumentException if param has unknown states
     */
    public void setEnd(@NotNull State... ends) throws IllegalArgumentException {
        for (State end : ends) {
            if (!hasState(end))
                throw new IllegalArgumentException("NFA has no State: " + end);
            this.ends.add(end);
        }
    }

    /**
     * Returns true if word is acceptable
     *
     * @param word symbols that should end at a acceptable state
     * @return true if word is acceptable
     * @throws IllegalArgumentException if param has unknown states or symbols
     */
    @NotNull
    public Boolean checkWord(@NotNull Symbol... word) throws IllegalArgumentException {
        // TODO checkWord()
        return null;
    }

    /**
     * Returns true if NFA has no states
     *
     * @return true if NFA is empty
     */
    @NotNull
    public Boolean isEmpty() {
        return states.isEmpty();
    }

    /**
     * Returns true is NFA has the given symbol
     *
     * @param symbol is included?
     * @return True is NFA has the given symbol
     */
    @NotNull
    public Boolean hasSymbol(@NotNull Symbol symbol) {
        return symbols.contains(symbol);
    }

    /**
     * Returns true is NFA has the given state
     *
     * @param state is included?
     * @return True is NFA has the given state
     */
    @NotNull
    public Boolean hasState(@NotNull State state) {
        return states.contains(state);
    }
}
