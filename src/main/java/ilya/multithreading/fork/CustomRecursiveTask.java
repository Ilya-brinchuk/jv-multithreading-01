package ilya.multithreading.fork;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class CustomRecursiveTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 100_000;
    private List<Integer> integers;
    private int start;
    private int end;

    public CustomRecursiveTask(List<Integer> integers, int start, int end) {
        this.integers = integers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if ((end - start) > THRESHOLD) {
            int middle = (start + end) / 2;
            CustomRecursiveTask firstTask = new CustomRecursiveTask(integers, start, middle);
            CustomRecursiveTask secondTask = new CustomRecursiveTask(integers, middle + 1, end);
            firstTask.fork();
            secondTask.fork();
            return firstTask.join() + secondTask.join();
        }
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += integers.get(i);
        }
        return sum;
    }
}
