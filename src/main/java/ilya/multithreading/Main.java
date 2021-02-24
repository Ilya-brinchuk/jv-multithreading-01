package ilya.multithreading;

import ilya.multithreading.executor.Executor;
import ilya.multithreading.fork.ForkJoiner;
import ilya.multithreading.threads.MyRunnable;
import ilya.multithreading.threads.MyThread;
import ilya.multithreading.util.Counter;
import ilya.multithreading.util.ListCreator;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        MyRunnable myRunnable = new MyRunnable(counter);
        MyThread myThread = new MyThread(counter);
        myThread.start();
        new Thread(myRunnable).start();

        ForkJoiner forkJoiner = new ForkJoiner(ListCreator.getList(1));
        System.out.println(forkJoiner.getSum());
        Executor executor = new Executor(5, ListCreator.getList(1));
        System.out.println(executor.sumOfList());
    }
}
