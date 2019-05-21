
package com.app.sa.threadSyncing;

/**
 * <p>
 * <b>When to Use Thread Synchronization</b><br/>
 * When you want to use a shared variable in threads but you
 * want to have a separate copy for all of your threads then
 * ThreadLocal is better choice. If you use Synchronization
 * in such scenarios then the values will be overwritten by
 * different threads depending on the sequence of calling.
 * </p>
 */
public class ThreadSynchronization {

    static SharedClass sharedObject = new SharedClass();

    static SynchronizedSharedClass syncSharedObject = new SynchronizedSharedClass();

    @SuppressWarnings ( "unused" )
    private static void exec(int a) {
        Thread T1 = new Thread(sharedObject);
        Thread T2 = new Thread(sharedObject);
        T1.start();
        T2.start();
    }

    private static void exec(float a) {
        Thread T1 = new Thread(syncSharedObject);
        Thread T2 = new Thread(syncSharedObject);
        T1.start();
        T2.start();
    }

    public static void main(String[] args) {
        // Unsynchronized //
        // exec ( 0 );

        // Synchronized //
        exec(0F);
    }
}

class SharedClass implements Runnable {

    private int ctr = 0;

    @Override
    public void run() {
        while (ctr++ <= 9) {
            System.out.println(ctr + "::"
                    + Thread.currentThread().getName());
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SynchronizedSharedClass implements Runnable {

    private int ctr = 0;

    @Override
    public void run() {
        synchronized (this) {
            System.out.println("CTR::" + ctr);
            while (ctr++ <= 9) {
                System.out.println(ctr + "::"
                        + Thread.currentThread().getName());
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}