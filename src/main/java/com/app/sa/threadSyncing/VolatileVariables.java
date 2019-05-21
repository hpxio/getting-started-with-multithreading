
package com.app.sa.threadSyncing;

/**
 * <p>
 * <b>When to Use Volatile</b><br/>
 * When you absolutely want to assure that the data read/written between threads
 * is a;ways consistent the volatile types are used.Internally it ensures that
 * all the data before reading is written to main memory and written to main
 * memory before reading it.
 * </p>
 */
public class VolatileVariables {

    private static volatile int ctr = 0;

    public static void main(String[] args) {

        new Thread(new Runnable() {

            @Override
            public void run() {
                ctr++;
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                ctr++;
            }
        }).start();

        System.out.println(ctr);
    }
}
