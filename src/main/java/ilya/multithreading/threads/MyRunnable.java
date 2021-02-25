package ilya.multithreading.threads;

import ilya.multithreading.util.Counter;
import org.apache.log4j.Logger;

public class MyRunnable implements Runnable {
    private static final Logger logger = Logger.getLogger(MyRunnable.class);
    private Counter counter;

    public MyRunnable(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter.getCount() < 100) {
            logger.info(Thread.currentThread().getName() + " value = "
                    + counter.increment());
        }
    }
}
