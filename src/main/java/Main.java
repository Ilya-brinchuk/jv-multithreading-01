public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        MyRunnable myRunnable = new MyRunnable(counter);
        MyThread myThread = new MyThread(counter);
        new Thread(myThread).start();
        new Thread(myRunnable).start();
    }
}
