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
public class Production {
    private NonTerminal left;
    private Set<Letter> right;

    public Production(NonTerminal left, Letter... right) {
        this.left = left;
        this.right = new HashSet<>();
        Collections.addAll(this.right, right);
    }

    public Production(NonTerminal left, Set<Letter> right) {
        this.left = left;
        this.right = new HashSet<>();
        this.right = right;
    }

    public void setLeft(NonTerminal left) {
        this.left = left;
    }

    public void setRight(Letter... right) {
        Collections.addAll(this.right, right);
    }

    public NonTerminal getLeft() {
        return left;
    }

    public Set<Letter> getRight() {
        return this.right;
    }

    public Boolean hasLeft(NonTerminal lefty) {
        return getLeft().equals(lefty);
    }

    public boolean hasRight(Letter letter) {
        return right.contains(letter);
    }

    /**
     * Creates an instance from a string.
     *
     * @param production X->xXy
     * @return instance of production
     */
    @NotNull
    public static Production valueOf(@NotNull String production) {

        String leftPattern = "[A-Z]";
        String rightPattern = "[a-zA-Z#]+";
        String productionPattern = "(" + leftPattern + ")" + "\\p{Blank}*->\\p{Blank}*" + "(" + rightPattern + ")";

        Pattern pattern = Pattern.compile(productionPattern);
        Matcher matcher = pattern.matcher(production);

        NonTerminal leftValue;
        Set<Letter> rightValues = new HashSet<>();

        if (matcher.matches()) {
            // left side
            String left = matcher.group(1);
            if (left.length() == 1 && Character.isUpperCase(left.charAt(0)))
                leftValue = NonTerminal.valueOf(left);
            else throw new IllegalArgumentException("Invalid letter at the left side of Production: " + production);
            // right side
            String right = matcher.group(2);
            for (int i = 0; i < right.length(); i++) {
                char letter = right.charAt(i);
                // ASCII Table: https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html
                if (Character.isUpperCase(letter))
                    rightValues.add(NonTerminal.valueOf(String.valueOf(letter)));
                else
                    rightValues.add(Terminal.valueOf(String.valueOf(letter)));
            }


            return new Production(leftValue, rightValues);
        } else throw new IllegalArgumentException("Invalid production rule: " + production);
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", left, right);
    }
}
