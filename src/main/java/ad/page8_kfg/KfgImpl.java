package ad.page8_kfg;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by MattX7 on 16.11.2016.
 */
public class KfgImpl implements KFG {
    private List<Terminal> terminals = new LinkedList<Terminal>();
    private List<NonTerminal> nonTerminals = new LinkedList<NonTerminal>();
    private List<Production> productions = new LinkedList<Production>();
    private NonTerminal start;

    /**
     * Adds Terminal to the KFG
     *
     * @param terminals terminal for the KFG
     */
    public void addTerminal(@NotNull Terminal... terminals) {
        Collections.addAll(this.terminals, terminals);
    }

    /**
     * Adds NonTerminal to the KFG
     *
     * @param nonTerminals nonTerminal for the KFG
     */
    public void addNonTerminal(@NotNull NonTerminal... nonTerminals) {
        Collections.addAll(this.nonTerminals, nonTerminals);
    }

    /**
     * Adds Production Functions to the KFG
     *
     * @param productions production function for the KFG
     */
    public void addProduction(@NotNull Production... productions) {
        // TODO Preconditions
        for (Production prod : productions) {
            if (hasProduction(prod))
                throw new IllegalArgumentException("KFG has production already: " + prod);
            if (!nonTerminals.contains(prod.getLeft()))
                throw new IllegalArgumentException("KFG does not offer the offered left side " + prod);
            if (!nonTerminals.contains(prod.getRight()) || !terminals.contains(prod.getRight()))
                throw new IllegalArgumentException("KFG does not offer the offered right side " + prod);
        }
        Collections.addAll(this.productions, productions);

    }

    /**
     * Sets a given NonTerminal as start
     *
     * @param start NonTerminal that should be the start
     * @throws IllegalArgumentException if param has unknown state
     */
    public void setStart(@NotNull NonTerminal start) throws IllegalArgumentException {
        // Precondition
        if (!hasNonTerminal(start))
            throw new IllegalArgumentException("KFG has no NonTerminal: " + start);
        // Implementation
        this.start = start;
    }

    /**
     * Returns true if word is acceptable
     *
     * @param word symbols that should end at a acceptable state
     * @return true if word is acceptable
     * @throws IllegalArgumentException if param has unknown symbols
     */
    @NotNull
    public Boolean checkWord(@NotNull Terminal... word) throws IllegalArgumentException {
        // TODO checkWord
        return null;
    }

    /**
     * Returns true if KFG is empty
     *
     * @return true if KFG is empty
     */
    @NotNull
    public Boolean isEmpty() {
        return productions.isEmpty();
    }

    /**
     * Returns true if KFG has the given nonTerminal
     *
     * @param nonTerminal is included?
     * @return True if KFG has the given nonTerminal
     */
    @NotNull
    public Boolean hasNonTerminal(@NotNull NonTerminal nonTerminal) {
        return nonTerminals.contains(nonTerminal);
    }

    /**
     * Returns true if KFG has the given terminal
     *
     * @param terminal is included?
     * @return True if KFG has the given terminal
     */
    @NotNull
    public Boolean hasTerminal(@NotNull Terminal terminal) {
        return terminals.contains(terminal);
    }

    /**
     * Returns true if KFG has the given production
     *
     * @param production is included?
     * @return True if KFG has the given production
     */
    @NotNull
    public Boolean hasProduction(@NotNull Production production) {
        return productions.contains(production);
    }
}
