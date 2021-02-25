package ilya.multithreading.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.commons.collections4.ListUtils;

public class SumExecutorService {
    private int numberOfThread;
    private List<Integer> integers;

    public SumExecutorService(int numberOfThread, List<Integer> integers) {
        this.numberOfThread = numberOfThread;
        this.integers = integers;
    }

    public int sumOfList() {
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThread);
        int sum = 0;
        try {
            List<Future<Integer>> futures = executorService.invokeAll(getCallables());
            executorService.shutdown();
            for (Future<Integer> future: futures) {
                sum += future.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("ilya.multithreading.threads.executor.Executor error", e);
        }
        return sum;
    }

    private List<Callable<Integer>> getCallables() {
        List<List<Integer>> lists = ListUtils.partition(integers, numberOfThread);
        List<Callable<Integer>> callables = new ArrayList<>();
        for (List<Integer> list : lists) {
            callables.add(new CallableImpl(list));
        }
        return callables;
    }
}
