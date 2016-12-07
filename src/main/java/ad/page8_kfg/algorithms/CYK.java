package ad.page8_kfg.algorithms;

import ad.page8_kfg.KFG;

/**
 * Created by MattX7 on 07.12.2016.
 */
public class CYK implements Algorithm {

    private KFG kfg;

    /**
     * Initialization of the algorithm. This method has to be called before the
     * {@link #compute()} method to initialize or reset the algorithm according
     * to the new given graph.
     *
     * @param kfg The KFG this algorithm is using.
     */
    public void init(KFG kfg) {
        this.kfg = kfg;

    }

    /**
     * Run the algorithm. The {@link #init(KFG)} method has to be called
     * before computing.
     *
     * @see #init(KFG)
     */
    public void compute() {

    }

    public static void main(String[] args) {

    }
}
