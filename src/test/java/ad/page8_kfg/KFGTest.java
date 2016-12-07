package ad.page8_kfg;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by MattX7 on 07.12.2016.
 */
public class KFGTest {

    private KFG testObject;
    private KFG testObject2;
    private NonTerminal S, A, B, C, D;
    private Terminal epsilon, x, y, z;
    private Production S_epsilon, S_ABxC, A_xAy, A_epsilon, B_yBS, B_D, C_epsilon, D_B, D_z;

    @BeforeMethod
    public void setUp() throws Exception {
        testObject2 = new KFGImpl();
//
//        S = new NonTerminal("S");
//        A = new NonTerminal("A");
//        B = new NonTerminal("B");
//        C = new NonTerminal("C");
//        D = new NonTerminal("D");
//
//        x = new Terminal("x");
//        y = new Terminal("y");
//        z = new Terminal("z");
//        epsilon = new Terminal("#");
//
//        S_epsilon = new Production(S, epsilon);
//        S_ABxC = new Production(S, A, B, x, C);
//        A_xAy = new Production(A, x, A, y);
//        A_epsilon = new Production(A, epsilon);
//        B_yBS = new Production(B, y, B, S);
//        B_D = new Production(B, D);
//        C_epsilon = new Production(C, epsilon);
//        D_B = new Production(D, B);
//        D_z = new Production(D, z);
//
//        // Beispiel aus Neikes Folien AF05-KFG Folie 45
//        testObject.addTerminal(x, y, z, epsilon);
//        testObject.addNonTerminal(S, A, B, C, D);
//        testObject.addProduction(S_epsilon, S_ABxC, A_xAy, A_epsilon, B_yBS, B_D, C_epsilon, D_B, D_z);
        testObject = KFG.compile("S->#", "S->ABxC", "A->xAy", "A->#", "B->yBS", "B->D", "C->#", "D->B", "D->z");
        testObject.setStart(S);

        System.out.println(testObject);
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue(testObject2.isEmpty());
        assertTrue(!testObject.isEmpty());
    }

    @Test
    public void testHasNonTerminal() throws Exception {
        assertTrue(testObject.hasNonTerminal(S));
        assertTrue(testObject.hasNonTerminal(A));
        assertTrue(testObject.hasNonTerminal(B));
        assertTrue(testObject.hasNonTerminal(C));
        assertTrue(testObject.hasNonTerminal(D));
    }

    @Test
    public void testHasTerminal() throws Exception {
        assertTrue(testObject.hasTerminal(x));
        assertTrue(testObject.hasTerminal(y));
        assertTrue(testObject.hasTerminal(z));
        assertTrue(testObject.hasTerminal(epsilon));
    }

    @Test
    public void testHasProduction() throws Exception {
        assertTrue(testObject.hasProduction(S_epsilon));
        assertTrue(testObject.hasProduction(S_ABxC));
        assertTrue(testObject.hasProduction(A_xAy));
        assertTrue(testObject.hasProduction(A_epsilon));
        assertTrue(testObject.hasProduction(B_yBS));
        assertTrue(testObject.hasProduction(B_D));
        assertTrue(testObject.hasProduction(C_epsilon));
        assertTrue(testObject.hasProduction(D_B));
        assertTrue(testObject.hasProduction(D_z));
    }

}