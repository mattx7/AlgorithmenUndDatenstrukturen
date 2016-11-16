package ad.page8_kfg;

import java.util.Collections;
import java.util.List;

/**
 * Created by MattX7 on 16.11.2016.
 */
class Production {
    private NonTerminal left;
    private List<Right> right;

    public Production(NonTerminal left, Right... right) {
        this.left = left;
        Collections.addAll(this.right, right);
    }

    public void setLeft(NonTerminal left) {
        this.left = left;
    }

    public void setRight(Right... right) {
        Collections.addAll(this.right, right);
    }
}
