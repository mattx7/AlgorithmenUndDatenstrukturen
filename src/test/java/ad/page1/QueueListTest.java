package ad.page1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.testng.Assert.*;

/**
 * Created by Neak on 03.10.2016.
 */
public class QueueListTest {

    private QueueList<Integer> setFull() throws Exception {
        QueueList<Integer> i = new QueueList<Integer>(5);
        for(int j=1;j<=5;j++){
            i.enqueueADT(j);
        }
        return i;
    }

    private QueueList<Integer> setEmpty() throws Exception {
        QueueList<Integer> i = new QueueList<Integer>(5);
        return i;
    }

    @Test
    public void testIsFull() throws Exception {
        QueueList<Integer> i = setFull();
        assertTrue(i.isFullADT());
    }

    @Test
    public void testIsEmpty() throws Exception {
        QueueList<Integer> i = setEmpty();
        assertTrue(i.isEmptyADT());
        QueueList<Integer> k = setFull();
        for(int j=1;j<=5;j++){
            assertEquals((int) k.dequeueADT(),j);
        }
        assertTrue(k.isEmptyADT());
    }



    @Test
    public void testQueueCircle() throws Exception {
        QueueList<Integer> i = setFull();
        assertEquals((int) i.dequeueADT(),1);
        assertEquals((int) i.dequeueADT(),2);
        // Overload
        i.enqueueADT(6);
        i.enqueueADT(7);
        assertTrue(i.isFullADT());
        assertFalse(i.isEmptyADT());
        // Underload
        assertEquals((int) i.dequeueADT(),3);
        assertEquals((int) i.dequeueADT(),4);
        assertEquals((int) i.dequeueADT(),5);
        assertEquals((int) i.dequeueADT(),6);
        assertEquals((int) i.dequeueADT(),7);
        assertTrue(i.isEmptyADT());
        assertFalse(i.isFullADT());
    }

    @Test
    public void testUnderload() throws Exception {
        try {
            QueueList<Integer> i = setEmpty();
            assertTrue(i.isEmptyADT());
            i.dequeueADT();
        }catch (AssertionError ae) {
            assertEquals(ae.getMessage(),"No space left");
        }
    }

    @Test
    public void testOverload() throws Exception {
        try {
            QueueList<Integer> i = setFull();
            assertTrue(i.isFullADT());
            i.enqueueADT(6);
        }catch (AssertionError ae){
            assertEquals(ae.getMessage(),"Is already Full");
        }
    }

    @Test
    public void testNull() throws Exception {
        try {
            QueueList<Integer> i = setEmpty();
            assertTrue(i.isEmptyADT());
            i.enqueueADT(null);
        }catch (AssertionError ae){
            assertEquals(ae.getMessage(),"Not null!");
        }
    }

    /*
     * Tests all Types
     */
    @DataProvider
    public Object[][] queueTypesData(){
        return  new Object[][]{
                {1},
                {'c'},
                {"string"},
                {1.0},
                {BigDecimal.TEN}
        };
    }
    @Test(dataProvider="queueTypesData")
    public void testQueueTypes(Object obj) throws Exception {
        // prepare
        QueueList<Object> o = new QueueList<Object>(5);
        int preCount = o.countADT();
        o.enqueueADT(obj);
        // ASSERTS
        assertEquals(o.countADT(),preCount+1);
        assertEquals(o.dequeueADT(),obj);
        assertEquals(o.countADT(),preCount);
    }

    @Test
    public void testCount() throws Exception {
        QueueList<Integer> i = new QueueList<Integer>(5);
        for(int j=1;j<=3;j++){
            i.enqueue(j);
        }
        assertEquals(i.countADT(),3);
    }

}