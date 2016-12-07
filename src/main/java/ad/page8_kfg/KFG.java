package ad.page8_kfg;

import org.jetbrains.annotations.NotNull;

/**
 * Created by MattX7 on 16.11.2016.
 */
public interface KFG {

    /**
     * Adds Terminal to the KFG
     *
     * @param terminals terminal for the KFG
     */
    void addTerminal(@NotNull Terminal... terminals);

    /**
     * Adds NonTerminal to the KFG
     *
     * @param nonTerminals nonTerminal for the KFG
     */
    void addNonTerminal(@NotNull NonTerminal... nonTerminals);

    /**
     * Adds Production Functions to the KFG
     *
     * @param productions production function for the KFG
     */
    void addProduction(@NotNull Production... productions);

    /**
     * Sets a given NonTerminal as start
     *
     * @param start NonTerminal that should be the start
     * @throws IllegalArgumentException if param has unknown state
     */
    void setStart(@NotNull NonTerminal start) throws IllegalArgumentException;

    /**
     * Returns true if word is acceptable
     *
     * @param word terminals that should end at a acceptable state
     * @return true if word is acceptable
     * @throws IllegalArgumentException if param has unknown symbols
     */
    @NotNull
    Boolean checkWord(@NotNull Terminal... word) throws IllegalArgumentException;

    /**
     * Returns true if KFG is empty
     *
     * @return true if KFG is empty
     */
    @NotNull
    Boolean isEmpty();

    /**
     * Returns true if KFG has the given nonTerminal
     *
     * @param nonTerminal is included?
     * @return True if KFG has the given nonTerminal
     */
    @NotNull
    Boolean hasNonTerminal(@NotNull NonTerminal nonTerminal);

    /**
     * Returns true if KFG has the given terminal
     *
     * @param terminal is included?
     * @return True if KFG has the given terminal
     */
    @NotNull
    Boolean hasTerminal(@NotNull Terminal terminal);

    /**
     * Returns true if KFG has the given production
     *
     * @param production is included?
     * @return True if KFG has the given production
     */
    @NotNull
    Boolean hasProduction(@NotNull Production production);
}
