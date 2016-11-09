package ad.page4_nfa_sort.nfa;

/**
 * Created by MattX7 on 09.11.2016.
 */
public class Symbol {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Symbol(String id) {

        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }
}
