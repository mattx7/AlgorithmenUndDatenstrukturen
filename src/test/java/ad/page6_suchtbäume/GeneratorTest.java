package ad.page6_suchtbäume;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by MattX7 on 01.11.2016.
 */
public class GeneratorTest {

    @Test
    public void testGenerate() throws Exception {

    }

    @Test
    public void testGenerateRandomKey() throws Exception {
        System.out.println("=== RandomKeys ===");
        for (int i = 0; i < 100; i++) {
            Double key = Generator.getNewKey();
            assertTrue(key >= 0.0 && key <= 10.0);
            System.out.println(key);
        }
    }

}