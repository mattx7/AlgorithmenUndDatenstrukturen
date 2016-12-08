package ad.page8_kfg;

import org.jetbrains.annotations.NotNull;

import java.util.Set;

/**
 * Created by MattX7 on 16.11.2016.
 */
public interface KFG {

    /**
     * Adds Production Functions to the KFG.
     * <p>
     * Creates letters and production rules automatically
     *
     * @param productions production function for the KFG
     */
    static KFG compile(@NotNull String... productions) throws IllegalArgumentException {
        KFG kfg = new KFGImpl();

        for (String prodString : productions) {
            Production production = Production.valueOf(prodString);
            if (!kfg.hasNonTerminal(String.valueOf(production.getLeft())))
                kfg.addNonTerminal(production.getLeft());


            for (Letter letter : production.getRight()) {
                if (Character.isUpperCase(letter.getId().charAt(0))) {
                    if (!kfg.hasNonTerminal(String.valueOf(letter)))
                        kfg.addNonTerminal(NonTerminal.valueOf(String.valueOf(letter)));
                } else {
                    if (!kfg.hasNonTerminal(String.valueOf(letter)) && !kfg.hasTerminal(String.valueOf(letter)))
                        kfg.addTerminal(Terminal.valueOf(String.valueOf(letter)));
                }
            }

            kfg.addProduction(production);

        }
        return kfg;
    }

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
    void addProduction(@NotNull Production... productions) throws IllegalArgumentException;

    /**
     * Sets a given NonTerminal as start
     *
     * @param start NonTerminal that should be the start
     * @throws IllegalArgumentException if param has unknown state
     */
    void setStart(@NotNull String start) throws IllegalArgumentException;

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
    Boolean hasNonTerminal(@NotNull String nonTerminal);

    /**
     * Returns true if KFG has the given terminal
     *
     * @param terminal is included?
     * @return True if KFG has the given terminal
     */
    @NotNull
    Boolean hasTerminal(@NotNull String terminal);

    /**
     * Returns true if KFG has the given production
     *
     * @param production is included?
     * @return True if KFG has the given production
     */
    @NotNull
    Boolean hasProduction(@NotNull String production);

    Set<Terminal> getTerminals();

    Set<NonTerminal> getNonTerminals();

    Set<Production> getProductions();

    NonTerminal getStart();

    NonTerminal getNonTerminal(String nonTerminal);

    Terminal getTerminal(String terminal);
}
