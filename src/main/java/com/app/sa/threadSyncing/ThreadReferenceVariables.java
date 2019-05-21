/**
 * 
 */

package com.app.sa.threadSyncing;

/**
 * @author gur40401
 */
public class ThreadReferenceVariables {

    // private static Thread t1 = new
    // Thread ( new ThreadObject ( ),
    // "_T1_" );

    private static ThreadObject tObj = new ThreadObject();

    private static Thread T1 = new Thread(tObj, "**T1**");

    private static Thread T2 = new Thread(tObj, "^^T2^^");

    public static void main(String[] args) {
        T1.start();
        T2.start();
    }

}

class CounterObject {

    // Primitive Data inside Thread
    // Object //
    int ctr = 0;

    public void increment() {
        while (ctr++ < 5) {
            System.out.println("CTR:" + ctr + "::"
                    + Thread.currentThread().getName());
        }
    }
}

class ThreadObject implements Runnable {

    CounterObject obj = new CounterObject();

    @Override
    public void run() {
        // obj.increment ( );

        // <-- OR --> //
        int ctr = 0;
        while (ctr++ < 5) {
            System.out.println("CTR:" + ctr + "::"
                    + Thread.currentThread().getName());
        }

    }
}