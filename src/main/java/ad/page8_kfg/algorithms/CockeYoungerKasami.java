package ad.page8_kfg.algorithms;

import ad.page8_kfg.KFG;
import ad.page8_kfg.Letter;
import ad.page8_kfg.NonTerminal;
import ad.page8_kfg.Production;

import java.util.*;

/**
 * Created by MattX7 on 07.12.2016.
 * <p>
 * <b>Cocke-Younger-Kasami-Algorithmus</b> for AD
 *
 * @see <a href="https://de.wikipedia.org/wiki/Cocke-Younger-Kasami-Algorithmus"> wikipedia.org</a>
 */
public class CockeYoungerKasami implements Algorithm {

    public boolean isValid;

    private KFG kfg;
    private List<NonTerminal> word;
    private List<List<Set<Letter>>> V;

    /**
     * Initialization of the algorithm. This method has to be called before the
     * {@link #compute()} method to initialize or reset the algorithm according
     * to the new given graph.
     *
     * @param kfg The KFG this algorithm is using.
     */
    public void init(KFG kfg, List<NonTerminal> word) {
//       TODO KFGUtility.isChomskyNormalForm(kfg);
        this.V = new ArrayList<List<Set<Letter>>>();
        this.word = new ArrayList<NonTerminal>();
        this.isValid = false;
        this.kfg = kfg;
        this.word = word;
    }

    /**
     * Run the algorithm. The {@link #init(KFG, List)} method has to be called
     * before computing.
     *
     * @see #init(KFG, List)
     */
    public void compute() {
        // https://de.wikipedia.org/wiki/Cocke-Younger-Kasami-Algorithmus
        for (int i = 0; i < word.size(); i++) { // Für i = 1 ... n
            V.add(i, new LinkedList<Set<Letter>>());
            for (Production production : kfg.getProductions()) { // Für jede Produktion (l->r) aus P

                if (production.hasRight(word.get(i))) { // Falls r = w_i
                    V.get(i).add(1, new HashSet<Letter>());
                    V.get(i).get(1).add(production.getLeft()); // Setzte V_i1 := V_i1 u {l}
                }

            }
        }
        for (int j = 1; j < word.size(); j++) { // Für j = 2...n
            for (int i = 0; i < word.size() - j + 1; i++) { // Für i = 1 ... n - j + 1
                for (int k = 0; k < j - 1; k++) { // Für k = 1...n-j+1
//                    V.get(i).get(j).add()
                }
            }
        }
        if (V.get(1).get(word.size()).contains(kfg.getStart())) { // Falls S in V_1n
            // stoppe und gib "w wird von G erzeugt" aus Stoppe und gib "w wird nicht von G erzeugt" aus
            isValid = true;
        }
    }

    public static void main(String[] args) {

    }
}
