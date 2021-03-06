package ad.page8_kfg;

import org.jetbrains.annotations.NotNull;

/**
 * Created by MattX7 on 16.11.2016.
 */
public class Terminal implements Letter {
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

    @Override
    public String toString() {
        return String.format("%s", id);
    }
}
