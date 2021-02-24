package ilya.multithreading.fork;

import org.junit.Before;
import org.junit.Test;
import ilya.multithreading.util.ListCreator;
import static org.junit.Assert.*;

public class ForkJoinerTest {
    private ForkJoiner forkJoiner;

    @Before
    public void setUp() throws Exception {
        forkJoiner = new ForkJoiner(ListCreator.getList(4));
    }

    @Test
    public void getSum_ok() {
        assertEquals(4000000, forkJoiner.getSum());
    }
}