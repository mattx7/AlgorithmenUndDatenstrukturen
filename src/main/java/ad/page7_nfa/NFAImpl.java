package ad.page7_nfa;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by MattX7 on 09.11.2016.
 */
public class NFAImpl implements NFA {
    private Set<State> states;
    private Set<Symbol> symbols;
    private Set<TransitionFunction> transitionFunctions;
    private State start;
    private List<State> ends;
    private State currentState;

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
            // Precondition
            if (!hasState(function.getFromState()))
                throw new IllegalArgumentException("NFA has no State: " + function.getFromState());
            if (!hasSymbol(function.getWithSymbol()))
                throw new IllegalArgumentException("NFA has no Symbol: " + function.getWithSymbol());
            if (!hasState(function.getToStates()))
                throw new IllegalArgumentException("NFA has no State: " + function.getToStates());
            // Implementation
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
        // Precondition
        if (!hasState(start))
            throw new IllegalArgumentException("NFA has no State: " + start);
        // Implementation
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
            // Precondition
            if (!hasState(end))
                throw new IllegalArgumentException("NFA has no State: " + end);
            // Implementation
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
    public Boolean checkWord(@NotNull List<Symbol> word) throws IllegalArgumentException {
        // Precondition
        for (Symbol symbol : word) {
            if (!hasSymbol(symbol))
                throw new IllegalArgumentException("NFA has no Symbol: " + symbol); // TODO Exc or null?
        }
        List<State> currentStates = transition(start, word.get(0));
        if (currentStates.isEmpty()) {
            return false;
        }
        // Implementation


        return _checkLetters(transition(start, word.get(0)), word, 1);
    }

    @NotNull
    private Boolean _checkLetters(@NotNull List<State> states,
                                  @NotNull List<Symbol> word,
                                  @NotNull Integer idx) {

        // Abbruchbedingungen
        if (lastLetterReached(word, idx)) { // Ende des Wortes erreicht?
            for (State state : states) {
                if (atAcceptableEndState(state))  // Endzustand erreicht? -> true
                    return true;
            }
            return false;
        }
        // Zustände durchlaufen
        for (State state : states) {
            // zu den nächsten Zuständen
            List<State> newStates = transition(state, word.get(idx));
            if (!newStates.isEmpty()) // min ein Zustand mit Symbol gefunden?
                return _checkLetters(newStates, word, idx + 1);
        }
        return false;
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
     * Returns true if NFA has the given symbol
     *
     * @param symbol is included?
     * @return True if NFA has the given symbol
     */
    @NotNull
    public Boolean hasSymbol(@NotNull Symbol symbol) {
        return symbols.contains(symbol);
    }

    /**
     * Returns true if NFA has the given state
     *
     * @param state is included?
     * @return True if NFA has the given state
     */
    @NotNull
    public Boolean hasState(@NotNull State state) {
        return states.contains(state);
    }

    /**
     * Returns true if NFA has the given function
     *
     * @param function is included?
     * @return True if NFA has the given function
     */
    @NotNull
    public Boolean hasTransitionFunction(@NotNull TransitionFunction function) {
        return transitionFunctions.contains(function);
    }

    // ===== PRIVATE =====

    /**
     * Returns a Set of new States. Could be empty.
     *
     * @param state  From this State
     * @param symbol With this Symbol
     * @return Set of States
     */
    @NotNull
    private List<State> transition(@NotNull State state, @NotNull Symbol symbol) {
        List<State> newStates = new LinkedList<State>();
        for (TransitionFunction function : transitionFunctions) {
            if (function.getFromState() == state && function.getWithSymbol() == symbol)
                newStates.add(function.getToStates());
        }
        return newStates;
    }

    /**
     * Returns a Set of applicable Symbols. Could be empty.
     *
     * @param symbol From this State
     * @return Set of applicable Symbols. Could be empty.
     */
    @NotNull
    private List<Symbol> applicableSymbolsFor(@NotNull Symbol symbol) {
        List<Symbol> newSymbols = new LinkedList<Symbol>();
        for (TransitionFunction function : transitionFunctions) {
            if (function.getWithSymbol() == symbol)
                newSymbols.add(function.getWithSymbol());
        }
        return newSymbols;
    }

    @NotNull
    private Boolean lastLetterReached(@NotNull List<Symbol> word,
                                      @NotNull Integer idx) {
        return word.get(idx) == word.get(word.size() - 1);
    }

    @NotNull
    private Boolean atAcceptableEndState(State state) {
        for (State end : ends) {
            if (state == end)
                return true;
        }
        return false;
    }
}
