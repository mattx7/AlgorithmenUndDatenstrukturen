package ad.page8_kfg;

import org.jetbrains.annotations.NotNull;

/**
 * Created by MattX7 on 16.11.2016.
 */
class Terminal implements Alphabet {
    private String id;

    public Terminal(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NotNull
    public static Terminal valueOf(@NotNull String terminal) {
        return new Terminal(terminal);
    }
}
