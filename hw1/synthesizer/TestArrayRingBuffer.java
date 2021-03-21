package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void isEmptyTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(10);
        assertTrue(arb.isEmpty());
        arb.enqueue(0);
        assertFalse(arb.isEmpty());
    }

    @Test
    public void isFullTest(){
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(10);
        assertFalse(arb.isFull());
        for(int i = 0; i < arb.capacity; i++){
            arb.enqueue(i);
        }
        assertTrue(arb.isFull());
    }

    @Test
    public void dequeueTest(){
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(10);
        for(int i = 0; i < arb.capacity; i++){
            arb.enqueue(i);
        }
        assertEquals(new Integer(0),arb.dequeue());

    }

    @Test
    public void peekTest(){
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(10);
        for(int i = 0; i < arb.capacity; i++){
            arb.enqueue(i);
        }
        assertEquals(new Integer(0),arb.peek());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
