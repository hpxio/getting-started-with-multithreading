
package com.app.sa.threadMemoryModel;

public class HeapAndStack {

    // Referencing the same resource from different threads //
    private static Runnable r = new someOperation ( );

    private static Thread t1 = new Thread ( r, "T001" );

    private static Thread t2 = new Thread ( r, "T002" );


    public static void main ( String[] args ) {
        // Call the threads //
        t1.start ( );
        t2.start ( );
    }
}


class someOperation implements Runnable {

    // Instance variables are always reference typed and are stored in memory heap //
    int i;

    // Intrinsic Locks //
    private Object lock = new Object ( );

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run ( ) {

        synchronized ( lock ) { // OR ( this ) {
            // Primitive and local vars are always stored in the thread's own stack //
            // for ( int i = 10; i > 0; i-- ) {
            // System.out.println ( "Value of i: " + i + "::" + Thread.currentThread ( ).getName ( ) );
            // }

            // Since here the var 'i' is in heap it is shared and used by threads in sharing mode //
            for ( i = 10; i > 0; i-- ) {
                System.out.println ( "Value of i: " + i + "::" + Thread.currentThread ( ).getName ( ) );
            }
        }
    }
}
