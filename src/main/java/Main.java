public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        MyRunnable myRunnable = new MyRunnable(counter);
        MyThread myThread = new MyThread(counter);
        myThread.start();
        new Thread(myRunnable).start();
    }
}
