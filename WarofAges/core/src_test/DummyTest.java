import com.uysals.game.warofages.GameConfig;

import org.junit.Test;
import static org.junit.Assert.*;

public class DummyTest {

    @Test
    public void testDummy(){
        assertEquals(GameConfig.dummyTest.equals("DummyTest"), true);
    }
}
