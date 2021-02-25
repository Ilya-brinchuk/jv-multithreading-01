package ilya.multithreading.executor;

import org.junit.Before;
import org.junit.Test;
import ilya.multithreading.util.ListCreator;
import static org.junit.Assert.*;

public class SumExecutorServiceTest {
    private SumExecutorService executor;

    @Before
    public void setUp() {
        executor = new SumExecutorService(5, ListCreator.getList(4));
    }

    @Test
    public void getSum_ok() {
        assertEquals(4000000, executor.sumOfList());
    }
}
