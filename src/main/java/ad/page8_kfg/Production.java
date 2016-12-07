package ad.page8_kfg;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by MattX7 on 16.11.2016.
 */
public class Production {
    private NonTerminal left;
    private List<Letter> right;

    public Production(NonTerminal left, Letter... right) {
        this.left = left;
        this.right = new LinkedList<Letter>();
        Collections.addAll(this.right, right);
    }

    public void setLeft(NonTerminal left) {
        this.left = left;
    }

    public void setRight(Letter... right) {
        Collections.addAll(this.right, right);
    }

    public NonTerminal getLeft() {  return left; }

    public List<Letter> getRight() {
        return this.right;
    }

    public Boolean hasLeft(NonTerminal lefty) {  return getLeft().equals(lefty);}

    public boolean hasRight(Letter letter) {
        return right.contains(letter);
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", left, right);
    }
}
