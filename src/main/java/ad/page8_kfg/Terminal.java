package ad.page8_kfg;

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
}
