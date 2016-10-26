package ad.page1_queue;

import ad.helper.StopWatch;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.testng.Assert.*;

/**
 * Created by MattX7 on 03.10.2016.
 */
public class QueueArrayTest {

    private QueueArray<Integer> setFull() throws Exception {
        QueueArray<Integer> integer = new QueueArray<Integer>(5);
        for(int i=1;i<=5;i++){
            integer.enqueueADT(i);
        }
        return integer;
    }

    private QueueArray<Integer> setEmpty() throws Exception {
        return new QueueArray<Integer>(5);
    }

    @Test
    public void testIsFull() throws Exception {
        QueueArray<Integer> i = setFull();
        assertTrue(i.isFullADT());
    }

    @Test
    public void testIsEmpty() throws Exception {
        QueueArray<Integer> i = setEmpty();
        assertTrue(i.isEmptyADT());
        QueueArray<Integer> k = setFull();
        for(int j=1;j<=5;j++){
            assertEquals((int) k.dequeueADT(),j);
        }
        assertTrue(k.isEmptyADT());
    }



    @Test
    public void testQueueCircle() throws Exception {
        QueueArray<Integer> i = setFull();
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
            QueueArray<Integer> i = setEmpty();
            assertTrue(i.isEmptyADT());
            i.dequeueADT();
        }catch (AssertionError ae) {
            assertEquals(ae.getMessage(),"No space left");
        }
    }

    @Test
    public void testOverload() throws Exception {
        try {
            QueueArray<Integer> i = setFull();
            assertTrue(i.isFullADT());
            i.enqueueADT(6);
        }catch (AssertionError ae){
            assertEquals(ae.getMessage(),"Is already Full");
        }
    }

    @Test
    public void testNull() throws Exception {
        try {
            QueueArray<Integer> i = setEmpty();
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
        QueueArray<Object> o = new QueueArray<Object>(5);
        int preCount = o.countADT();
        o.enqueueADT(obj);
        // ASSERTS
        assertEquals(o.countADT(),preCount+1);
        assertEquals(o.dequeueADT(),obj);
        assertEquals(o.countADT(),preCount);
    }

    @Test
    public void testCount() throws Exception {
        QueueArray<Integer> i = new QueueArray<Integer>(5000000);
        StopWatch sw = new StopWatch();
        System.out.println("===== Runtime ===== ");
        System.out.println("[5.000.000 Elements]");
        sw.start();
        for(int j=1;j<=5000000;j++){
            i.enqueue(j);
        }
        assertEquals(i.countADT(),5000000);
        System.out.println("After Enqueue: "+sw.getActualTime()+"ms");
        for(int j=1;j<=5000000;j++){
            i.dequeue();
        }
        sw.stop();
        System.out.println("After Dequeue: "+sw.getEndTime()+"ms");

    }

}