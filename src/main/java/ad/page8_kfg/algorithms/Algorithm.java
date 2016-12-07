package ad.page8_kfg.algorithms;

import ad.page8_kfg.KFG;
import ad.page8_kfg.NonTerminal;

import java.util.List;

/**
 * Created by MattX7 on 07.12.2016.
 */
public interface Algorithm {

    /**
     * Initialization of the algorithm. This method has to be called before the
     * {@link #compute()} method to initialize or reset the algorithm according
     * to the new given graph.
     *
     * @param kfg The KFG this algorithm is using.
     */
    void init(KFG kfg, List<NonTerminal> word);

    /**
     * Run the algorithm. The {@link #init(KFG)} method has to be called
     * before computing.
     *
     * @see #init(KFG)
     */
    void compute();
}
