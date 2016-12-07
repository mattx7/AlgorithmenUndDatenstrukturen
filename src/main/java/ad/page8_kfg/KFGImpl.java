package ad.page8_kfg;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by MattX7 on 16.11.2016.
 */
public class KFGImpl implements KFG {
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
    public void addProduction(@NotNull Production... productions) throws IllegalArgumentException {
        for (Production production : productions) {
            if (hasProduction(production))
                throw new IllegalArgumentException("KFG has production already: " + production);
            if (!nonTerminals.contains(production.getLeft()))
                throw new IllegalArgumentException("KFG does not offer the offered left side " + production);
//            if (!nonTerminals.containsAll(production.getRight()) && !terminals.containsAll(production.getRight())) // TODO contains right?
//                throw new IllegalArgumentException("KFG does not offer the offered right side " + production);
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
     * @param word terminals that should end at a acceptable state
     * @return true if word is acceptable
     * @throws IllegalArgumentException if param has unknown symbols
     */
    @NotNull
    public Boolean checkWord(@NotNull Terminal... word) throws IllegalArgumentException {
        // TODO checkWord
        // Precondition
        for (Terminal terminal : word) {
            if (!hasTerminal(terminal))
                throw new IllegalArgumentException("KFG has no Terminal: " + terminal); // TODO Exc or null?
        }
        // Implementation
//        return _checkWord(word);
        return null;
    }

//    /**
//     * Returns Productions for a Terminal(left side) or empty if we have no Production
//     *
//     * @param terminal (left side)
//     * @return Productions for a Terminal(left side) or empty if we have no Production
//     */
//    private List<Production> productionsForTerminal(Terminal terminal) {
//        List<Production> prodsForTerminal = new LinkedList<Production>();
//        for (Production p : productions) {
//            if (p.hasLeft(terminal)){
//                prodsForTerminal.add(p);
//            }
//        }
//        return prodsForTerminal;
//    }


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

    public List<Terminal> getTerminals() {
        return terminals;
    }

    public List<NonTerminal> getNonTerminals() {
        return nonTerminals;
    }

    public List<Production> getProductions() {
        return productions;
    }

    public NonTerminal getStart() {
        return start;
    }

    @Override
    public String toString() {
        return String.format("G = (\n\tN = %s,\n\tT = %s,\n\tP = %s,\n\tA = %s\n)", nonTerminals, terminals, productions, start);
    }
}
