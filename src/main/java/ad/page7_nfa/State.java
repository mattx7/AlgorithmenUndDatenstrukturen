package ad.page7_nfa;

/**
 * Created by MattX7 on 09.11.2016.
 */
public class State {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public State(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }
}
