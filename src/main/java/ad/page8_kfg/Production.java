package ad.page8_kfg;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by MattX7 on 16.11.2016.
 */
class Production {
    private NonTerminal left;
    private List<Alphabet> right;

    public Production(NonTerminal left, Alphabet... right) {
        this.left = left;
        this.right = new LinkedList<Alphabet>();
        Collections.addAll(this.right, right);
    }

    public void setLeft(NonTerminal left) {
        this.left = left;
    }

    public void setRight(Alphabet... right) {
        Collections.addAll(this.right, right);
    }

    public NonTerminal getLeft() {  return left; }

    public List<Alphabet> getRight() {
        return this.right;
    }

    public Boolean hasLeft(NonTerminal lefty) {  return getLeft().equals(lefty);}
}
