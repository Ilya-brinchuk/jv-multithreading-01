package ilya.multithreading.fork;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class ForkJoiner {
    private List<Integer> integers;

    public ForkJoiner(List<Integer> integers) {
        this.integers = integers;
    }

    public int getSum() {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        return forkJoinPool.invoke(new CustomRecursiveTask(integers, 0, integers.size() - 1));
    }

}
