package ad.page8_kfg;

import org.jetbrains.annotations.NotNull;

/**
 * Created by MattX7 on 16.11.2016.
 */
class NonTerminal implements Alphabet {
    private String id;

    public NonTerminal(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NotNull
    public static NonTerminal valueOf(@NotNull String nonTerminal) {
        return new NonTerminal(nonTerminal);
    }
}
