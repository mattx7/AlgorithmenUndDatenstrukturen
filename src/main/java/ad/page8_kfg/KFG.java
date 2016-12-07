package ad.page8_kfg;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        for (String production : productions) {
            String leftPattern = "[A-Z]";
            String rightPattern = "[a-zA-Z#]+";
            String productionPattern = "(" + leftPattern + ")" + "\\p{Blank}*->\\p{Blank}*" + "(" + rightPattern + ")";

            Pattern pattern = Pattern.compile(productionPattern);
            Matcher matcher = pattern.matcher(production);

            if (matcher.matches()) {
                // left side
                String left = matcher.group(1);
                if (left.length() == 1 && Character.isUpperCase(left.charAt(0)))
                    kfg.addTerminal(Terminal.valueOf(left));
                else throw new IllegalArgumentException("Invalid letter at the left side of Production: " + production);

                // right side
                String right = matcher.group(2);
                for (int i = 0; i < right.length(); i++) {
                    char letter = right.charAt(i);
                    // ASCII Table: https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html
                    if (Character.isUpperCase(letter)) {
                        kfg.addNonTerminal(NonTerminal.valueOf(String.valueOf(letter)));
                    } else {
                        kfg.addTerminal(Terminal.valueOf(String.valueOf(letter)));
                    }
                }

            } else {
                throw new IllegalArgumentException("Invalid production rule: " + production);
            }
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

    List<Terminal> getTerminals();

    List<NonTerminal> getNonTerminals();

    List<Production> getProductions();

    NonTerminal getStart();


}
