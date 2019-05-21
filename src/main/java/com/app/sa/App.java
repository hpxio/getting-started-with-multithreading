
package com.app.sa;


import com.app.sa.basics.UsingRunnableInterface;
import com.app.sa.basics.UsingThreadClass;
import com.app.sa.interruptThreads.InterruptedClass;
import com.app.sa.joinThreads.JoinThreadsA;
import com.app.sa.joinThreads.JoinThreadsB;


@SuppressWarnings ( value = "unused" )
public class App {

    final private static UsingThreadClass threadA = new UsingThreadClass ( );

    final private static Thread threadB = new Thread ( new UsingRunnableInterface ( ) );

    final private static Thread interruptDemo = new Thread ( new InterruptedClass ( ) );

    final private static Thread threadJoinA = new Thread ( new JoinThreadsA ( ) );

    final private static Thread threadJoinB = new Thread ( new JoinThreadsB ( ) );

    /**
     *
     */
    private static void demoInterruptMethod ( ) {
        interruptDemo.setName ( "T003" );

        // Start the thread & throw interrupt at random time interval //
        int sec = ( int ) ( Math.random ( ) * 4 ) + 1;
        System.out.println ( sec );

        interruptDemo.start ( );

        try {
            Thread.sleep ( sec * 1000 );
            // Interfere the thread operation //
            interruptDemo.interrupt ( );
        } catch ( InterruptedException e ) {
            e.printStackTrace ( );
        }

        System.out.println ( "Returned after the interrupt..." );

    }

    /**
     * 
     */
    private static void demoJoinMethod ( ) {
        // Using Thread Class Invocation //
        threadA.setName ( "T001" );
        threadA.start ( );

        try {
            // Second thread waits until 2.5 sec before starting //
            // threadA.join ( 2500 );

            // Uncomment this to make second thread wait until first has completed operation //
            threadA.join ( );

        } catch ( InterruptedException e ) {
            e.printStackTrace ( );
        }

        // Using Thread Class Invocation //
        threadB.setName ( "T002" );
        threadB.start ( );
    }

    /**
     *
     */
    static private void demoTwoThreadJoin ( ) {
        // start the threads //
        threadJoinA.setName ( "T#450-TJoin1" );
        threadJoinA.start ( );

        // After few sec another starts //
        threadJoinB.setName ( "T#231TJoin2" );
        threadJoinB.start ( );

        try {
            threadJoinA.join ( );
        } catch ( InterruptedException e ) {
            e.printStackTrace ( );
        }
    }


    /**
     * Starting point of the main thread.
     *
     * @param args
     */
    public static void main ( String[] args ) {
        // Uncomment this to demo Join() method //
        demoJoinMethod ( );

        // Uncomment this to demo Interrupt() method //
        demoInterruptMethod ( );

        // Uncomment this to demo Join() method in two threads //
        demoTwoThreadJoin ( );
    }
}
