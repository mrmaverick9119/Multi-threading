package Deadlock_11;


/**
 * It can occur in a situation when a thread is waiting for an object's lock,
 * that is acquired by another thread and the second thread is waiting for an
 * object lock that is acquired by first thread. Since, both threads are waiting
 * for each other to release the lock, the condition is called deadlock. If you
 * make sure that all locks are always taken in the same order by any thread,
 * deadlocks cannot occur.
 */


public class App {


    public static void main(String[] args) throws Exception {

        final Runner runner = new Runner();
        
        Thread t1 = new Thread(new Runnable() {

            public void run() {
                try {
                    runner.firstThread();
                } catch (InterruptedException ignored) {}
            }
        });


        Thread t2 = new Thread(new Runnable() {
        
            public void run() {
                try {
                    runner.secondThread();
                } catch (InterruptedException ignored) {}
            }
        });


        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        
        runner.finished();
    }
}
