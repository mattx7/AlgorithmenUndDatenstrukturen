package ad.page8_kfg.algorithms;

import ad.page8_kfg.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by MattX7 on 07.12.2016.
 */
public class CockeYoungerKasamiTest {

    private KFG testObject;
    private NonTerminal S, S_, A, B, N, M, O, X, Y;
    private Terminal epsilon, x, y, z;
    private Production S__AN, S__BX, S__epsilon, S_AN, S_BX, A_XM, A_XY, B_YO, B_YB, B_z, N_BX, M_AY, O_BS, X_x, Y_y;
    private List<NonTerminal> word;

    @BeforeMethod
    public void setUp() throws Exception {
        testObject = new KFGImpl();

        S_ = new NonTerminal("S_");
        S = new NonTerminal("S");
        A = new NonTerminal("A");
        B = new NonTerminal("B");
        N = new NonTerminal("N");
        M = new NonTerminal("M");
        O = new NonTerminal("O");
        X = new NonTerminal("X");
        Y = new NonTerminal("Y");

        x = new Terminal("x");
        y = new Terminal("y");
        z = new Terminal("z");
        epsilon = new Terminal("#");


        S__AN = new Production(S_, A, N);
        S__BX = new Production(S_, B, X);
        S__epsilon = new Production(S_, epsilon);
        S_AN = new Production(S, A, N);
        S_BX = new Production(S, B, X);
        A_XM = new Production(A, X, M);
        A_XY = new Production(A, X, Y);
        B_YO = new Production(B, Y, O);
        B_YB = new Production(B, Y, B);
        B_z = new Production(B, z);
        N_BX = new Production(N, B, X);
        M_AY = new Production(M, A, Y);
        O_BS = new Production(O, B, S);
        X_x = new Production(X, x);
        Y_y = new Production(Y, y);

        // Beispiel aus Neikes Folien AF05-KFG Folie 45
        testObject.addTerminal(x, y, z, epsilon);
        testObject.addNonTerminal(S, S_, A, B, N, M, O, X, Y);
        testObject.addProduction(S__AN, S__BX, S__epsilon, S_AN, S_BX, A_XM, A_XY, B_YO, B_YB, B_z, N_BX, M_AY, O_BS, X_x, Y_y);

        word = new ArrayList<NonTerminal>();
        word.add(new NonTerminal("z"));
        word.add(new NonTerminal("x"));
        word.add(new NonTerminal("["));
        word.add(new NonTerminal("("));
        word.add(new NonTerminal(")"));
        word.add(new NonTerminal("]"));
    }

    @Test
    public void testCYK() {
        CockeYoungerKasami cyk = new CockeYoungerKasami();
        cyk.init(testObject, word);
        cyk.compute();
        assertTrue(cyk.isValid);
    }

}