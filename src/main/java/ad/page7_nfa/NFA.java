package ad.page7_nfa;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created by MattX7 on 09.11.2016.
 */
public interface NFA {

    /**
     * Adds states to the NFA
     *
     * @param states States from the NFA
     */
    void addStates(@NotNull State... states);

    /**
     * Adds input symbols to the NFA
     *
     * @param symbols Symbols from the NFA
     */
    void addInputSymbols(@NotNull Symbol... symbols);

    /**
     * Adds transition functions to the NFA <br>
     * State x Symbol -> P(State)
     *
     * @param functions Transition functions
     * @throws IllegalArgumentException if param has unknown states or symbols
     */
    void addTransitionFunctions(@NotNull TransitionFunction... functions) throws IllegalArgumentException;

    /**
     * Sets a given state as start
     *
     * @param start State that should be the start
     * @throws IllegalArgumentException if param has unknown state
     */
    void setStart(@NotNull State start) throws IllegalArgumentException;

    /**
     * Sets given state as acceptable end
     *
     * @param ends acceptable end state
     * @throws IllegalArgumentException if param has unknown states
     */
    void setEnd(@NotNull State... ends) throws IllegalArgumentException;

    /**
     * Returns true if word is acceptable
     *
     * @param word symbols that should end at a acceptable state
     * @return true if word is acceptable
     * @throws IllegalArgumentException if param has unknown states or symbols
     */
    @NotNull
    Boolean checkWord(@NotNull List<Symbol> word) throws IllegalArgumentException;

    /**
     * Returns true if NFA is empty
     *
     * @return true if NFA is empty
     */
    @NotNull
    Boolean isEmpty();

    /**
     * Returns true if NFA has the given symbol
     *
     * @param symbol is included?
     * @return True if NFA has the given symbol
     */
    @NotNull
    Boolean hasSymbol(@NotNull Symbol symbol);

    /**
     * Returns true if NFA has the given state
     *
     * @param state is included?
     * @return True if NFA has the given state
     */
    @NotNull
    Boolean hasState(@NotNull State state);

    /**
     * Returns true if NFA has the given function
     *
     * @param function is included?
     * @return True if NFA has the given function
     */
    @NotNull
    Boolean hasTransitionFunction(@NotNull TransitionFunction function);


}
