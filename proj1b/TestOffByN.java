import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestOffByN {
    CharacterComparator offBy0 = new OffByN(0);
    CharacterComparator offBy2 = new OffByN(2);

    @Test
    public void testOffBy2(){
        assertTrue(offBy2.equalChars('a', 'c'));
        assertTrue(offBy2.equalChars('c', 'a'));
        assertFalse(offBy2.equalChars('a', 'a'));
        assertFalse(offBy2.equalChars('a', 'b'));
        assertFalse(offBy2.equalChars('b', 'a'));
    }
    @Test
    public void testEqualsCharBy0() {
        assertTrue(offBy0.equalChars('a', 'a'));
        assertTrue(offBy0.equalChars('b', 'b'));
        assertFalse(offBy0.equalChars('a', 'b'));
        assertFalse(offBy0.equalChars('b', 'a'));
    }

}
