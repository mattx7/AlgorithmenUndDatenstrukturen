package ad.page4_nfa_sort.nfa;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by MattX7 on 10.11.2016.
 */
public class NFAImplTest {

    NFAImpl nfa;

    @BeforeMethod
    public void setUp() throws Exception {
        nfa = new NFAImpl();

        State zero = new State("0");
        State one = new State("1");
        State two = new State("2");

        Symbol a = new Symbol("a");
        Symbol b = new Symbol("b");

        TransitionFunction zero_a_zero = new TransitionFunction(zero, a, zero);
        TransitionFunction zero_b_zero = new TransitionFunction(zero, b, zero);
        TransitionFunction zero_a_one = new TransitionFunction(zero, a, one);
        TransitionFunction one_a_two = new TransitionFunction(one, a, two);
        TransitionFunction one_b_two = new TransitionFunction(one, b, two);

        nfa.addStates(zero, one, two);
        nfa.addInputSymbols(a, b);
        nfa.addTransitionFunctions(zero_a_zero, zero_b_zero, zero_a_one, one_a_two, one_b_two);

        nfa.setStart(zero);
        nfa.setEnd(two);
    }

    @Test
    public void testCheckWord() throws Exception {
        Symbol a = new Symbol("a");
        Symbol b = new Symbol("b");
        List<Symbol> word = new LinkedList<Symbol>();
        word.add(a);
        word.add(b);
        assertTrue(nfa.checkWord(word));
    }

}