package ad.page8_kfg;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by MattX7 on 16.11.2016.
 */
public class KFGImpl implements KFG {
    private Set<Terminal> terminals = new HashSet<Terminal>();
    private Set<NonTerminal> nonTerminals = new HashSet<NonTerminal>();
    private Set<Production> productions = new HashSet<>();
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
//            if (hasProduction(production))
//                throw new IllegalArgumentException("KFG has production already: " + production);
//            if (!nonTerminals.contains(production.getLeft()))
//                throw new IllegalArgumentException("KFG does not offer the offered left side " + production);
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
    public void setStart(@NotNull String start) throws IllegalArgumentException {
        // Precondition
        if (!hasNonTerminal(start))
            throw new IllegalArgumentException("KFG has no NonTerminal: " + start);
        // Implementation
        this.start = this.getNonTerminal(start);
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
//        for (Terminal terminal : word) {
//            if (!hasTerminal(terminal))
//                throw new IllegalArgumentException("KFG has no Terminal: " + terminal); // TODO Exc or null?
//        }
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
    public Boolean hasNonTerminal(@NotNull String nonTerminal) {
        return nonTerminals.stream().anyMatch(e -> nonTerminal.equals(e.getId()));
    }

    /**
     * Returns true if KFG has the given terminal
     *
     * @param terminal is included?
     * @return True if KFG has the given terminal
     */
    @NotNull
    public Boolean hasTerminal(@NotNull String terminal) {
        return terminals.stream().anyMatch(e -> terminal.equals(e.getId()));
    }

    /**
     * Returns true if KFG has the given production
     *
     * @param production is included?
     * @return True if KFG has the given production
     */
    @NotNull
    public Boolean hasProduction(@NotNull String production) {
        String leftPattern = "[A-Z]"; // TODO single point of control!
        String rightPattern = "[a-zA-Z#]+";
        String productionPattern = "(" + leftPattern + ")" + "\\p{Blank}*->\\p{Blank}*" + "(" + rightPattern + ")";

        Pattern pattern = Pattern.compile(productionPattern);
        Matcher matcher = pattern.matcher(production);

        if (matcher.matches()) {
            String left = matcher.group(1);
            String right = matcher.group(2);

            NonTerminal leftValue = new NonTerminal(String.valueOf(left.charAt(0)));
            Set<Letter> rightValues = new HashSet<>();

            for (int i = 0; i < right.length(); i++) {
                if (Character.isUpperCase(right.charAt(i))) {
                    rightValues.add(this.getNonTerminal(String.valueOf(right.charAt(i))));
                } else {
                    Terminal terminal = this.getTerminal(String.valueOf(right.charAt(i)));
                    rightValues.add(terminal);
                }
            }

            for (Production prod : productions) {
                if (prod.getLeft().getId().equals(left)) {
                    if (prod.getRight().size() == rightValues.size()) {
                        if (prod.getRight().containsAll(rightValues))
                            return true;
                    }
                }
            }
            return false;
//            return productions.stream() TODO to stream
//                    .filter(e -> e.getLeft().getId().equals(left))
//                    .filter(e -> e.getRight().size() == right.length())
//                    .allMatch(e -> e.getRight().containsAll(rightValues));


        } else {
            throw new IllegalArgumentException("Invalid production rule: " + production);
        }
    }

    public Set<Terminal> getTerminals() {
        return terminals;
    }

    public Set<NonTerminal> getNonTerminals() {
        return nonTerminals;
    }

    public Set<Production> getProductions() {
        return productions;
    }

    public NonTerminal getStart() {
        return start;
    }

    @Override
    public NonTerminal getNonTerminal(String nonTerminal) {
        return nonTerminals.stream().filter(e -> e.getId().equals(nonTerminal)).findFirst().get();
    }

    @Override
    public Terminal getTerminal(String terminal) {
        return terminals.stream().filter(e -> e.getId().equals(terminal)).findFirst().get();
    }

    @Override
    public String toString() {
        return String.format("G = (\n\tN = %s,\n\tT = %s,\n\tP = %s,\n\tA = %s\n)", nonTerminals, terminals, productions, start);
    }
}
