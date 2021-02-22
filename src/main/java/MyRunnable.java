import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import org.apache.log4j.Logger;

public class MyRunnable implements Runnable {
    private static final Logger logger = Logger.getLogger(MyRunnable.class);
    private static final String PATH_FILE = "src/main/resources/test.txt";
    private Counter counter;

    public MyRunnable(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter.getCount() < 100) {
            try {
                String data = Thread.currentThread().getName() + " value = "
                        + counter.getCount() + "\n";
                Files.write(Paths.get(PATH_FILE), data.getBytes(), StandardOpenOption.APPEND);
                counter.increment();
                logger.info(data);
            } catch (IOException e) {
                throw new RuntimeException("Can't write in file by this path: " + PATH_FILE, e);
            }

        }
    }
}
